package application.repository;

import application.model.AdditionalField;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdditionalFieldRepo extends JpaRepository<AdditionalField, Integer> {
}
