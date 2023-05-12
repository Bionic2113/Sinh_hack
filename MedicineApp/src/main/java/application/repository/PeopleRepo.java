package application.repository;

import application.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepo extends JpaRepository<People, Integer> {
}
