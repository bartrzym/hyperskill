package programator;


import java.io.IOException;
import java.util.*;

class QuickSort_BinarySearch {


    void call() throws IOException {
        long startTime = System.currentTimeMillis();
        System.out.println("Start searching(quick sort + binary search)...");

        List<Person> list = new ArrayList<>();
        Sort sort = new Sort();
        PersonFactory personFactory = new PersonFactory();
        personFactory.personList(list);
        sort.quickSort(list, 0, list.size() - 1);


        long midtime = System.currentTimeMillis();
        long sortTime = midtime - startTime;

        Search search = new Search();
        search.binarySearch(list, FileDirectories.find());
        int founded = search.getFound();
        int total = search.getTotal();


        long endTime = System.currentTimeMillis();
        long result = endTime - startTime;
        long searchTime = result - sortTime;

        System.out.println("Found " + founded + "/" + total + ". Time taken:" + TimeFormater.formatter(result));
        System.out.println("Sorting Time:" + TimeFormater.formatter(sortTime));
        System.out.println("Searching Time:" + TimeFormater.formatter(searchTime));

    }


}





