package programator;

import java.util.ArrayList;
import java.util.List;


public class MultithreadedBubbleSort implements Runnable {
    private List<Person> arrayList;
    private int threshold;
    private int middle;

    List<Person> getArrayList() {
        return arrayList;
    }

    private void setArrayList(List<Person> arrayList) {
        this.arrayList = arrayList;
    }


    MultithreadedBubbleSort(List<Person> arrayList, int threshold) {
        this.arrayList = arrayList;
        this.threshold = threshold;
        this.middle = arrayList.size() / 2;

    }


    @Override
    public void run() {

        if (arrayList.size() <= threshold) {
            sort();
        } else {
            MultithreadedBubbleSort rLeft = new MultithreadedBubbleSort(arrayList.subList(0, middle), threshold);
            MultithreadedBubbleSort rRight = new MultithreadedBubbleSort(arrayList.subList(middle, arrayList.size()), threshold);


            Thread tLeft = new Thread(rLeft);
            Thread tRight = new Thread(rRight);
            tRight.start();
            tLeft.start();
            try {
                tLeft.join();
                tRight.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            merge(rLeft.arrayList, rRight.arrayList);
        }
        synchronized (this) {
            if (this.arrayList.size() == 1014130) {
                setArrayList(arrayList);



            }
        }


    }


    private void merge(List<Person> left, List<Person> right) {
        int i = 0, j = 0, k = 0;
        List<Person> temp = new ArrayList<>();
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getName().compareTo(right.get(j).getName()) < 0) {
                temp.add(k, left.get(i));
                i++;
            } else {
                temp.add(k, right.get(j));
                j++;
            }
            k++;
        }
        while (i < left.size()) {
            temp.add(k, left.get(i));
            i++;
            k++;
        }
        while (j < right.size()) {
            temp.add(k, right.get(j));
            j++;
            k++;
        }
        arrayList = temp;
    }

    private void sort() {
        Person temp;
        long length = arrayList.size();

        for (int i = 0; i < length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < length - 1 - i; j++) {
                if (arrayList.get(j).getName().compareTo(arrayList.get(j + 1).getName()) > 0) {
                    temp = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j + 1));
                    arrayList.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }

        }
    }
}