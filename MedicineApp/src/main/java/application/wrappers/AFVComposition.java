package application.wrappers;

import application.enums.DataType;
import application.model.AdditionalFieldValues;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * <h3>MedicineApp</h3>
 *
 * @author Shamil Shyhiev
 * <a href="https://t.me/bionic2113">telegram<a>
 * @date 13.05.2023
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class AFVComposition {

    private AdditionalFieldValues additionalFieldValues;

    private boolean number;

    public AFVComposition(AdditionalFieldValues additionalFieldValues) {
        this.additionalFieldValues = additionalFieldValues;
        setNumber();
    }
    private void setNumber(){
        if(additionalFieldValues.getAdditionalField().getDataType() != DataType.STRING){
            number = true;
        }
    }
}
