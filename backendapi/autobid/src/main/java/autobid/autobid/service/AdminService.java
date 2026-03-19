package autobid.autobid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import autobid.autobid.dto.AdminStatsResponse;
import autobid.autobid.entity.Review;
import autobid.autobid.entity.ServiceEntity;
import autobid.autobid.entity.User;
import autobid.autobid.repository.ReviewRepository;
import autobid.autobid.repository.ServiceRepository;
import autobid.autobid.repository.UserRepository;

@Service
public class AdminService {

    private final UserRepository userRepository;
    private final ServiceRepository serviceRepository;
    private final ReviewRepository reviewRepository;

    public AdminService(UserRepository userRepository,
                        ServiceRepository serviceRepository,
                        ReviewRepository reviewRepository) {
        this.userRepository = userRepository;
        this.serviceRepository = serviceRepository;
        this.reviewRepository = reviewRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUserStatus(Long id, String status) {
        User user = userRepository.findById(id).orElseThrow();
        user.setAccountStatus(status);
        return userRepository.save(user);
    }

    public List<ServiceEntity> getAllServices() {
        return serviceRepository.findAll();
    }

    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public List<Review> getReviewsByService(Long serviceId) {
        return reviewRepository.findByServiceId(serviceId);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    public AdminStatsResponse getStatistics() {
        return new AdminStatsResponse(
                userRepository.count(),
                serviceRepository.count(),
                reviewRepository.count()
        );
    }
}