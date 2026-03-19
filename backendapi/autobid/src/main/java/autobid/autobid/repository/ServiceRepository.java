package autobid.autobid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import autobid.autobid.entity.ServiceEntity;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {
}