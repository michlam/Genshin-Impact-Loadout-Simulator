package michlam.genshin_simulator_backend.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class UserCharacterKey implements Serializable {
    @Column(nullable = false)
    private Long user_id;

    @Column(nullable = false)
    private String character_name;
}
