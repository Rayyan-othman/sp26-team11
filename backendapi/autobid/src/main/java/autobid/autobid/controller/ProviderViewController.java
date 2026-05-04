package autobid.autobid.controller;

import autobid.autobid.dto.ReplyRequest;
import autobid.autobid.entity.ServiceEntity;
import autobid.autobid.entity.User;
import autobid.autobid.repository.UserRepository;
import autobid.autobid.service.ProviderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/provider")
public class ProviderViewController {

    private final ProviderService providerService;
    private final UserRepository userRepository;

    public ProviderViewController(ProviderService providerService,
                                  UserRepository userRepository) {
        this.providerService = providerService;
        this.userRepository = userRepository;
    }

    // ── DASHBOARD ──────────────────────────────────────────────
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("providerUsers",
            userRepository.findAll().stream()
                .filter(u -> "PROVIDER".equals(u.getRole()))
                .toList());
        return "provider/dashboard";
    }

    // ── USE CASE 1: Create / Edit Provider Profile ──────────────
    @GetMapping("/profile/new")
    public String newProfileForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("editing", false);
        return "provider/profile-form";
    }

    @GetMapping("/profile/edit/{id}")
    public String editProfileForm(@PathVariable Long id, Model model) {
        User user = userRepository.findById(id).orElseThrow();
        model.addAttribute("user", user);
        model.addAttribute("editing", true);
        return "provider/profile-form";
    }

    @PostMapping("/profile/save")
    public String saveProfile(@ModelAttribute User user) {
        if (user.getId() == null) {
            providerService.createOrUpdateProvider(user);
        } else {
            providerService.updateProvider(user.getId(), user);
        }
        return "redirect:/provider/dashboard";
    }

    @PostMapping("/profile/delete/{id}")
    public String deleteProfile(@PathVariable Long id) {
        providerService.deleteProvider(id);
        return "redirect:/provider/dashboard";
    }

    // ── USE CASE 2: Create / View Services ──────────────────────
    @GetMapping("/services/{providerId}")
    public String showServices(@PathVariable Long providerId, Model model) {
        model.addAttribute("services",
            providerService.getServicesByProvider(providerId));
        model.addAttribute("providerId", providerId);
        model.addAttribute("newService", new ServiceEntity());
        return "provider/services";
    }

    @PostMapping("/services/save/{providerId}")
    public String saveService(@PathVariable Long providerId,
                              @ModelAttribute ServiceEntity service) {

        // Attach provider as a User
        User provider = userRepository.findById(providerId).orElseThrow();
        service.setProvider(provider);

        providerService.createService(service);
        return "redirect:/provider/services/" + providerId;
    }

    // ── USE CASE 3: View Statistics ──────────────────────────────
    @GetMapping("/stats/{providerId}")
    public String showStats(@PathVariable Long providerId, Model model) {
        model.addAttribute("stats",
            providerService.getProviderStats(providerId));
        model.addAttribute("providerId", providerId);
        return "provider/stats";
    }

    // ── USE CASE 4: View Reviews & Reply ────────────────────────
    @GetMapping("/reviews/{providerId}")
    public String showReviews(@PathVariable Long providerId, Model model) {
        model.addAttribute("reviews",
            providerService.getReviewsByProvider(providerId));
        model.addAttribute("replies",
            providerService.getRepliesByProvider(providerId));
        model.addAttribute("providerId", providerId);
        return "provider/reviews";
    }

    @PostMapping("/reviews/reply")
    public String replyToReview(@RequestParam Long reviewId,
                                @RequestParam Long providerId,
                                @RequestParam String message) {
        ReplyRequest req = new ReplyRequest();
        req.setReviewId(reviewId);
        req.setProviderId(providerId);
        req.setMessage(message);
        providerService.replyToReview(req);
        return "redirect:/provider/reviews/" + providerId;
    }
}
