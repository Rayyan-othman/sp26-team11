package autobid.autobid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import autobid.autobid.dto.ProviderStatsResponse;
import autobid.autobid.dto.ReplyRequest;
import autobid.autobid.entity.Reply;
import autobid.autobid.entity.Review;
import autobid.autobid.entity.ServiceEntity;
import autobid.autobid.entity.User;
import autobid.autobid.repository.ReplyRepository;
import autobid.autobid.repository.ReviewRepository;
import autobid.autobid.repository.ServiceRepository;
import autobid.autobid.repository.UserRepository;

@Service
public class ProviderService {

    private final UserRepository userRepository;
    private final ServiceRepository serviceRepository;
    private final ReviewRepository reviewRepository;
    private final ReplyRepository replyRepository;

    public ProviderService(UserRepository userRepository,
                           ServiceRepository serviceRepository,
                           ReviewRepository reviewRepository,
                           ReplyRepository replyRepository) {
        this.userRepository = userRepository;
        this.serviceRepository = serviceRepository;
        this.reviewRepository = reviewRepository;
        this.replyRepository = replyRepository;
    }

    // Provider profile
    public User createOrUpdateProvider(User provider) {
        provider.setRole("PROVIDER");
        return userRepository.save(provider);
    }

    public User updateProvider(Long id, User updated) {
        User existing = userRepository.findById(id).orElseThrow();
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setAccountStatus(updated.getAccountStatus());
        existing.setRole("PROVIDER");
        return userRepository.save(existing);
    }

    public void deleteProvider(Long id) {
        userRepository.deleteById(id);
    }

    // Services
    public ServiceEntity createService(ServiceEntity service) {
        return serviceRepository.save(service);
    }

    public ServiceEntity updateService(Long id, ServiceEntity updated) {
        ServiceEntity existing = serviceRepository.findById(id).orElseThrow();
        existing.setTitle(updated.getTitle());
        existing.setDescription(updated.getDescription());
        existing.setPrice(updated.getPrice());
        return serviceRepository.save(existing);
    }

    public List<ServiceEntity> getServicesByProvider(Long providerId) {
        return serviceRepository.findAll().stream()
                .filter(s -> s.getProvider() != null && s.getProvider().getId().equals(providerId))
                .toList();
    }

    // Stats
    public ProviderStatsResponse getProviderStats(Long providerId) {
        long servicesCreated = serviceRepository.findAll().stream()
                .filter(s -> s.getProvider() != null && s.getProvider().getId().equals(providerId))
                .count();
        long reviewsForProvider = reviewRepository.findAll().stream()
                .filter(r -> r.getService().getProvider() != null && r.getService().getProvider().getId().equals(providerId))
                .count();
        return new ProviderStatsResponse(providerId, servicesCreated, 0L, reviewsForProvider);
    }

    // Reviews
    public List<Review> getReviewsByProvider(Long providerId) {
        return reviewRepository.findAll().stream()
                .filter(r -> r.getService().getProvider() != null && r.getService().getProvider().getId().equals(providerId))
                .toList();
    }

    // Replies
    public Reply replyToReview(ReplyRequest req) {
        Review review = reviewRepository.findById(req.getReviewId()).orElseThrow();
        User provider = userRepository.findById(req.getProviderId()).orElseThrow();

        Reply reply = new Reply();
        reply.setMessage(req.getMessage());
        reply.setReview(review);
        reply.setProvider(provider);

        return replyRepository.save(reply);
    }

    public List<Reply> getRepliesByProvider(Long providerId) {
        return replyRepository.findByProviderId(providerId);
    }
}