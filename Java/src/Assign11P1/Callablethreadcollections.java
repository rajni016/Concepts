package Assign11P1;

import java.util.concurrent.Callable;

public class Callablethreadcollections implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        return 4000;
    }
}
