package autobid.autobid.controller;

import autobid.autobid.dto.AdminStatsResponse;
import autobid.autobid.entity.Review;
import autobid.autobid.entity.ServiceEntity;
import autobid.autobid.entity.User;
import autobid.autobid.service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return adminService.getAllUsers();
    }

    @PutMapping("/users/{id}/status")
    public User updateUserStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
        return adminService.updateUserStatus(id, body.get("accountStatus"));
    }

    @GetMapping("/services")
    public List<ServiceEntity> getServices() {
        return adminService.getAllServices();
    }

    @DeleteMapping("/services/{id}")
    public void deleteService(@PathVariable Long id) {
        adminService.deleteService(id);
    }

    @GetMapping("/reviews")
    public List<Review> getReviews() {
        return adminService.getAllReviews();
    }

    @GetMapping("/services/{serviceId}/reviews")
    public List<Review> getReviewsByService(@PathVariable Long serviceId) {
        return adminService.getReviewsByService(serviceId);
    }

    @DeleteMapping("/reviews/{id}")
    public void deleteReview(@PathVariable Long id) {
        adminService.deleteReview(id);
    }

    @GetMapping("/statistics")
    public AdminStatsResponse getStatistics() {
        return adminService.getStatistics();
    }
}