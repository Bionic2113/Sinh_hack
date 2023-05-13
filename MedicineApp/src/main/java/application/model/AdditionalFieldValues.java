package application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToOne
    @JoinColumn(name = "ID_FIELD")
    private AdditionalField additionalField;

    @Override
    public String toString() {
        return "AdditionalFieldValues{" +
                "idValue=" + idValue +
                ", value='" + value + '\'' +
                '}';
    }
}
