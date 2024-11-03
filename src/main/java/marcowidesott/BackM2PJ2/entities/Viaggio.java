package marcowidesott.BackM2PJ2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Viaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String destinazione;
    private LocalDate data;
    private String stato;

    public Viaggio(String destinazione, LocalDate data, String stato) {
        this.destinazione = destinazione;
        this.data = data;
        this.stato = stato;
    }
}
