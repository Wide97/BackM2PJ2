package marcowidesott.BackM2PJ2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String fotoProfilo;

    public Dipendente(String email, String cognome, String nome, String username, String fotoProfilo) {
        this.email = email;
        this.cognome = cognome;
        this.nome = nome;
        this.username = username;
        this.fotoProfilo = fotoProfilo;
    }
}
