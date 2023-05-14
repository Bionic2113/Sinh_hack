package application.model;

import application.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "form")
@Getter
@Setter
public class Form {
    @Id
    @Column(name = "ID_FORM")
    private int idForm;

    @Column(name = "DATE")
    private LocalDate date;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_FORM")
    private List<AdditionalFieldValues> values = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "ID_PEOPLE")
    private Person person;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Override
    public String toString() {
        return "Form{" +
                "idForm=" + idForm +
                ", date=" + date +
                ", values=" + values +
                '}';
    }
}
