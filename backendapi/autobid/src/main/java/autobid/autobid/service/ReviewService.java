package com.backendapi.autobid;

import org.springframework.stereotype.Service;

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

    public Review createReview(ReviewRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId()).orElse(null);
        ServiceEntity service = serviceRepository.findById(request.getServiceId()).orElse(null);

        if (customer == null || service == null) {
            return null;
        }

        Review review = new Review();
        review.setCustomer(customer);
        review.setService(service);
        review.setRating(request.getRating());
        review.setComment(request.getComment());

        return reviewRepository.save(review);
    }
}