package Assign11P2;

import java.util.concurrent.Callable;

public class Callablethreadprocessor implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 2022;
    }
}
