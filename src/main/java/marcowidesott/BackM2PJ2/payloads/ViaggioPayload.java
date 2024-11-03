package marcowidesott.BackM2PJ2.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ViaggioPayload {
    private Long id;
    private String destinazione;
    private LocalDate data;
    private String stato;

    public ViaggioPayload(Long id, String destinazione, LocalDate data, String stato) {
        this.id = id;
        this.destinazione = destinazione;
        this.data = data;
        this.stato = stato;
    }

}