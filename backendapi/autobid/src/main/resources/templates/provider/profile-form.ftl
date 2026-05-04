<!DOCTYPE html>
<html>
<head>
  <title>${editing?then("Edit","New")} Provider – AutoBid</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 0; background: #f4f4f4; }
    header { background: #1a1a2e; color: white; padding: 16px 32px; }
    .container { max-width: 500px; margin: 40px auto; background: white;
                 padding: 32px; border-radius: 8px; box-shadow: 0 2px 8px rgba(0,0,0,0.1); }
    h2 { color: #1a1a2e; margin-top: 0; }
    label { display: block; margin-bottom: 4px; font-weight: bold; color: #555; font-size: 14px; }
    input, select { width: 100%; padding: 10px; margin-bottom: 16px;
                    border: 1px solid #ddd; border-radius: 4px; box-sizing: border-box; font-size: 14px; }
    .btn-submit { width: 100%; padding: 12px; background: #1a1a2e; color: white;
                  border: none; border-radius: 4px; font-size: 15px; cursor: pointer; }
    .btn-submit:hover { background: #2c2c54; }
    .back { display: inline-block; margin-bottom: 20px; color: #3498db; text-decoration: none; font-size: 14px; }
  </style>
</head>
<body>
<header><strong>AutoBid – Provider Portal</strong></header>
<div class="container">
  <a href="/provider/dashboard" class="back">← Back to Dashboard</a>
  <h2>${editing?then("Edit Provider Profile","Create Provider Profile")}</h2>

  <form method="post" action="/provider/profile/save">
    <!-- hidden id for edits -->
    <#if editing && user.id??>
      <input type="hidden" name="id" value="${user.id}">
    </#if>

    <label>Full Name</label>
    <input type="text" name="name" value="${user.name!""}" required placeholder="e.g. John Mechanic">

    <label>Email</label>
    <input type="email" name="email" value="${user.email!""}" required placeholder="e.g. john@autobid.com">

    <label>Account Status</label>
    <select name="accountStatus">
      <option value="ACTIVE"   <#if (user.accountStatus!"") == "ACTIVE">selected</#if>>Active</option>
      <option value="INACTIVE" <#if (user.accountStatus!"") == "INACTIVE">selected</#if>>Inactive</option>
      <option value="BANNED"   <#if (user.accountStatus!"") == "BANNED">selected</#if>>Banned</option>
    </select>

    <!-- role is always PROVIDER, handled by service -->
    <input type="hidden" name="role" value="PROVIDER">

    <button type="submit" class="btn-submit">
      ${editing?then("Save Changes","Create Provider")}
    </button>
  </form>
</div>
</body>
</html>