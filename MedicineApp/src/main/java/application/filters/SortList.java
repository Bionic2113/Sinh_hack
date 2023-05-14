package application.filters;

import application.model.AdditionalFieldValues;
import application.model.Form;
import application.model.Person;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;

import java.util.Comparator;
import java.util.List;

/**
 * <h3>MedicineApp</h3>
 *
 * @author Shamil Shyhiev
 * <a href="https://t.me/bionic2113">telegram<a>
 * @date 13.05.2023
 */
@Log4j2
public class SortList {

    private List<Person> people;
    private AdditionalFieldValues additionalFieldValues;

    public SortList(List<Person> people) {
        this.people = people;
    }

    public SortList(List<Person> people, AdditionalFieldValues additionalFieldValues) {
        this.people = people;
        this.additionalFieldValues = additionalFieldValues;
    }

    /**
     * Этот метод рассчитан на использование после
     * получения результата от FilterList
     */

    public List<Form> sortByAdditionalField(){

        return people
                .stream()
                .map(Person::getFormList)
                .flatMap(List::stream)
                .sorted(((o1, o2) ->
                        new ComparatorAdditionalFieldValues()
                                .compare(o1.getValues().stream()
                                                .filter(a -> a.getAdditionalField()
                                                                .getFieldName()
                                                                .equals(additionalFieldValues
                                                                        .getAdditionalField()
                                                                        .getFieldName()))
                                                .findFirst()
                                                .get(),
                                        o2.getValues().stream()
                                                .filter(a -> a.getAdditionalField()
                                                                .getFieldName()
                                                                .equals(additionalFieldValues
                                                                        .getAdditionalField()
                                                                        .getFieldName()))
                                                .findFirst()
                                                .get())

                ))
                .toList();
    }

    public List<Person> sortByFirstName(){
        return people
                .stream()
                .sorted(Comparator.comparing(Person::getFirstname))
                .toList();
    }

    public List<Person> sortByLastName(){
        return people
                .stream()
                .sorted(Comparator.comparing(Person::getLastname))
                .toList();
    }

    public List<Person> sortByFather(){
        var p =  people
                .stream()
                .sorted(Comparator.comparing(Person::getFather))
                .toList();
        log.log(Level.INFO, "People is {}", p);
        return p;
    }

    public List<Person> sortByBirthDate(){
        return people
                .stream()
                .sorted(Comparator.comparing(Person::getBirthDate))
                .toList();
    }
}
