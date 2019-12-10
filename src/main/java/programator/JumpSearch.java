package programator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class JumpSearch {

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

    void searchJump(List<Person> arr, BufferedReader freader) throws IOException {
        int n = arr.size();
        String line;
        int total = 0;
        int found = 0;
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
            }

        }
        setTotal(total);
        setFound(found);
    }
}
