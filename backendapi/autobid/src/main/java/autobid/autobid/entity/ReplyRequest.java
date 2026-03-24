package autobid.autobid.entity;

public class ReplyRequest {
    private String message;
    private Long reviewId;
    private Long providerId;

    public ReplyRequest() {}

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Long getReviewId() { return reviewId; }
    public void setReviewId(Long reviewId) { this.reviewId = reviewId; }

    public Long getProviderId() { return providerId; }
    public void setProviderId(Long providerId) { this.providerId = providerId; }
}