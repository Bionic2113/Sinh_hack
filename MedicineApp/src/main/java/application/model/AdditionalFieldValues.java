package application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "additional_fields_values")
@Getter
@Setter
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

    public AdditionalFieldValues(String value, AdditionalField additionalField) {
        this.value = value;
        this.additionalField = additionalField;
    }

    @ManyToOne
    @JoinColumn(name = "ID_FORM")
    private Form form;

    @Override
    public String toString() {
        return "AdditionalFieldValues{" +
                "доп поле: "+additionalField +
                "idValue=" + idValue +
                ", value='" + value + '\'' +
                '}';
    }
}
