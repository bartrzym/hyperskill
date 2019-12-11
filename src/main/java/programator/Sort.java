package programator;

import java.util.Collections;
import java.util.List;

class Sort {
    void quickSort(List<Person> list) {
        int a = 0;
        int b = list.size() - 1;
        quickSort(list, a, b);
    }

    void quickSort(List<Person> list, int a, int b) {
        if (a >= b)
            return;

        Person pivot = list.get(b);

        int left = a;
        int right = b;

        while (left < right) {
            while (list.get(left).getName().compareTo(pivot.getName()) < 0)
                left++;

            while (list.get(right).getName().compareTo(pivot.getName()) > 0)
                right--;

            if (right > left) {
                Collections.swap(list, left, right);
            }
        }

        quickSort(list, a, right - 1);
        quickSort(list, right + 1, b);

    }

    void bubbleSort(List<Person> list) {
        Person temp;
        long length = list.size();

        for (int i = 0; i < length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < length - 1 - i; j++) {
                if (list.get(j).getName().compareTo(list.get(j + 1).getName()) > 0) {
                    temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}