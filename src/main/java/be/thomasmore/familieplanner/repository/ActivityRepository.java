package be.thomasmore.familieplanner.repository;

import be.thomasmore.familieplanner.model.Activity;
import org.springframework.data.repository.CrudRepository;

public interface ActivityRepository extends CrudRepository<Activity, Integer> {
}
