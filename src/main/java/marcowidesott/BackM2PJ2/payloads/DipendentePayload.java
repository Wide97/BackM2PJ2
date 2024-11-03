package marcowidesott.BackM2PJ2.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DipendentePayload {
    private Long id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String fotoProfilo;

    public DipendentePayload(Long id, String username, String nome, String cognome, String email, String fotoProfilo) {
        this.id = id;
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.fotoProfilo = fotoProfilo;
    }
}
