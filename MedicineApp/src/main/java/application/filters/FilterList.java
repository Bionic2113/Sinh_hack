package application.filters;

import application.enums.Status;
import application.wrappers.AFVComposition;
import application.model.Person;
import application.repository.PersonRepo;
import application.service.PersonService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h3>MedicineApp</h3>
 *
 * @author Shamil Shyhiev
 * <a href="https://t.me/bionic2113">telegram<a>
 * @date 13.05.2023
 */
@Service
@Setter
public class FilterList {

    private List<AFVComposition> afvCompositions;
    private List<Person> people;
    private final PersonRepo personRepo;
    private final PersonService personService;

    @Autowired
    public FilterList(PersonRepo personRepo, PersonService personService) {
        this.personRepo = personRepo;
        this.personService = personService;
    }

    public List<Person> filter(){
        if(people.isEmpty()){
            people = personRepo.findAllByStatus(Status.EXIST);
        }
        if (afvCompositions.isEmpty()){
            return people;
        }
        for (AFVComposition fieldValue : afvCompositions){
            people = personService.findInAll(fieldValue, people);
        }
        return people;
    }
}
