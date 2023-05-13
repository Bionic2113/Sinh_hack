package application.service;

import application.compositions.AFVComposition;
import application.enums.DataType;
import application.model.AdditionalFieldValues;
import application.model.Form;
import application.model.Person;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <h3>MedicineApp</h3>
 *
 * @author Shamil Shyhiev
 * <a href="https://t.me/bionic2113">telegram<a>
 * @date 13.05.2023
 */
@Service
public class PersonService {

    private AFVComposition afvCompositions;

    public List<Person> findInAll(AFVComposition afvCompositions, List<Person> people){
        this.afvCompositions = afvCompositions;
        return people
                .stream()
                .peek(b -> b.setFormList(findInPerson(b.getFormList())))
                .toList();
    }

    private List<Form> findInPerson(List<Form> formList){
        return formList
                .stream()
                .filter(form -> form
                        .getValues()
                        .contains(afvCompositions.getAdditionalFieldValues()))
                .peek(form -> form.setValues(getValues(form.getValues())))
                .toList();
    }

    private List<AdditionalFieldValues> getValues(List<AdditionalFieldValues> fieldValuesList){
        return fieldValuesList
                .stream()
                .filter(this::valueIsValid)
                .collect(Collectors.toList());
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
        return afvCompositions
                .isDiapason()
                ? IsContains(afvCompositions
                        .getAdditionalFieldValues()
                        .getValue(),
                additionalFieldValues.getValue())
                : equalsValue(
                Double.parseDouble(afvCompositions.getAdditionalFieldValues().getValue()),
                Double.parseDouble(additionalFieldValues.getValue())
        );
    }

    private boolean IsContains(String diapason, String value){
        List<Double> doubleList = Arrays.stream(diapason.split(","))
                                            .map(Double::parseDouble)
                                            .sorted()
                                            .toList();
        double min = doubleList.get(0);
        double max = doubleList.get(1);
        double double_value = Double.parseDouble(value);
        return min <= double_value && double_value <= max;
    }
    private boolean equalsValue(Double d1, Double d2){
        return d1.equals(d2);
    }

}
