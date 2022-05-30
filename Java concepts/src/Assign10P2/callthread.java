package Assign10P2;

import java.util.concurrent.Callable;

public class callthread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 10000;
    }
}
