package application.repository;

import application.model.AdditionalFieldValues;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdditionalFieldValuesRepo extends JpaRepository<AdditionalFieldValues, Integer> {
    List<AdditionalFieldValues> findAllByAdditionalField_IdField(int id);
}
