package ChatRMI.peer;

import ChatRMI.Messaggio;

public interface InterfacciaFinestraChat {
    void aggiorna(Messaggio msg);
    void legaGestore(InterfacciaGestoreMessaggi gestoreMessaggi);
}
