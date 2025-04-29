package be.thomasmore.familieplanner.repository;

import be.thomasmore.familieplanner.model.Tasks;
import org.springframework.data.repository.CrudRepository;

public interface TasksRepository extends CrudRepository<Tasks, Integer> {

}
