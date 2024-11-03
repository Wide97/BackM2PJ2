package marcowidesott.BackM2PJ2.services;

import marcowidesott.BackM2PJ2.entities.Dipendente;
import marcowidesott.BackM2PJ2.exceptions.DipendenteNonTrovatoException;
import marcowidesott.BackM2PJ2.repositories.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    public void uploadFotoProfilo(Long dipendenteId, MultipartFile file) {
        Dipendente dipendente = getDipendenteById(dipendenteId);

        // Salva l'immagine in una directory locale o in un servizio di archiviazione
        String uploadDir = "/path/to/upload/directory/";
        String filePath = uploadDir + file.getOriginalFilename();

        try {
            File dest = new File(filePath);
            file.transferTo(dest);
            dipendente.setFotoProfilo(filePath);
            dipendenteRepository.save(dipendente);
        } catch (IOException e) {
            throw new RuntimeException("Errore durante il caricamento della foto", e);
        }
    }
}
