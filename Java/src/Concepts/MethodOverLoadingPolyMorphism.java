package Concepts;

public class MethodOverLoadingPolyMorphism {

    public void method1(int i) {
        System.out.println(i);
    }

    public void method1(String j) {
        System.out.println(j);
    }

    public void method1(Object k) {
        System.out.println("This is object version" + k);
    }

    // Var args method
    public void method2(int... i) {
        for (int itr : i) {
            System.out.println(itr);
        }


        }
    public void method2(String... i) {
        for (String itrt : i) {
            System.out.println(itrt);
        }

    }
    public void method3(Float... i) {

    }
    public static void method4(int i, float j){
        System.out.println(i+j);
    }
    public static void method4(float i, int j){
        System.out.println(i+j);
    }

    public static void main (String[] args){
            MethodOverLoadingPolyMorphism obj = new MethodOverLoadingPolyMorphism();
            obj.method1('k');
            obj.method1(null);// String and version can take value of null
            obj.method1(obj);// object can also take null values, but first null value will preferable to the String if there is no string method object can take it
            obj.method2(22, 2, 2, 2, 2, 2, 2, 2, 2, 233, 45, 5, 5, 5, 5, 5);
            obj.method2("STring", "Integer", "Boolean");
            obj.method3(); //varargs can take empty also. For method-2 we cannot pass null beacuse there are two methods which can accept null value


        }

    }
