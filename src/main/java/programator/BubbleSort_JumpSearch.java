package programator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class BubbleSort_JumpSearch {
    private List<Person> array_unsorted_main = new ArrayList<>();
    private Thread t1;

    void call() throws IOException, InterruptedException {
        long startTime = System.currentTimeMillis();
        System.out.println("Start searching(bubble sort + jump search)...");

        long endTime;
        String line;

        BufferedReader dreader = new BufferedReader(FileDirectories.directory());
        int i = 0;
        while ((line = dreader.readLine()) != null) {
            String[] parts = line.split(" ", 2);
            if (parts.length >= 2) {
                String key = parts[1];
                String value = parts[0];
                Person person = new Person(key, value);
                array_unsorted_main.add(i, person);
                i++;
            }
        }
        dreader.close();
        MultithreadedBubbleSort sort = new MultithreadedBubbleSort(array_unsorted_main, 1000);
        t1 = new Thread(sort);
        t1.start();
        t1.join();
        long midtime = System.currentTimeMillis();
        long sortTime = midtime - startTime;
        int min = (int) (sortTime / 1000 / 60);
        int sec = (int) ((sortTime - (min * 1000 * 60)) / 1000);
        int ms = (int) (sortTime - ((min * 1000 * 60) + (sec * 1000)));
        array_unsorted_main = sort.getArrayList();

        JumpSearch search = new JumpSearch();
        BufferedReader freader = new BufferedReader(FileDirectories.find());
        search.searchJump(array_unsorted_main, freader);
        freader.close();
        int founded = search.getFound();
        int total = search.getTotal();


        endTime = System.currentTimeMillis();
        long result = endTime - startTime;
        int min2 = (int) (result / 1000 / 60);
        int sec2 = (int) ((result - (min2 * 1000 * 60)) / 1000);
        int ms2 = (int) (result - ((min2 * 1000 * 60) + (sec2 * 1000)));
        long searchTime = result-sortTime;
        int min3 = (int) (searchTime / 1000 / 60);
        int sec3 = (int) ((searchTime - (min3 * 1000 * 60)) / 1000);
        int ms3 = (int) (searchTime - ((min3 * 1000 * 60) + (sec3 * 1000)));

        System.out.println("Found " + founded + "/" + total + ". Time taken: " + min2 + "min. " + sec2 + "sec. " + ms2 + "ms.");
        System.out.println("Sorting Time: " + min + "min. " + sec + "sec. " + ms + "ms.");
        System.out.println("Searching Time: " + min3 + "min. " + sec3 + "sec. " + ms3 + "ms.");


    }

}