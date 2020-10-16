package ChatRMI.peer;

import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;

import ChatRMI.Messaggio;
import ChatRMI.peer.componentiGUI.AreaMessaggio;
import ChatRMI.peer.componentiGUI.ComponenteMessaggio;
import ChatRMI.peer.componentiGUI.PannelloMessaggi;

public class FinestraChat extends JFrame implements InterfacciaFinestraChat {

    private final static long serialVersionUID = 1;

    private PannelloMessaggi pannelloMessaggi;
    private AreaMessaggio campoMessaggio;

    InterfacciaGestoreMessaggi gestoreMessaggi;

    public FinestraChat() {
        super("Chat");
        this.setSize(400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        pannelloMessaggi = new PannelloMessaggi();
        campoMessaggio = new AreaMessaggio();

        campoMessaggio.aggiungiAscoltatore((ActionEvent e) -> {
            String messaggio = campoMessaggio.getMessaggio();
            Scanner in = new Scanner(messaggio);
            String destinatario;
            String contenuto;
            if (in.hasNext()) {
                destinatario = in.next();
                if (destinatario.charAt(0) == '@') {
                    destinatario = destinatario.substring(1);
                    contenuto = in.nextLine();
                    gestoreMessaggi.invia(destinatario, contenuto);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Manca il nome utente", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
            in.close();
        });
    }

    @Override
    public void aggiorna(Messaggio msg) {
        pannelloMessaggi.aggiungiMessaggio(new ComponenteMessaggio(msg));
    }

    @Override
    public void legaGestore(InterfacciaGestoreMessaggi gestoreMessaggi) {
        this.gestoreMessaggi = gestoreMessaggi;
    }
}

