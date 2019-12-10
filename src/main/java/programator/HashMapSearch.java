package programator;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class HashMapSearch {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        System.out.println("Start searching(HashMap)...");



        HashMap<String, String> map = new HashMap<>();

        long end;
        int founded = 0;
        int total = 0;
        String line;

        BufferedReader dreader = new BufferedReader(FileDirectories.directory());
        while ((line = dreader.readLine()) != null) {
            String[] parts = line.split(" ", 2);
            if (parts.length >= 2) {
                String key = parts[1];
                String value = parts[0];
                map.put(key, value);
            }
        }
        dreader.close();


        BufferedReader freader = new BufferedReader(FileDirectories.find());
        while ((line = freader.readLine()) != null) {
            total++;
            if (map.containsKey(line)) {
                founded++;
            }
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


