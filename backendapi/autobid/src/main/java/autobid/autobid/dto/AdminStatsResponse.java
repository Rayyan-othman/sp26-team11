package autobid.autobid.dto;

public class AdminStatsResponse {

    private long totalUsers;
    private long totalServices;
    private long totalReviews;

    public AdminStatsResponse(long totalUsers, long totalServices, long totalReviews) {
        this.totalUsers = totalUsers;
        this.totalServices = totalServices;
        this.totalReviews = totalReviews;
    }

    public long getTotalUsers() {
        return totalUsers;
    }

    public long getTotalServices() {
        return totalServices;
    }

    public long getTotalReviews() {
        return totalReviews;
    }
}