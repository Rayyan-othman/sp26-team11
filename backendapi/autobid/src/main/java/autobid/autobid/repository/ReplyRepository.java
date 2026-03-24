package autobid.autobid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import autobid.autobid.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findByProviderId(Long providerId);
}
