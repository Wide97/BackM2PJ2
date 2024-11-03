package marcowidesott.BackM2PJ2.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PrenotazionePayload {
    private Long id;
    private Long dipendenteId;
    private Long viaggioId;
    private LocalDate dataRichiesta;
    private String note;

    public PrenotazionePayload(Long id, Long dipendenteId, Long viaggioId, LocalDate dataRichiesta, String note) {
        this.id = id;
        this.dipendenteId = dipendenteId;
        this.viaggioId = viaggioId;
        this.dataRichiesta = dataRichiesta;
        this.note = note;
    }
}
