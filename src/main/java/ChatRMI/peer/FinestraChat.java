package ChatRMI.peer;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import ChatRMI.Messaggio;

public class FinestraChat extends JFrame implements InterfacciaFinestraChat {

    private final static long serialVersionUID = 1;

    JPanel pannelloMessaggiServer;
    JPanel pannelloMessaggi;
    JTextArea campoMessaggio;

    InterfacciaGestoreMessaggi gestoreMessaggi;

    public FinestraChat() {
        //TODO
    }

    @Override
    public void aggiorna() {
        Vector<Messaggio> messaggi = gestoreMessaggi.leggi(0, gestoreMessaggi.getNumeroMessaggi());
    }

    @Override
    public void legaGestore(InterfacciaGestoreMessaggi gestoreMessaggi) {
        this.gestoreMessaggi = gestoreMessaggi;
    }
}
