package autobid.autobid.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "replies")
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private User provider;

    public Reply() {}

    public Reply(String message, Review review, User provider) {
        this.message = message;
        this.review = review;
        this.provider = provider;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Review getReview() { return review; }
    public void setReview(Review review) { this.review = review; }

    public User getProvider() { return provider; }
    public void setProvider(User provider) { this.provider = provider; }
}
