package autobid.autobid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import autobid.autobid.entity.ServiceEntity;
import autobid.autobid.repository.ServiceRepository;

@Service
public class ServiceService {

    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<ServiceEntity> getAllServices() {
        return serviceRepository.findAll();
    }

    public ServiceEntity saveService(ServiceEntity service) {
        return serviceRepository.save(service);
    }

    public void deleteService(Long id) {
        if (!serviceRepository.existsById(id)) {
            throw new RuntimeException("Service not found with id: " + id);
        }

        serviceRepository.deleteById(id);
    }
}