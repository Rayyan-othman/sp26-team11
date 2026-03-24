package com.backendapi.autobid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionApiController {

    private final SubscriptionService subscriptionService;

    public SubscriptionApiController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/")
    public ResponseEntity<Subscription> createSubscription(@RequestBody SubscriptionRequest request) {
        Subscription subscription = subscriptionService.createSubscription(request);
        if (subscription != null) {
            return ResponseEntity.ok(subscription);
        }
        return ResponseEntity.badRequest().build();
    }
}