package application.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "people")
@Data
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

}
