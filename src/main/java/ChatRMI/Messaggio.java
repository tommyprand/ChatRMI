package ChatRMI;

public class Messaggio {
    
    private final String nickMittente;
    private final String nickDestinatario;
    private final String contenuto;

    public Messaggio(String nickMit, String nickDest, String cont) {
        nickMittente = nickMit;
        nickDestinatario = nickDest;
        contenuto = cont;
    }

    public String getNickMittente() {
        return nickMittente;
    }

    public String getNickDestinatario() {
        return nickDestinatario;
    }

    public String getContenuto() {
        return contenuto;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[nickMittente=" + nickMittente + ", nickDestinatario=" + nickDestinatario + ", contenuto=" + contenuto;
    }
}
