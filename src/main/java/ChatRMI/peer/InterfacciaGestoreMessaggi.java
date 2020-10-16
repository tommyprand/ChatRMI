package ChatRMI.peer;

public interface InterfacciaGestoreMessaggi {
    void invia(String dest, String cont);
    void legaFinestra(InterfacciaFinestraChat finestraChat);
}
