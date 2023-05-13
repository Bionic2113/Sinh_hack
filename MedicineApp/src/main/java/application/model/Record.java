package application.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "record")
@Data
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RECORD")
    private int idRecord;

    @Column(name = "ID_FORM")
    private int idForm;

    @Column(name = "ID_PEOPLE")
    private int idPeople;
}
