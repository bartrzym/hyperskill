package programator;

import java.io.FileNotFoundException;
import java.io.FileReader;

class FileDirectories {

    static FileReader find() throws FileNotFoundException {
        return new FileReader("src/main/directory/find.txt");
    }

    static FileReader directory() throws FileNotFoundException {
        return new FileReader("src/main/directory/directory.txt");
    }
}
