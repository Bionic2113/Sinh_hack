package application.repository;

import application.model.AdditionalFieldValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdditionalFieldValuesRepo extends JpaRepository<AdditionalFieldValues, Integer> {
    List<AdditionalFieldValues> findAllByAdditionalField_IdField(int id);
}
