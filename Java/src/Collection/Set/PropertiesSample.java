package Collection.Set;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesSample {
    public static void main(String []args) throws IOException {
        Properties p=new Properties();
        FileInputStream fileinp= new FileInputStream("MyProperty.properties");
        p.load(fileinp);// loading all properties from property file
        System.out.println(p);
        String s=p.getProperty("username");
        System.out.println(s);
        p.setProperty("Database","MYSQL");
        FileOutputStream fop=new FileOutputStream("MyProperty.properties");
        p.store(fop,"New property updated");

    }
}
