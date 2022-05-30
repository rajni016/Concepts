package Assign11P3;

import java.util.concurrent.Callable;

public class Thread implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "This is callable thread";
    }
}
