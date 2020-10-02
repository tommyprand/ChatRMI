package ChatRMI.serverUtenti;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Hashtable;

import ChatRMI.peer.InterfacciaPeer;

public interface InterfacciaServerUtenti extends Remote {
    void registra(String nick, InterfacciaPeer intPeer) throws RemoteException;
    void rimuovi(String nick) throws RemoteException;
    Hashtable<String, InterfacciaPeer> getListaUtenti() throws RemoteException;
}