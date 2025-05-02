package be.thomasmore.familieplanner.repository;

import be.thomasmore.familieplanner.model.GroceryList;
import org.springframework.data.repository.CrudRepository;

public interface GroceryRepository extends CrudRepository <GroceryList, Long> {
}
