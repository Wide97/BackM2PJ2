package marcowidesott.BackM2PJ2.exceptions;

public class DipendenteNonTrovatoException extends RuntimeException {
    public DipendenteNonTrovatoException(Long id) {
        super("Dipendente con id " + id + " Non trovato");
    }
}
