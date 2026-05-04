package autobid.autobid.dto;

public class ProviderStatsResponse {
    private Long providerId;
    private Long servicesCreated;
    private Long bookingsForProvider; // optional for now
    private Long reviewsForProvider;

    public ProviderStatsResponse(Long providerId, Long servicesCreated, Long bookingsForProvider, Long reviewsForProvider) {
        this.providerId = providerId;
        this.servicesCreated = servicesCreated;
        this.bookingsForProvider = bookingsForProvider;
        this.reviewsForProvider = reviewsForProvider;
    }

    public Long getProviderId() { return providerId; }
    public Long getServicesCreated() { return servicesCreated; }
    public Long getBookingsForProvider() { return bookingsForProvider; }
    public Long getReviewsForProvider() { return reviewsForProvider; }
}
