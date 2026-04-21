package autobid.autobid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import autobid.autobid.entity.ServiceEntity;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {

  
    boolean existsByProviderId(Long providerId);
}