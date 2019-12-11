package programator;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.Hashtable;

class HashTableSearch {

    void hashTableSearch() throws IOException {
        long startTime = System.currentTimeMillis();
        System.out.println("Start searching(hash table)...");

        Hashtable<String, String> map = new Hashtable<>();

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

        long midtime = System.currentTimeMillis();
        long sortTime = midtime - startTime;

        BufferedReader freader = new BufferedReader(FileDirectories.find());
        while ((line = freader.readLine()) != null) {
            total++;
            if (map.containsKey(line)) {
                founded++;
            }
        }
        freader.close();


        long endTime = System.currentTimeMillis();
        long result = endTime - startTime;
        long searchTime = result - sortTime;

        System.out.println("Found " + founded + "/" + total + ". Time taken:" + TimeFormater.formatter(result));
        System.out.println("Creating Time:" + TimeFormater.formatter(sortTime));
        System.out.println("Searching Time:" + TimeFormater.formatter(searchTime));

    }
}


