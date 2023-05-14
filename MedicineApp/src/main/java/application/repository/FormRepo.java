package application.repository;

import application.enums.Status;
import application.model.Form;
import application.model.Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormRepo extends JpaRepository<Form, Integer> {
    Form findByIdForm(int id);
<<<<<<< HEAD
    List<Form> findByPersonAndStatus(Person person, Status status);
    List<Form> findByStatus(Status status, Sort sort);
    List<Form> findByStatus(Status status);
=======
>>>>>>> b2287e2 (adding concrete form page)
}
