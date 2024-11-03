package marcowidesott.BackM2PJ2.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Dipendente dipendente;

    @ManyToOne
    private Viaggio viaggio;

    private LocalDate dataRichiesta;
    private String note;

    public Prenotazione(Dipendente dipendente, Viaggio viaggio, LocalDate dataRichiesta, String note) {
        this.dipendente = dipendente;
        this.viaggio = viaggio;
        this.dataRichiesta = dataRichiesta;
        this.note = note;
    }
}
