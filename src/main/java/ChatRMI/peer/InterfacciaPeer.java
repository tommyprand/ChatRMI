package ChatRMI.peer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import ChatRMI.Messaggio;

public interface InterfacciaPeer extends Remote {
    void ricevi(Messaggio msg) throws RemoteException;
}
