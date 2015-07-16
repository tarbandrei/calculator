
import java.rmi.*;

public interface ICalculator extends Remote {

    public Double add(Double x, Double y) throws RemoteException;

    public Double sub(Double x, Double y) throws RemoteException;

    public Double mult(Double x, Double y) throws RemoteException;

    public Double div(Double x, Double y) throws RemoteException;

    public Double inv(Double x) throws RemoteException;

    public Double pow(Double x, Double y) throws RemoteException;

    public Double fact(Double x) throws RemoteException;

    public Double sqrt(Double x) throws RemoteException;
}
