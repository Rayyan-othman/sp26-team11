package autobid.autobid.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import autobid.autobid.entity.ServiceEntity;
import autobid.autobid.service.ServiceService;

@RestController
@RequestMapping("/api/services")
public class ServiceApiController {

    private final ServiceService serviceService;

    public ServiceApiController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping("/")
    public List<ServiceEntity> getAllServices() {
        return serviceService.getAllServices();
    }
}