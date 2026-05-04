<!DOCTYPE html>
<html>
<head>
  <title>Statistics – AutoBid</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 0; background: #f4f4f4; }
    header { background: #1a1a2e; color: white; padding: 16px 32px; }
    .container { max-width: 700px; margin: 40px auto; padding: 0 20px; }
    h2 { color: #1a1a2e; }
    .stats-grid { display: grid; grid-template-columns: repeat(3, 1fr); gap: 20px; margin-top: 20px; }
    .stat-card { background: white; border-radius: 8px; padding: 24px;
                 box-shadow: 0 2px 8px rgba(0,0,0,0.1); text-align: center; }
    .stat-card .number { font-size: 48px; font-weight: bold; color: #1a1a2e; }
    .stat-card .label  { font-size: 14px; color: #777; margin-top: 8px; }
    .back { display: inline-block; margin-bottom: 20px; color: #3498db; text-decoration: none; font-size: 14px; }
  </style>
</head>
<body>
<header><strong>AutoBid – Provider Portal</strong></header>
<div class="container">
  <a href="/provider/dashboard" class="back">← Back to Dashboard</a>
  <h2>Statistics for Provider #${providerId}</h2>

  <div class="stats-grid">
    <div class="stat-card">
      <div class="number">${stats.servicesCreated!0}</div>
      <div class="label">Services Created</div>
    </div>
    <div class="stat-card">
      <div class="number">${stats.bookingsForProvider!0}</div>
      <div class="label">Total Bookings</div>
    </div>
    <div class="stat-card">
      <div class="number">${stats.reviewsForProvider!0}</div>
      <div class="label">Reviews Received</div>
    </div>
  </div>
</div>
</body>
</html>