package application.repository;

import application.model.AdditionalField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalFieldRepo extends JpaRepository<AdditionalField, Integer> {
    AdditionalField findByIdField(int id);
}
