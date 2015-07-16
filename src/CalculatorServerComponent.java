
import java.rmi.*;

public class CalculatorServerComponent {

    private static final String host = "localhost";

    public static void main(String[] args) throws Exception {
        CalculatorImplementation temp = new CalculatorImplementation();
        String rmiObjectName = "rmi://" + host + "/Calculator";
        Naming.rebind(rmiObjectName, temp);
        System.out.println("Binding complete...\n");
    }
}
