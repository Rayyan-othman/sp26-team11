package autobid.autobid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import autobid.autobid.dto.ReviewRequest;
import autobid.autobid.entity.Review;
import autobid.autobid.entity.ServiceEntity;
import autobid.autobid.repository.ReviewRepository;
import autobid.autobid.repository.ServiceRepository;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ServiceRepository serviceRepository;

    public ReviewService(ReviewRepository reviewRepository, ServiceRepository serviceRepository) {
        this.reviewRepository = reviewRepository;
        this.serviceRepository = serviceRepository;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + id));
    }

    public Review createReview(ReviewRequest request) {
        ServiceEntity service = serviceRepository.findById(request.getServiceId())
                .orElseThrow(() -> new RuntimeException("Service not found with id: " + request.getServiceId()));

        Review review = new Review();
        review.setComment(request.getComment());
        review.setRating(request.getRating());
        review.setService(service);

        return reviewRepository.save(review);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}