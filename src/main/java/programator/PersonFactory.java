package programator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

class PersonFactory {


    void personList(List<Person> list) throws IOException {
        String line;

        BufferedReader dreader = new BufferedReader(FileDirectories.directory());
        while ((line = dreader.readLine()) != null) {
            String[] parts = line.split(" ", 2);
            if (parts.length >= 2) {
                String key = parts[1];
                String value = parts[0];
                Person person = new Person(key, value);
                list.add(person);
            }
        }
        dreader.close();
    }
}
