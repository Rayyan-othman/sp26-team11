package autobid.autobid.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import autobid.autobid.dto.ReplyRequest;
import autobid.autobid.entity.Reply;
import autobid.autobid.service.ProviderService;

@RestController
@RequestMapping("/api/replies")
@CrossOrigin(origins = "*")
public class ReplyApiController {

    private final ProviderService providerService;

    public ReplyApiController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping("/provider/{providerId}")
    public ResponseEntity<List<Reply>> getRepliesByProvider(@PathVariable Long providerId) {
        return ResponseEntity.ok(providerService.getRepliesByProvider(providerId));
    }

    @PostMapping
    public ResponseEntity<Reply> createReply(@RequestBody ReplyRequest request) {
        try {
            return ResponseEntity.ok(providerService.replyToReview(request));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}