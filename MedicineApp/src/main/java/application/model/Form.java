package application.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "form")
@Data
public class Form {
    @Id
    @Column(name = "ID_FORM")
    private int idForm;

    @Column(name = "DATE")
    private Date date;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_FORM", nullable = false)
    private List<AdditionalFieldValues> values = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "ID_PEOPLE")
    private Person person;
}
