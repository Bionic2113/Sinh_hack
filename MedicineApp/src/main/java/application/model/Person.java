package application.model;

import application.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "people")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PEOPLE")
    private int idPeople;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "FATHER")
    private String father;

    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Column(name = "SEX")
    private String sex;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "ID_PEOPLE")
    private List<Form> formList = new ArrayList<>();

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "MED_DOC")
    private int medDocument;

    public void deleteForms(){
        for (int i = 0; i < formList.size(); i++) {
            formList.get(i).setStatus(Status.DELETED);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "idPeople=" + idPeople +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", father='" + father + '\'' +
                ", birthDate=" + birthDate +
                ", sex='" + sex + '\'' +
                ", formList=" + formList +
                '}';
    }
}
