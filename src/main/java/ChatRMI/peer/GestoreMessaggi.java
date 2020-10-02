package ChatRMI.peer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Vector;

import ChatRMI.Messaggio;
import ChatRMI.serverUtenti.InterfacciaServerUtenti;

public class GestoreMessaggi implements InterfacciaPeer, InterfacciaGestoreMessaggi {

    private Vector<Messaggio> cronologiaMessaggi;
    private InterfacciaFinestraChat finestraChat;

    @Override
    public void invia(Messaggio msg) {
        String IPserverUtenti = "localhost";
        try {
            InterfacciaServerUtenti intServer = (InterfacciaServerUtenti) Naming.lookup("rmi://" + IPserverUtenti + "/ServerUtenti");
            InterfacciaPeer stubDestinatario = intServer.getListaUtenti().get(msg.getNickDestinatario());
            stubDestinatario.ricevi(msg);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        cronologiaMessaggi.add(msg);
        finestraChat.aggiorna();
    }

    @Override
    public Vector<Messaggio> leggi(int inizio, int fine) {
        return (Vector<Messaggio>) cronologiaMessaggi.subList(inizio, fine);
    }

    @Override
    public void ricevi(Messaggio msg) {
        cronologiaMessaggi.add(msg);
        finestraChat.aggiorna();
    }

    public void legaFinestra(InterfacciaFinestraChat finestraChat) {
        this.finestraChat = finestraChat;
    }

    @Override
    public int getNumeroMessaggi() {
        return cronologiaMessaggi.size();
    }
    
}
