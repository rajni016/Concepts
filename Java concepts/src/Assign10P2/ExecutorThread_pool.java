package Assign10P2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorThread_pool {
    public static void main(String[] args) {
        ExecutorService obj = Executors.newSingleThreadExecutor();
        obj.submit(new Runthread());
        obj.shutdown();
    }
}
