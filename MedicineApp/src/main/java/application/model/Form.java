package application.model;

import application.repository.PersonRepo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
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
    private Date date;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_FORM", nullable = false)
    private List<AdditionalFieldValues> values = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "ID_PEOPLE")
    private Person person;

//    @Column(name = "ID_PEOPLE")
//    private int idPeople;


    @Override
    public String toString() {
        return "Form{" +
                "idForm=" + idForm +
                ", date=" + date +
                ", values=" + values +
//                ", person=" + person +
                '}';
    }
}
