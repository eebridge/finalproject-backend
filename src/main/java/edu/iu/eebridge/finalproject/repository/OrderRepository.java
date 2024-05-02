package edu.iu.eebridge.finalproject.repository;


import edu.iu.eebridge.finalproject.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, String> {
    Order save (Order order);

    default Iterable<Order> findAllByUsername(String username) throws IOException {
        List<Order> result = new ArrayList<>();

        List<Order> allOrders = (List<Order>) findAll();
        for (Order o : allOrders) {
            if (o.getUsername().equals(username)) {
                result.add(o);
            }
        }

        return result;
    }
}
