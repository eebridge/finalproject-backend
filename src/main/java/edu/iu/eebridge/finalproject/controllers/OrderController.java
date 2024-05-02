package edu.iu.eebridge.finalproject.controllers;

import edu.iu.eebridge.finalproject.model.Customer;
import edu.iu.eebridge.finalproject.model.Order;
import edu.iu.eebridge.finalproject.repository.CustomerRepository;
import edu.iu.eebridge.finalproject.repository.OrderRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/orders")
public class OrderController {
    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {this.orderRepository = orderRepository;}

    @PostMapping
    public boolean add(@RequestBody Order order) {
        try {
            String username = getTheCurrentCustomer();
            order.setUsername(username);
            orderRepository.save(order);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private String getTheCurrentCustomer() {
        Object principal = SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        String username = "";
        if(principal instanceof Jwt) {
            username = ((Jwt) principal).getSubject();
        }
        return username;
    }

    @GetMapping("/{customerId}")
    public Iterable<Order> getOrders(@PathVariable String customerId) {
        try {
            return orderRepository.findAllByUsername(customerId);
        } catch (Exception e) {
            return null;
        }
    }
}
