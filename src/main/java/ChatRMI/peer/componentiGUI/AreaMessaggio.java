package ChatRMI.peer.componentiGUI;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;

public class AreaMessaggio extends JPanel {

    private static final long serialVersionUID = 1;
    
    private JTextArea areaMessaggio;
    private JButton btnInvio;

    public AreaMessaggio() {
        areaMessaggio = new JTextArea();
        btnInvio = new JButton("Invia");
    }

    public void aggiungiAscoltatore(ActionListener l) {
        btnInvio.addActionListener(l);
    }

    public String getMessaggio() {
        return areaMessaggio.getText();
    }
}
