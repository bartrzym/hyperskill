package programator;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class LinearSearch {

    void linearSearch() throws IOException {
        long startTime = System.currentTimeMillis();
        System.out.println("Start searching(linear search)...");

        List<Person> list = new ArrayList<>();
        PersonFactory personFactory = new PersonFactory();
        long endTime;
        personFactory.personList(list);


        Search search = new Search();
        search.linearSearch(list, FileDirectories.find());
        int founded = search.getFound();
        int total = search.getTotal();


        endTime = System.currentTimeMillis();
        long result = endTime - startTime;

        System.out.println("Found " + founded + "/" + total + ". Time taken: " + TimeFormater.formatter(result));

    }


}





