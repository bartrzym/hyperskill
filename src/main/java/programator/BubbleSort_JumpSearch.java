package programator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class BubbleSort_JumpSearch {
    private PersonFactory personFactory = new PersonFactory();
    private List<Person> array_unsorted_main = new ArrayList<>();
    private Thread t1;
    private long startTime = System.currentTimeMillis();

    void call() throws IOException, InterruptedException {

        System.out.println("Start searching(bubble sort + jump search)...");

        personFactory.personList(array_unsorted_main);

        MultithreadedBubbleSort sort = new MultithreadedBubbleSort(array_unsorted_main, 1000);
        t1 = new Thread(sort);
        t1.start();
        t1.join();
        long midtime = System.currentTimeMillis();
        long sortTime = midtime - startTime;
        array_unsorted_main = sort.getArrayList();

        Search search = new Search();
        search.jumpSearch(array_unsorted_main, FileDirectories.find());
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