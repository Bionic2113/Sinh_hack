package application.service;

import application.enums.DataType;
import application.model.AdditionalFieldValues;
import application.model.Form;
import application.model.Person;
import application.wrappers.AFVComposition;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * <h3>MedicineApp</h3>
 *
 * @author Shamil Shyhiev
 * <a href="https://t.me/bionic2113">telegram<a>
 * @date 13.05.2023
 */
@Service
@Log4j2
public class PersonService {

    private AFVComposition afvCompositions;

    public List<Person> findInAll(AFVComposition afvCompositions, List<Person> people){
        log.log(Level.INFO,"People start is {}", people);
        this.afvCompositions = afvCompositions;
        var p = people
                .stream()
                .map(person -> {
                    List<Form> updatedFormList = findInPerson(person.getFormList());
                    person.setFormList(updatedFormList);
                    return person;
                    })
                .filter(f -> !f.getFormList().isEmpty())
                .toList();
        log.log(Level.INFO,"People finally list is {}",p);
       return p;
    }

    private List<Form> findInPerson(List<Form> formList){
        var p = formList
                .stream()
                .filter(d -> findValues(d.getValues()))
                .toList();
        log.log(Level.INFO, "Forms finally is {}", p);
        return p;
    }

    private boolean findValues(List<AdditionalFieldValues> fieldValuesList){
        var p=  fieldValuesList
                .stream()
                .anyMatch(this::valueIsValid);
        log.log(Level.INFO,"AddFields finally is {}", p);
        return p;
    }

    private boolean valueIsValid(AdditionalFieldValues additionalFieldValues){
        if (afvCompositions.getAdditionalFieldValues().getAdditionalField().getDataType() == DataType.STRING) {
            return additionalFieldValues
                    .getValue()
                    .startsWith(afvCompositions
                            .getAdditionalFieldValues()
                            .getValue()
                    );
        }
        return IsContains(afvCompositions
                        .getAdditionalFieldValues()
                        .getValue(),
                additionalFieldValues.getValue());
    }

    private boolean IsContains(String diapason, String value){
        List<Double> doubleList = Arrays.stream(diapason.split(" - "))
                                            .map(Double::parseDouble)
                                            .sorted()
                                            .toList();
        double min = doubleList.get(0);
        double max = doubleList.get(1);
        double double_value = Double.parseDouble(value);
        return min <= double_value && double_value <= max;
    }
}
