package application.model;

import application.repository.PersonRepo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "form")
@Data
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FORM")
    private int idForm;

    @Column(name = "DATE")
    private Date date;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_FORM")
    private List<AdditionalFieldValues> values = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "ID_PEOPLE")
    private Person person;

    @Override
    public String toString() {
        return "Form{" +
                "idForm=" + idForm +
                ", date=" + date +
                ", values=" + values +
                '}';
    }
}
