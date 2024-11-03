package marcowidesott.BackM2PJ2.services;

import marcowidesott.BackM2PJ2.entities.Viaggio;
import marcowidesott.BackM2PJ2.exceptions.ViaggioNonTrovatoException;
import marcowidesott.BackM2PJ2.repositories.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViaggioService {

    @Autowired
    private ViaggioRepository viaggioRepository;

    // Metodo per creare un nuovo viaggio
    public Viaggio creaViaggio(Viaggio viaggio) {
        return viaggioRepository.save(viaggio);
    }

    // Metodo per recuperare un viaggio per ID
    public Viaggio getViaggioById(Long id) {
        return viaggioRepository.findById(id)
                .orElseThrow(() -> new ViaggioNonTrovatoException(id));
    }

    // Metodo per recuperare tutti i viaggi
    public List<Viaggio> getAllViaggi() {
        return viaggioRepository.findAll();
    }

    // Metodo per aggiornare un viaggio esistente
    public Viaggio aggiornaViaggio(Long id, Viaggio nuovoViaggio) {
        Viaggio viaggioEsistente = getViaggioById(id);
        viaggioEsistente.setDestinazione(nuovoViaggio.getDestinazione());
        viaggioEsistente.setData(nuovoViaggio.getData());
        viaggioEsistente.setStato(nuovoViaggio.getStato());
        return viaggioRepository.save(viaggioEsistente);
    }

    // Metodo per eliminare un viaggio
    public void eliminaViaggio(Long id) {
        Viaggio viaggio = getViaggioById(id);
        viaggioRepository.delete(viaggio);
    }
}
