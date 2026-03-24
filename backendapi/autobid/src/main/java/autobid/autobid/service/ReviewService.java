package autobid.autobid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import autobid.autobid.dto.ReviewRequest;
import autobid.autobid.entity.Customer;
import autobid.autobid.entity.Review;
import autobid.autobid.entity.ServiceEntity;
import autobid.autobid.repository.CustomerRepository;
import autobid.autobid.repository.ReviewRepository;
import autobid.autobid.repository.ServiceRepository;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final CustomerRepository customerRepository;
    private final ServiceRepository serviceRepository;

    public ReviewService(ReviewRepository reviewRepository,
                         CustomerRepository customerRepository,
                         ServiceRepository serviceRepository) {
        this.reviewRepository = reviewRepository;
        this.customerRepository = customerRepository;
        this.serviceRepository = serviceRepository;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review createReview(ReviewRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
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
}