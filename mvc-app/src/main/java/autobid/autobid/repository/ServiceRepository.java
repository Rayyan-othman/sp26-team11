package autobid.autobid.repository;

import autobid.autobid.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {
}