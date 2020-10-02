package ChatRMI.serverUtenti;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

import ChatRMI.peer.InterfacciaPeer;

public class ServerUtenti extends UnicastRemoteObject implements InterfacciaServerUtenti {

    private Hashtable<String, InterfacciaPeer> tabellaUtenti;

    public ServerUtenti() throws RemoteException {
        tabellaUtenti = new Hashtable<>();
    }

    @Override
    public void registra(String nick, InterfacciaPeer intPeer) throws RemoteException {
        if (tabellaUtenti.containsKey(nick)) throw new RemoteException("Il nome utente è già in utilizzo.");

        tabellaUtenti.put(nick, intPeer);

    }

    @Override
    public void rimuovi(String nick) throws RemoteException {
        if (tabellaUtenti.containsKey(nick)) {
            tabellaUtenti.remove(nick);
        }

    }

    @Override
    public Hashtable<String, InterfacciaPeer> getListaUtenti() throws RemoteException {
        return (Hashtable<String, InterfacciaPeer>) tabellaUtenti.clone();
    }
    
}
