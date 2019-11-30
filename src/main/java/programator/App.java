package programator;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class App {

    public static void main(String[] args) throws IOException {

        FileReader directory = new FileReader("src/main/directory/directory.txt");
        FileReader find = new FileReader("src/main/directory/find.txt");

        HashMap<String, String> map = new HashMap<>();
        HashMap<String, String> mapduplicates = new HashMap<>();

        long start = System.currentTimeMillis();
        long end;
        int founded = 0;
        int total = 0;
        String line;

        BufferedReader dreader = new BufferedReader(directory);
        while ((line = dreader.readLine()) != null) {
            String[] parts = line.split(" ", 2);
            if (parts.length >= 2) {
                String key = parts[0];
                String value = parts[1];
                if (map.containsKey(key)) {
                    mapduplicates.put(key, value);
                } else {
                    map.put(key, value);
                }

            }
        }
        dreader.close();

        BufferedReader freader = new BufferedReader(find);
        while ((line = freader.readLine()) != null) {
            total++;
            if (map.containsValue(line) || mapduplicates.containsValue(line)) {
                founded++;
            } else {
                System.out.println("Nie znaleziono " + line);
            }
        }
        freader.close();


        end = System.currentTimeMillis();
        long result= end - start;
        int min= (int) (result/1000/60);
        int sec = (int) ((result-(min*1000*60))/1000);
        int ms = (int) (result - ((min*1000*60)+(sec*1000)));
        System.out.println("Start searching...");
        System.out.println("Found " + founded + "/" + total + ". Time taken: " +min+ "min. "+ sec+"sec. " + ms +"ms.");

    }
}


