package application.repository;

import application.model.AdditionalField;
<<<<<<< HEAD
import application.model.AdditionalFieldValues;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdditionalFieldRepo extends JpaRepository<AdditionalField, Integer> {
    AdditionalField findByIdField(int id);
=======
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdditionalFieldRepo extends JpaRepository<AdditionalField, Integer> {
>>>>>>> b2287e2 (adding concrete form page)
}
