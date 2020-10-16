package ChatRMI.peer.componentiGUI;

import javax.swing.JLabel;

import ChatRMI.Messaggio;

public class ComponenteMessaggio extends JLabel {
    
    public ComponenteMessaggio(Messaggio msg) {
        super("@" + msg.getNickMittente() + ": " + msg.getContenuto());
    }
}
