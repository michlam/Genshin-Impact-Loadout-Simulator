package michlam.genshin_simulator_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import michlam.genshin_simulator_backend.entity.keys.UserCharacterKey;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_characters")
public class UserCharacter {
    @EmbeddedId
    private UserCharacterKey userCharacterKey;
}
