package application.model;

import application.enums.DataType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "additional_fields")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FIELD")
    private int idField;

    @Column(name = "FIELD_NAME")
    private String fieldName;

    @Column(name = "DATA_TYPE")
    @Enumerated(EnumType.STRING)
    private DataType dataType;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "ID_FIELD")
    private List<AdditionalFieldValues> valuesList = new ArrayList<>();

    @Override
    public String toString() {
        return "AdditionalField{" +
                "idField=" + idField +
                ", fieldName='" + fieldName + '\'' +
                ", dataType=" + dataType +
//                ", valuesList=" + valuesList +
                '}';
    }
}
