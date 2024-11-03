package marcowidesott.BackM2PJ2.services;

import marcowidesott.BackM2PJ2.entities.Dipendente;
import marcowidesott.BackM2PJ2.entities.Prenotazione;
import marcowidesott.BackM2PJ2.entities.Viaggio;
import marcowidesott.BackM2PJ2.exceptions.PrenotazioneNonValidaException;
import marcowidesott.BackM2PJ2.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private DipendenteService dipendenteService;

    @Autowired
    private ViaggioService viaggioService;

    // Metodo per creare una nuova prenotazione
    public Prenotazione creaPrenotazione(Long dipendenteId, Long viaggioId, LocalDate dataRichiesta, String note) {
        Dipendente dipendente = dipendenteService.getDipendenteById(dipendenteId);
        Viaggio viaggio = viaggioService.getViaggioById(viaggioId);

        // Verifica che non ci sia già una prenotazione per lo stesso dipendente e data
        List<Prenotazione> prenotazioniEsistenti = prenotazioneRepository
                .findByDipendenteAndDataRichiesta(dipendente, dataRichiesta);

        if (!prenotazioniEsistenti.isEmpty()) {
            throw new PrenotazioneNonValidaException("Il dipendente ha già una prenotazione per questa data.");
        }

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setDipendente(dipendente);
        prenotazione.setViaggio(viaggio);
        prenotazione.setDataRichiesta(dataRichiesta);
        prenotazione.setNote(note);

        return prenotazioneRepository.save(prenotazione);
    }

    // Metodo per recuperare tutte le prenotazioni
    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneRepository.findAll();
    }

    // Metodo per eliminare una prenotazione
    public void eliminaPrenotazione(Long id) {
        Prenotazione prenotazione = prenotazioneRepository.findById(id)
                .orElseThrow(() -> new PrenotazioneNonValidaException("Prenotazione non trovata"));
        prenotazioneRepository.delete(prenotazione);
    }
}
