public class ClassA {
    public static int age=45;
    public static String java="Java is booming";
    private static final float mySalary=0.9999f;
    public static String company(String Compname){
        double []shareprice= {1000.70d,2000.70d, 1500.50d};

       //double [] shareprice={1000.90d , 1500.70d,2500.70d};
        switch (Compname) {
            case "microsoft" -> System.out.println(shareprice[0]);
            case "google" -> System.out.println(shareprice[1]);
            case "apple" -> System.out.println(shareprice[2]);
        }
    return Compname;

    }
    public static void main(String[]args){
        company("microsoft");
        company("google");
    }
}
