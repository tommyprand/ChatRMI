package ChatRMI.peer;

import java.util.Vector;

import ChatRMI.Messaggio;

public class GestoreMessaggi implements InterfacciaPeer, InterfacciaGestoreMessaggi {

    private Vector<Messaggio> cronologiaMessaggi;
    private InterfacciaFinestraChat finestraChat; 

    @Override
    public void invia(Messaggio msg) {
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
    
}
