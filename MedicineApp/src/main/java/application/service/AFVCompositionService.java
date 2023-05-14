package application.service;

import application.wrappers.AFVComposition;
import application.model.AdditionalField;
import application.model.AdditionalFieldValues;
import application.repository.AdditionalFieldRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>MedicineApp</h3>
 *
 * @author Shamil Shyhiev
 * <a href="https://t.me/bionic2113">telegram<a>
 * @date 14.05.2023
 */
@Service
public class AFVCompositionService {

    private final AdditionalFieldRepo additionalFieldRepo;

    public AFVCompositionService(AdditionalFieldRepo additionalFieldRepo) {
        this.additionalFieldRepo = additionalFieldRepo;
    }
    public List<AFVComposition> adfToAfvComposition(){
        var adf_list = additionalFieldRepo.findAll();
        List<AFVComposition> afvCompositionList = new ArrayList<>();
        for (AdditionalField adf: adf_list){
            afvCompositionList.add(new AFVComposition(new AdditionalFieldValues("", adf)));
        }
        return afvCompositionList;
    }
}
