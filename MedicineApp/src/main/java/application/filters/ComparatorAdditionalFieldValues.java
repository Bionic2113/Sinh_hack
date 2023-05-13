package application.filters;

import application.model.AdditionalFieldValues;

import java.util.Comparator;

/**
 * <h3>MedicineApp</h3>
 *
 * @author Shamil Shyhiev
 * <a href="https://t.me/bionic2113">telegram<a>
 * @date 13.05.2023
 */
public class ComparatorAdditionalFieldValues implements Comparator<AdditionalFieldValues> {

    @Override
    public int compare(AdditionalFieldValues o1, AdditionalFieldValues o2) {
        switch (o1.getAdditionalField().getDataType()){
            case DOUBLE -> {
                return compareDouble(Double.parseDouble(o1.getValue()),
                                     Double.parseDouble(o2.getValue()));}
            case INTEGER -> {
                return compareInteger(Integer.parseInt(o1.getValue()),
                                      Integer.parseInt(o2.getValue()));}
            default -> {
                return compareString(o1.getValue().toCharArray(),
                                     o2.getValue().toCharArray());
            }
        }
    }
    private int compareDouble(Double o1, Double o2){
        return o1.compareTo(o2);
    }

    private int compareInteger(Integer o1, Integer o2){
        return o1.compareTo(o2);
    }

    private int compareString(char[] o1, char[] o2){
        var end = Math.min(o1.length, o2.length);
        for (int i = 0; i < end; i++){
            if ((o1[i] - o2[i]) != 0)
                return (o1[i] - o2[i]);
        }
        return o1.length-o2.length;
    }
}
