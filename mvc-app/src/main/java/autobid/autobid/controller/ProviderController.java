package autobid.autobid.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import autobid.autobid.dto.ProviderStatsResponse;
import autobid.autobid.dto.ReplyRequest;
import autobid.autobid.entity.Reply;
import autobid.autobid.entity.Review;
import autobid.autobid.entity.ServiceEntity;
import autobid.autobid.entity.User;
import autobid.autobid.service.ProviderService;

@RestController
@RequestMapping("/api/provider")
public class ProviderController {

    private final ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    // Provider profile
    @PostMapping("/users")
    public User createProvider(@RequestBody User provider) {
        return providerService.createOrUpdateProvider(provider);
    }

    @PutMapping("/users/{id}")
    public User updateProvider(@PathVariable Long id, @RequestBody User provider) {
        return providerService.updateProvider(id, provider);
    }

    @DeleteMapping("/users/{id}")
    public void deleteProvider(@PathVariable Long id) {
        providerService.deleteProvider(id);
    }

    // Services
    @PostMapping("/services")
    public ServiceEntity createService(@RequestBody ServiceEntity service) {
        return providerService.createService(service);
    }

    @PutMapping("/services/{id}")
    public ServiceEntity updateService(@PathVariable Long id, @RequestBody ServiceEntity service) {
        return providerService.updateService(id, service);
    }

    @GetMapping("/services/{providerId}")
    public List<ServiceEntity> getServicesByProvider(@PathVariable Long providerId) {
        return providerService.getServicesByProvider(providerId);
    }

    // Stats
    @GetMapping("/statistics/{providerId}")
    public ProviderStatsResponse getProviderStats(@PathVariable Long providerId) {
        return providerService.getProviderStats(providerId);
    }

    // Reviews
    @GetMapping("/reviews/{providerId}")
    public List<Review> getReviewsByProvider(@PathVariable Long providerId) {
        return providerService.getReviewsByProvider(providerId);
    }

    // Replies
    @PostMapping("/replies")
    public Reply replyToReview(@RequestBody ReplyRequest request) {
        return providerService.replyToReview(request);
    }

    @GetMapping("/replies/{providerId}")
    public List<Reply> getRepliesByProvider(@PathVariable Long providerId) {
        return providerService.getRepliesByProvider(providerId);
    }
}
