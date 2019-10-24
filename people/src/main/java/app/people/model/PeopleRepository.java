package app.people.model;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PeopleRepository extends JpaRepository<People, Long>{
	People findByName(String name);
	
}
