package application.model;

import application.enums.DataType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "additional_fields")
@Data
public class AdditionalField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FIELD")
    private int idField;

    @Column(name = "FIELD_NAME")
    private String fieldName;

    @Column(name = "DATA_TYPE")
    @Enumerated
    private DataType dataType;

    @OneToMany
    @JoinColumn(name = "ID_FIELD")
    private List<AdditionalFieldValues> valuesList = new ArrayList<>();
}
