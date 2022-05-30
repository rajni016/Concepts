package Assign10P3;

public class runnablethreadsampleinterface {
    public static void main(String[] args) {
        Rthread1 obj1 = new Rthread1();
        Rthread2 obj2 = new Rthread2();
        Thread javaobj1 = new Thread(obj1);
        Thread javaobj2 = new Thread(obj2);

        javaobj1.start();
        try {

            javaobj1.join();
            javaobj2.sleep(20000);
        } catch (Exception e) {

        }

        javaobj2.start();

    }

}
class Rthread1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
class Rthread2 implements Runnable{

    @Override
    public void run() {
        for (int j = 0; j < 5; j++) {
            System.out.println(j);
        }
    }
}