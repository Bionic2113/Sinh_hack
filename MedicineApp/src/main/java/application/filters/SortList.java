package application.filters;

import application.model.AdditionalFieldValues;
import application.model.Form;
import application.model.Person;

import java.util.Comparator;
import java.util.List;

/**
 * <h3>MedicineApp</h3>
 *
 * @author Shamil Shyhiev
 * <a href="https://t.me/bionic2113">telegram<a>
 * @date 13.05.2023
 */
public class SortList {

    private final List<Person> people;
    private final AdditionalFieldValues additionalFieldValues;

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
        return people
                .stream()
                .sorted(Comparator.comparing(Person::getFather))
                .toList();
    }

    public List<Person> sortByBirthDate(){
        return people
                .stream()
                .sorted(Comparator.comparing(Person::getBirthDate))
                .toList();
    }
}
