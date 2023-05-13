package application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "additional_fields_values")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
