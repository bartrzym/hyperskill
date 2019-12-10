package programator;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class LinearSearch {

    void linearSearch() throws IOException {
        long start = System.currentTimeMillis();
        System.out.println("Start searching(linear search)...");

        List<Person> map = new ArrayList<>();

        long end;
        int founded = 0;
        int total = 0;
        String line;

        BufferedReader dreader = new BufferedReader(FileDirectories.directory());
        int i = 0;
        while ((line = dreader.readLine()) != null) {
            String[] parts = line.split(" ", 2);
            if (parts.length >= 2) {
                String key = parts[1];
                String value = parts[0];
                Person person = new Person(key, value);
                map.add(i, person);
                i++;
            }
        }
        dreader.close();

        BufferedReader freader = new BufferedReader(FileDirectories.find());
        while ((line = freader.readLine()) != null) {
            total++;
            for (Person person : map) {
                if (person.getName().equals(line))
                    founded++;
            }
//            else {
//                System.out.println("Nie znaleziono " +line);
//            }
        }
        freader.close();


        end = System.currentTimeMillis();
        long result = end - start;
        int min = (int) (result / 1000 / 60);
        int sec = (int) ((result - (min * 1000 * 60)) / 1000);
        int ms = (int) (result - ((min * 1000 * 60) + (sec * 1000)));
        System.out.println("Found " + founded + "/" + total + ". Time taken: " + min + "min. " + sec + "sec. " + ms + "ms.");

    }


}





