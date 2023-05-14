package application.repository;

import application.model.AdditionalField;
import application.model.AdditionalFieldValues;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdditionalFieldRepo extends JpaRepository<AdditionalField, Integer> {
    AdditionalField findByIdField(int id);
}
