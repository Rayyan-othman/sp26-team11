package com.backendapi.autobid;

import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final CustomerRepository customerRepository;
    private final ServiceRepository serviceRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository,
                               CustomerRepository customerRepository,
                               ServiceRepository serviceRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.customerRepository = customerRepository;
        this.serviceRepository = serviceRepository;
    }

    public Subscription createSubscription(SubscriptionRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId()).orElse(null);
        ServiceEntity service = serviceRepository.findById(request.getServiceId()).orElse(null);

        if (customer == null || service == null) {
            return null;
        }

        Subscription subscription = new Subscription();
        subscription.setCustomer(customer);
        subscription.setService(service);
        subscription.setStartDate(request.getStartDate());

        return subscriptionRepository.save(subscription);
    }
}