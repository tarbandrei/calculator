
import java.rmi.*;
import java.rmi.server.*;

public class CalculatorImplementation extends UnicastRemoteObject implements ICalculator {

    public CalculatorImplementation() throws RemoteException {

    }

    @Override
    public Double add(Double x, Double y) throws RemoteException {
        return x + y;
    }

    @Override
    public Double sub(Double x, Double y) throws RemoteException {
        return x - y;
    }

    @Override
    public Double mult(Double x, Double y) throws RemoteException {
        return x * y;
    }

    @Override
    public Double div(Double x, Double y) throws RemoteException {
        return x / y;
    }

    @Override
    public Double inv(Double x) throws RemoteException {
        return 1.0 / x;
    }

    @Override
    public Double pow(Double x, Double y) throws RemoteException {
        return Math.pow(x, y);
    }

    @Override
    public Double fact(Double x) throws RemoteException {
        if (x >= 0) {
            Double f = 1D;
            for (int i = 1; i <= x; i++) {
                f = f * i;
            }
            return f;
        }
        return Double.NaN;
    }

    @Override
    public Double sqrt(Double x) throws RemoteException {
        return Math.sqrt(x);
    }

}
