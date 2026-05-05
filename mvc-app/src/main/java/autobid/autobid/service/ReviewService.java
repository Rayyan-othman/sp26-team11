package autobid.autobid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import autobid.autobid.dto.ReviewRequest;
import autobid.autobid.entity.Review;
import autobid.autobid.entity.ServiceEntity;
import autobid.autobid.entity.User;
import autobid.autobid.repository.ReviewRepository;
import autobid.autobid.repository.ServiceRepository;
import autobid.autobid.repository.UserRepository;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ServiceRepository serviceRepository;

    public ReviewService(ReviewRepository reviewRepository,
                         UserRepository userRepository,
                         ServiceRepository serviceRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.serviceRepository = serviceRepository;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review createReview(ReviewRequest request) {
        User customer = userRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        ServiceEntity service = serviceRepository.findById(request.getServiceId())
                .orElseThrow(() -> new RuntimeException("Service not found"));

        Review review = new Review();
        review.setRating(request.getRating());
        review.setComment(request.getComment());
        review.setCustomer(customer);
        review.setService(service);

        return reviewRepository.save(review);
    }

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    public void deleteReview(Long id) {
        if (!reviewRepository.existsById(id)) {
            throw new RuntimeException("Review not found with id: " + id);
        }
        reviewRepository.deleteById(id);
    }
}