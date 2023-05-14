package application.model;

import application.enums.DataType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "additional_fields")
@Data
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

    @OneToMany
    @JoinColumn(name = "ID_FIELD")
    private List<AdditionalFieldValues> valuesList = new ArrayList<>();

    public AdditionalFieldValues getValue(int id){
        for (int i = 0; i < valuesList.size(); i++) {
            if(valuesList.get(i).getForm().getIdForm()==id) return valuesList.get(i);
        }
        return null;
    }

    @Override
    public String toString() {
        return "AdditionalField{" +
                "fieldName='" + fieldName + '\'' +
                '}';
    }
}
