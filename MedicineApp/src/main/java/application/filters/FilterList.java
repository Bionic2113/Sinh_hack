package application.filters;

import application.compositions.AFVComposition;
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

    private List<AFVComposition> afvCompositions;
    private List<Person> people;

    @Autowired
    PersonRepo personRepo;
    @Autowired
    PersonService personService;

    public FilterList(List<AFVComposition> afvCompositions, List<Person> people){
        this.afvCompositions = afvCompositions;
        this.people = people;
    }

    public List<Person> sort(){
        if(people.isEmpty()){
            people = personRepo.findAll();
        }
        for (AFVComposition fieldValue : afvCompositions){
            people = personService.findInAll(fieldValue, people);
        }
        return people;
    }
}
