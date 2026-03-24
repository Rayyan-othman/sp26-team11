package autobid.autobid.controller;
import autobid.autobid.entity.Review;
import autobid.autobid.service.ReviewService;
import autobid.autobid.dto.ReviewRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reviews")
public class ReviewApiController {

    private final ReviewService reviewService;

    public ReviewApiController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/")
    public ResponseEntity<Review> createReview(@RequestBody ReviewRequest request) {
        Review review = reviewService.createReview(request);
        if (review != null) {
            return ResponseEntity.ok(review);
        }
        return ResponseEntity.badRequest().build();
    }
}