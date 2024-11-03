package marcowidesott.BackM2PJ2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Exceptions {

    @ExceptionHandler(ViaggioNonTrovatoException.class)
    public ResponseEntity<String> handleViaggioNonTrovatoException(ViaggioNonTrovatoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DipendenteNonTrovatoException.class)
    public ResponseEntity<String> handleDipendenteNonTrovatoException(DipendenteNonTrovatoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PrenotazioneNonValidaException.class)
    public ResponseEntity<String> handlePrenotazioneNonValidaException(PrenotazioneNonValidaException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Gestione generica di tutte le altre eccezioni
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return new ResponseEntity<>("Si è verificato un errore: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

