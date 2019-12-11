package programator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Search {

    private int total;
    private int found;

    int getTotal() {
        return total;
    }

    private void setTotal(int total) {
        this.total = total;
    }

    int getFound() {
        return found;
    }

    private void setFound(int found) {
        this.found = found;
    }

    void jumpSearch(List<Person> arr, FileReader reader) throws IOException {
        BufferedReader freader = new BufferedReader(reader);
        int n = arr.size();
        String line;
        int found = 0;
        int total = 0;

        List<String> namesToFind = new ArrayList();
        while ((line = freader.readLine()) != null) {
            namesToFind.add(line);
            total++;
        }

        for (String name : namesToFind) {
            int step = (int) Math.floor(Math.sqrt(n));
            int prev = 0;
            while (arr.get(Math.min(step, n) - 1).getName().compareTo(name) < 0) {
                prev = step;
                step += (int) Math.floor(Math.sqrt(n));
            }
            while (arr.get(prev).getName().compareTo(name) < 0) {
                prev++;
            }
            if (arr.get(prev).getName().equals(name)) {
                found++;
//                System.out.println(arr.get(prev).getName() + "..........." + name);
            }

        }
        setTotal(total);
        setFound(found);
        freader.close();
    }

    void linearSearch(List<Person> arr, FileReader reader) throws IOException {
        BufferedReader freader = new BufferedReader(reader);
        String line;
        int total = 0;
        int found = 0;

        while ((line = freader.readLine()) != null) {
            total++;
            for (Person person : arr) {
                if (person.getName().equals(line))
                    found++;
            }
//            else {
//                System.out.println("Nie znaleziono " +line);
//            }
        }
        setTotal(total);
        setFound(found);
        freader.close();
    }

    void binarySearch(List<Person> list, FileReader reader) throws IOException {
        BufferedReader freader = new BufferedReader(reader);
        int found = 0;
        int total = 0;

        String line;
        List<String> namesToFind = new ArrayList();
        while ((line = freader.readLine()) != null) {
            namesToFind.add(line);
            total++;
        }
        for (String name : namesToFind) {
            int cmp = 1;
            int low = 0;
            int high = list.size() - 1;
            while (low <= high && !(cmp == 0)) {
                int mid = low + (high - low) / 2;
                Person midVal = list.get(mid);
                cmp = midVal.getName().compareTo(name);

                if (cmp < 0)
                    low = mid + 1;
                else if (cmp > 0)
                    high = mid - 1;
                else {
                    found++;// key found
                }
            }
        }
        setTotal(total);
        setFound(found);
        freader.close();
        // key not found
    }
}




