package marcowidesott.BackM2PJ2.services;

import marcowidesott.BackM2PJ2.entities.Dipendente;
import marcowidesott.BackM2PJ2.exceptions.DipendenteNonTrovatoException;
import marcowidesott.BackM2PJ2.repositories.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    // Metodo per creare un nuovo dipendente
    public Dipendente creaDipendente(Dipendente dipendente) {
        return dipendenteRepository.save(dipendente);
    }

    // Metodo per recuperare un dipendente per ID
    public Dipendente getDipendenteById(Long id) {
        return dipendenteRepository.findById(id)
                .orElseThrow(() -> new DipendenteNonTrovatoException(id));
    }

    // Metodo per recuperare tutti i dipendenti
    public List<Dipendente> getAllDipendenti() {
        return dipendenteRepository.findAll();
    }

    // Metodo per aggiornare un dipendente esistente
    public Dipendente aggiornaDipendente(Long id, Dipendente nuovoDipendente) {
        Dipendente dipendenteEsistente = getDipendenteById(id);
        dipendenteEsistente.setUsername(nuovoDipendente.getUsername());
        dipendenteEsistente.setNome(nuovoDipendente.getNome());
        dipendenteEsistente.setCognome(nuovoDipendente.getCognome());
        dipendenteEsistente.setEmail(nuovoDipendente.getEmail());
        return dipendenteRepository.save(dipendenteEsistente);
    }

    // Metodo per eliminare un dipendente
    public void eliminaDipendente(Long id) {
        Dipendente dipendente = getDipendenteById(id);
        dipendenteRepository.delete(dipendente);
    }
}
