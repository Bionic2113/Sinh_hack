package application.repository;

import application.enums.Status;
import application.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {
    Person findByIdPeople(int id);
    List<Person> findAllByStatus(Status status);
    List<Person> findAllByMedDocument(int doc);
}
