package application.wrappers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <h3>MedicineApp</h3>
 *
 * @author Shamil Shyhiev
 * <a href="https://t.me/bionic2113">telegram<a>
 * @date 14.05.2023
 */
@Getter
@Setter
public class AFVListWrapper {

    private List<AFVComposition> compositionList;

    public AFVListWrapper() {
    }

    public void addAFVComposition(AFVComposition afvComposition){
        compositionList.add(afvComposition);
    }

    @Override
    public String toString() {
        return "AFVListWrapper{" +
                "compositionList=" + compositionList +
                '}';
    }
}
