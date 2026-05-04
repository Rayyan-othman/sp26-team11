<!DOCTYPE html>
<html>
<head>
  <title>Reviews – AutoBid</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 0; background: #f4f4f4; }
    header { background: #1a1a2e; color: white; padding: 16px 32px; }
    .container { max-width: 800px; margin: 30px auto; padding: 0 20px; }
    h2 { color: #1a1a2e; }
    .review-card { background: white; border-radius: 8px; padding: 20px;
                   margin-bottom: 16px; box-shadow: 0 2px 8px rgba(0,0,0,0.1); }
    .stars { color: #f39c12; font-size: 18px; }
    .comment { color: #333; margin: 8px 0; }
    .reply-box { background: #eaf4fb; border-left: 4px solid #3498db;
                 padding: 12px 16px; margin-top: 12px; border-radius: 0 4px 4px 0; }
    .reply-form { display: flex; gap: 10px; margin-top: 12px; }
    .reply-form input[type=text] { flex: 1; padding: 8px 12px; border: 1px solid #ddd;
                                    border-radius: 4px; font-size: 14px; }
    .btn-reply { padding: 8px 20px; background: #3498db; color: white;
                 border: none; border-radius: 4px; cursor: pointer; font-size: 14px; }
    .back { display: inline-block; margin-bottom: 20px; color: #3498db; text-decoration: none; font-size: 14px; }
    .meta { font-size: 12px; color: #999; }
  </style>
</head>
<body>
<header><strong>AutoBid – Provider Portal</strong></header>
<div class="container">
  <a href="/provider/dashboard" class="back">← Back to Dashboard</a>
  <h2>Reviews for Provider #${providerId}</h2>

  <#if reviews?size == 0>
    <p style="color:#999;">No reviews yet.</p>
  </#if>

  <#list reviews as r>
  <div class="review-card">
    <div class="stars">
      <#list 1..5 as i><#if i <= (r.rating!0)>★<#else>☆</#if></#list>
      <span style="font-size:14px; color:#555; margin-left:8px;">${r.rating!0}/5</span>
    </div>
    <div class="comment">"${r.comment!""}"</div>
    <div class="meta">Service: ${r.service.title!""} | Review #${r.id}</div>

    <!-- Show existing reply if there is one -->
    <#list replies as rep>
      <#if rep.review.id == r.id>
      <div class="reply-box">
        <strong>Your reply:</strong> ${rep.message!""}
      </div>
      </#if>
    </#list>

    <!-- Reply form -->
    <form method="post" action="/provider/reviews/reply" class="reply-form">
      <input type="hidden" name="reviewId"   value="${r.id}">
      <input type="hidden" name="providerId" value="${providerId}">
      <input type="text"   name="message"    placeholder="Write a reply..." required>
      <button type="submit" class="btn-reply">Reply</button>
    </form>
  </div>
  </#list>
</div>
</body>
</html>