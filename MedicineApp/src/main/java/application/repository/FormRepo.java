package application.repository;

import application.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepo extends JpaRepository<Form, Integer> {
    Form findByIdForm(int id);
}
