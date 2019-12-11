package programator;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        new LinearSearch().linearSearch();
        System.out.println();
        new BubbleSort_JumpSearch().call();
        System.out.println();
        new QuickSort_BinarySearch().call();
        System.out.println();
        new HashTableSearch().hashTableSearch();
    }
}

