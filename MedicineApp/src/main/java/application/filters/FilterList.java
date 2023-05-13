package application.filters;

import application.model.AdditionalFieldValues;
import application.model.Person;
import application.repository.PersonRepo;
import application.service.PersonService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <h3>MedicineApp</h3>
 *
 * @author Shamil Shyhiev
 * <a href="https://t.me/bionic2113">telegram<a>
 * @date 13.05.2023
 */
@Setter
public class FilterList {

    private List<AdditionalFieldValues> additionalFieldValues;
    private List<Person> people;

    @Autowired
    PersonRepo personRepo;
    @Autowired
    PersonService personService;

    public FilterList(List<AdditionalFieldValues> additionalFieldValues, List<Person> people){
        this.additionalFieldValues = additionalFieldValues;
        this.people = people;
    }

    public List<Person> sort(){
        if(people.isEmpty()){
            people = personRepo.findAll();
        }
        for (AdditionalFieldValues fieldValue : additionalFieldValues){
            people = personService.findInAll(fieldValue, people);
        }
        return people;
    }
}
