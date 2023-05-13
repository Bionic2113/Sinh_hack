package application.service;

import application.model.AdditionalFieldValues;
import application.model.Form;
import application.model.Person;
import application.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>MedicineApp</h3>
 *
 * @author Shamil Shyhiev
 * <a href="https://t.me/bionic2113">telegram<a>
 * @date 13.05.2023
 */
@Service
public class PersonService {

    public List<Form> findInPerson(AdditionalFieldValues additionalFieldValues, List<Form> formList){
        List<Form> new_formList = new ArrayList<>();
        for (Form form: formList){
            if(form.getValues().contains(additionalFieldValues)){
                new_formList.add(form);
            }
        }
        return new_formList;
    }
    public List<Person> findInAll(AdditionalFieldValues additionalFieldValues, List<Person> people){
        for (Person person : people){
            person.setFormList(findInPerson(additionalFieldValues, person.getFormList()));
        }
        return people;
    }
}
