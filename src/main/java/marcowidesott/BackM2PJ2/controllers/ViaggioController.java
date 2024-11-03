package marcowidesott.BackM2PJ2.controllers;

import marcowidesott.BackM2PJ2.entities.Assegnazione;
import marcowidesott.BackM2PJ2.entities.Viaggio;
import marcowidesott.BackM2PJ2.services.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioService viaggioService;

    @PostMapping
    public ResponseEntity<Viaggio> creaViaggio(@RequestBody Viaggio viaggio) {
        Viaggio nuovoViaggio = viaggioService.creaViaggio(viaggio);
        return new ResponseEntity<>(nuovoViaggio, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Viaggio> getViaggioById(@PathVariable Long id) {
        Viaggio viaggio = viaggioService.getViaggioById(id);
        return ResponseEntity.ok(viaggio);
    }

    @GetMapping
    public ResponseEntity<List<Viaggio>> getAllViaggi() {
        List<Viaggio> viaggi = viaggioService.getAllViaggi();
        return ResponseEntity.ok(viaggi);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Viaggio> aggiornaViaggio(@PathVariable Long id, @RequestBody Viaggio nuovoViaggio) {
        Viaggio viaggioAggiornato = viaggioService.aggiornaViaggio(id, nuovoViaggio);
        return ResponseEntity.ok(viaggioAggiornato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminaViaggio(@PathVariable Long id) {
        viaggioService.eliminaViaggio(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{viaggioId}/assegna-dipendente/{dipendenteId}")
    public ResponseEntity<Assegnazione> assegnaDipendente(
            @PathVariable Long viaggioId,
            @PathVariable Long dipendenteId) {
        Assegnazione assegnazione = viaggioService.assegnaDipendente(viaggioId, dipendenteId);
        return ResponseEntity.ok(assegnazione);
    }

}
