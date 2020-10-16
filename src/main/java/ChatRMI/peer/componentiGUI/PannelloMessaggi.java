package ChatRMI.peer.componentiGUI;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;

public class PannelloMessaggi extends JPanel {

    private Vector<ComponenteMessaggio> messaggi;

    public PannelloMessaggi() {
        messaggi = new Vector<>();
    }

    public void aggiungiMessaggio(ComponenteMessaggio msg) {
        messaggi.add(msg);
        repaint();
    }

    @Override
    public void repaint() {
        for (ComponenteMessaggio msg : messaggi) {
            msg.repaint();
        }
    }
    
}
