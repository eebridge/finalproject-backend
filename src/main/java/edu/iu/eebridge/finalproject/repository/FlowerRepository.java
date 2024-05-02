package edu.iu.eebridge.finalproject.repository;


import edu.iu.eebridge.finalproject.model.Flower;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowerRepository extends CrudRepository<Flower, String> {
}
