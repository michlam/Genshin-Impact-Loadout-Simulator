package michlam.genshin_simulator_backend.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserCharacterKey implements Serializable {
    @Column(nullable = false)
    private Long user_id;

    @Column(nullable = false)
    private String character_name;
}
