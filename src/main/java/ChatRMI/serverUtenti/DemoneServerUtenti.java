package ChatRMI.serverUtenti;

import java.net.MalformedURLException;
import java.rmi.AccessException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class DemoneServerUtenti {
    public static void main(String[] args) {
        ServerUtenti serverUtenti;
        try {
            serverUtenti = new ServerUtenti();
            Naming.rebind("/localhost/ServerUtenti", serverUtenti);
            System.out.println("Server utenti avviato correttamente");
        }
        catch (MalformedURLException e) {
            System.err.println("Errore");
        }
        catch (AccessException e) {
            System.err.println("Errore");
        }
        catch (RemoteException e) {
            System.err.println("Errore");
        }
    }
}
