<!DOCTYPE html>
<html>
<head>
  <title>Provider Dashboard – AutoBid</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 0; background: #f4f4f4; }
    header { background: #1a1a2e; color: white; padding: 16px 32px; }
    header a { color: #e0e0e0; text-decoration: none; margin-right: 20px; }
    .container { max-width: 900px; margin: 30px auto; padding: 0 20px; }
    h2 { color: #1a1a2e; }
    table { width: 100%; border-collapse: collapse; background: white;
            border-radius: 8px; overflow: hidden; box-shadow: 0 2px 8px rgba(0,0,0,0.1); }
    th { background: #1a1a2e; color: white; padding: 12px; text-align: left; }
    td { padding: 12px; border-bottom: 1px solid #eee; }
    tr:last-child td { border-bottom: none; }
    .btn { padding: 6px 14px; border: none; border-radius: 4px;
           cursor: pointer; text-decoration: none; font-size: 13px; }
    .btn-blue  { background: #3498db; color: white; }
    .btn-green { background: #27ae60; color: white; }
    .btn-red   { background: #e74c3c; color: white; }
    .btn-gray  { background: #7f8c8d; color: white; }
    .top-bar { display: flex; justify-content: space-between; align-items: center; }
  </style>
</head>
<body>

<header>
  <strong>AutoBid – Provider Portal</strong>
  <span style="float:right;">
    <a href="/provider/dashboard">Dashboard</a>
  </span>
</header>

<div class="container">

  <div class="top-bar">
    <h2>Provider Accounts</h2>
    <a href="/provider/profile/new" class="btn btn-green">+ New Provider</a>
  </div>

  <table>
    <thead>
      <tr>
        <th>ID</th><th>Name</th><th>Email</th><th>Status</th><th>Actions</th>
      </tr>
    </thead>
    <tbody>

      <#if providerUsers?has_content>
        <#list providerUsers as u>
        <tr>
          <td>${u.id}</td>
          <td>${u.name!""}</td>
          <td>${u.email!""}</td>
          <td>${u.accountStatus!""}</td>
          <td>
            <a href="/provider/profile/edit/${u.id}" class="btn btn-blue">Edit</a>

            <!-- ✅ ADDED BUTTON (ONLY CHANGE) -->
            <a href="/provider/services/${u.id}" class="btn btn-gray">Services</a>

            <form method="post" action="/provider/profile/delete/${u.id}" style="display:inline">
              <button type="submit" class="btn btn-red"
                      onclick="return confirm('Delete this provider?')">
                Delete
              </button>
            </form>
          </td>
        </tr>
        </#list>
      <#else>
        <tr>
          <td colspan="5" style="text-align:center; color:#999;">
            No providers yet.
          </td>
        </tr>
      </#if>

    </tbody>
  </table>

</div>
</body>
</html>