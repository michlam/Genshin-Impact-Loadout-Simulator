package michlam.genshin_simulator_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import michlam.genshin_simulator_backend.entity.keys.UserCharacterKey;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCharacterDto {
    private UserCharacterKey userCharacterKey;
}
