<!DOCTYPE html>
<html>
<head>
  <title>Services – AutoBid</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 0; background: #f4f4f4; }
    header { background: #1a1a2e; color: white; padding: 16px 32px; }
    .container { max-width: 900px; margin: 30px auto; padding: 0 20px; }
    h2 { color: #1a1a2e; }
    table { width: 100%; border-collapse: collapse; background: white;
            border-radius: 8px; overflow: hidden; box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            margin-bottom: 40px; }
    th { background: #1a1a2e; color: white; padding: 12px; text-align: left; }
    td { padding: 12px; border-bottom: 1px solid #eee; }
    .form-card { background: white; padding: 24px; border-radius: 8px;
                 box-shadow: 0 2px 8px rgba(0,0,0,0.1); }
    label { display: block; font-weight: bold; color: #555; font-size: 14px; margin-bottom: 4px; }
    input, select, textarea { width: 100%; padding: 10px; margin-bottom: 16px;
                               border: 1px solid #ddd; border-radius: 4px;
                               box-sizing: border-box; font-size: 14px; }
    .btn-submit { padding: 12px 28px; background: #27ae60; color: white;
                  border: none; border-radius: 4px; cursor: pointer; font-size: 14px; }
    .back { display: inline-block; margin-bottom: 20px; color: #3498db; text-decoration: none; font-size: 14px; }
    .badge { padding: 3px 10px; border-radius: 12px; font-size: 12px; font-weight: bold; }
    .badge-avail { background: #d5f5e3; color: #1e8449; }
    .badge-unavail { background: #fadbd8; color: #922b21; }
  </style>
</head>

<body>
<header><strong>AutoBid – Provider Portal</strong></header>

<div class="container">
  <a href="/provider/dashboard" class="back">← Back to Dashboard</a>

  <h2>Services for Provider #${providerId}</h2>

  <!-- SERVICES TABLE -->
  <table>
    <thead>
      <tr>
        <th>ID</th><th>Title</th><th>Category</th><th>Price</th><th>Availability</th>
      </tr>
    </thead>

    <tbody>
      <#list services as s>
      <tr>
        <td>${s.id}</td>
        <td>${s.title!""}</td>
        <td>${s.category!""}</td>
        <td>$${s.price!0}</td>
        <td>
          <span class="badge <#if (s.availability!"") == "Available">badge-avail<#else>badge-unavail</#if>">
            ${s.availability!"Unknown"}
          </span>
        </td>
      </tr>
      </#list>

      <#if services?size == 0>
      <tr>
        <td colspan="5" style="text-align:center;color:#999;">No services yet.</td>
      </tr>
      </#if>
    </tbody>
  </table>

  <!-- ADD SERVICE FORM (FIXED → USES API) -->
  <div class="form-card">
    <h2 style="margin-top:0;">Add New Service</h2>

    <form id="serviceForm">

      <label>Title</label>
      <input type="text" id="title" required>

      <label>Description</label>
      <textarea id="description" rows="3"></textarea>

      <label>Price ($)</label>
      <input type="number" id="price" step="0.01" min="0" required>

      <label>Category</label>
      <select id="category">
        <option value="Mechanic">Mechanic</option>
        <option value="Detailing">Detailing</option>
        <option value="Repair">Repair</option>
        <option value="Other">Other</option>
      </select>

      <label>Availability</label>
      <select id="availability">
        <option value="Available">Available</option>
        <option value="Unavailable">Unavailable</option>
      </select>

      <button type="submit" class="btn-submit">Add Service</button>
    </form>
  </div>
</div>

<!-- JAVASCRIPT → CALLS YOUR API -->
<script>
document.getElementById("serviceForm").addEventListener("submit", async function(e) {
    e.preventDefault();

    const providerId = Number("${providerId}");

    const payload = {
        title: document.getElementById("title").value,
        description: document.getElementById("description").value,
        price: parseFloat(document.getElementById("price").value),
        category: document.getElementById("category").value,
        availability: document.getElementById("availability").value,
        provider: {
            id: providerId
        }
    };

    try {
        const res = await fetch("http://localhost:8080/api/provider/services", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(payload)
        });

        if (!res.ok) {
            throw new Error("API error");
        }

        alert("Service added successfully!");
        location.reload();

    } catch (err) {
        console.error(err);
        alert("Failed to add service");
    }
});
</script>

</body>
</html>