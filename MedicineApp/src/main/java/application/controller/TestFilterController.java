package application.controller;

import application.filters.FilterList;
import application.filters.SortList;
import application.model.Person;
import application.repository.PersonRepo;
import application.service.AFVCompositionService;
import application.wrappers.AFVListWrapper;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

/**
 * <h3>MedicineApp</h3>
 *
 * @author Shamil Shyhiev
 * <a href="https://t.me/bionic2113">telegram<a>
 * @date 13.05.2023
 */
@Controller
@RequestMapping(path = "testFilter")
@Log4j2
public class TestFilterController {

    private final PersonRepo personRepo;
    private final AFVCompositionService afvCompositionService;
    private final FilterList filterList;


    public TestFilterController(PersonRepo personRepo, AFVCompositionService afvCompositionService, FilterList filterList) {
        this.personRepo = personRepo;
        this.afvCompositionService = afvCompositionService;
        this.filterList = filterList;
    }

    @GetMapping
    String getFilters(Model model){
        AFVListWrapper afvListWrapper = new AFVListWrapper();
        afvListWrapper.setCompositionList(afvCompositionService.adfToAfvComposition());
        log.log(Level.INFO,"ArrayList is {}", afvListWrapper.getCompositionList());
        model.addAttribute("wrap", afvListWrapper);
        return "FilterPage";
    }
    @PostMapping
    String postFilters(@ModelAttribute("wrap") AFVListWrapper afvListWrapper, Model model){
        log.log(Level.INFO, "wrapper == null is {}", afvListWrapper == null);
        assert afvListWrapper != null;
        log.log(Level.INFO,"List is {}", afvListWrapper.getCompositionList());
        afvListWrapper
                .setCompositionList(afvListWrapper.getCompositionList()
                        .stream()
                        .filter(afvComposition -> !afvComposition.getAdditionalFieldValues().getValue().isEmpty()
                                && !afvComposition.getAdditionalFieldValues().getValue().equals(" - "))
                        .toList());
//        var filter = new FilterList(afvListWrapper.getCompositionList(), new ArrayList<Person>(),personRepo);
        log.log(Level.INFO, "Фильтры : {}", afvListWrapper.getCompositionList());
        filterList.setAfvCompositions(afvListWrapper.getCompositionList());
        filterList.setPeople(new ArrayList<Person>());
        var list = new SortList(filterList.filter());
        model.addAttribute("list", list.sortByFather());
        return "PageAfterFilter";
    }

}
