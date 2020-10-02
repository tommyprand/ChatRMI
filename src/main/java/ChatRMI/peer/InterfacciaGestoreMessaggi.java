package ChatRMI.peer;

import java.util.Vector;

import ChatRMI.Messaggio;

public interface InterfacciaGestoreMessaggi {
    void invia(Messaggio msg);
    Vector<Messaggio> leggi(int inizio, int fine);
}
