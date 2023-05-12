package application.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "form")
public class Form {
    @Id
    @Column(name = "ID_FORM")
    private int idForm;

    @Column(name = "DATE")
    private Date date;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_FORM", nullable = false)
    private List<AdditionalFieldValues> values = new ArrayList<>();

    public int getIdForm() {
        return idForm;
    }

    public void setIdForm(int idForm) {
        this.idForm = idForm;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<AdditionalFieldValues> getValues() {
        return values;
    }

    public void setValues(List<AdditionalFieldValues> values) {
        this.values = values;
    }
}
