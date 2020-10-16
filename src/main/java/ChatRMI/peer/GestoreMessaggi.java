package ChatRMI.peer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Hashtable;

import ChatRMI.Messaggio;
import ChatRMI.serverUtenti.InterfacciaServerUtenti;

public class GestoreMessaggi implements InterfacciaPeer, InterfacciaGestoreMessaggi {

    public static final String IPRegistry = "localhost";

    private String nomeUtente;
    private InterfacciaServerUtenti intServer;
    private InterfacciaFinestraChat finestraChat;
    private Hashtable<String, InterfacciaPeer> listaUtenti;

    public GestoreMessaggi(String nomeUtente) throws RemoteException, MalformedURLException, NotBoundException {
        InterfacciaServerUtenti intServer = (InterfacciaServerUtenti) Naming.lookup("rmi://" + IPRegistry + "/ServerUtenti");
        intServer.registra(nomeUtente, this);
        this.nomeUtente = nomeUtente;
        listaUtenti = intServer.getListaUtenti();
    }

    @Override
    public void invia(String dest, String cont) {
        Messaggio msg = new Messaggio(nomeUtente, dest, cont);
        InterfacciaPeer stubDestinatario = listaUtenti.get(msg.getNickDestinatario());
        try {
            stubDestinatario.ricevi(msg);
            finestraChat.aggiorna(msg);
        }
        catch (RemoteException e) {
            e.printStackTrace();
            try {
                listaUtenti = intServer.getListaUtenti();
            }
            catch (RemoteException e1) {
                e1.printStackTrace();
            }
        }
        
        
    }
    

    @Override
    public void ricevi(Messaggio msg) throws RemoteException {
        finestraChat.aggiorna(msg);
    }

    public void legaFinestra(InterfacciaFinestraChat finestraChat) {
        this.finestraChat = finestraChat;
    }
}
