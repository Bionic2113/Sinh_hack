package application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "people")
@Data
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

    @OneToMany
    @JoinColumn(name = "ID_PEOPLE")
    private List<Form> formList = new ArrayList<>();
}
