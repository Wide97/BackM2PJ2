package marcowidesott.BackM2PJ2.controllers;

import marcowidesott.BackM2PJ2.entities.Prenotazione;
import marcowidesott.BackM2PJ2.services.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @PostMapping
    public ResponseEntity<Prenotazione> creaPrenotazione(
            @RequestParam Long dipendenteId,
            @RequestParam Long viaggioId,
            @RequestParam LocalDate dataRichiesta,
            @RequestParam(required = false) String note) {

        Prenotazione prenotazione = prenotazioneService.creaPrenotazione(dipendenteId, viaggioId, dataRichiesta, note);
        return new ResponseEntity<>(prenotazione, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Prenotazione>> getAllPrenotazioni() {
        List<Prenotazione> prenotazioni = prenotazioneService.getAllPrenotazioni();
        return ResponseEntity.ok(prenotazioni);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminaPrenotazione(@PathVariable Long id) {
        prenotazioneService.eliminaPrenotazione(id);
        return ResponseEntity.noContent().build();
    }
}
