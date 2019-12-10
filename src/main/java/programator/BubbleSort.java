package programator;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {
    private List<Person> list;

    public List bubbleSort(List<Person> array) {
        Person temp;
        this.list=array;
        long length = array.size();

        for (int i = 0; i < length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < length - 1 - i; j++) {
                if (array.get(j).getName().compareTo(array.get(j + 1).getName()) > 0) {
                    temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped){
                break;
            }

        }
        return array;
    }
}

