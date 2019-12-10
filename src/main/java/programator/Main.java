package programator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        new LinearSearch().linearSearch();
        System.out.println();
        new BubbleSort_JumpSearch().call();
    }
}

