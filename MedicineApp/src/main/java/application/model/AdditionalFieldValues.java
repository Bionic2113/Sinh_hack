package application.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "additional_fields_values")
@Data
public class AdditionalFieldValues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VALUE")
    private int idValue;

    @Column(name = "VALUE")
    private String value;

    @OneToOne
    AdditionalField additionalField;
}
