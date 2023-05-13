package application.compositions;

import application.model.AdditionalFieldValues;
import lombok.Getter;
import lombok.Setter;

/**
 * <h3>MedicineApp</h3>
 *
 * @author Shamil Shyhiev
 * <a href="https://t.me/bionic2113">telegram<a>
 * @date 13.05.2023
 */
@Getter
@Setter
public class AFVComposition {

    AdditionalFieldValues additionalFieldValues;

    boolean diapason = false;

    public AFVComposition(AdditionalFieldValues additionalFieldValues) {
        this.additionalFieldValues = additionalFieldValues;
    }
}
