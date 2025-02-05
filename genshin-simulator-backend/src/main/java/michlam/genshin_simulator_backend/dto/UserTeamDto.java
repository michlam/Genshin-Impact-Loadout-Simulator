package michlam.genshin_simulator_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import michlam.genshin_simulator_backend.entity.keys.UserTeamKey;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserTeamDto {
    private UserTeamKey userTeamKey;
    private String character_name_1;
    private String character_name_2;
    private String character_name_3;
    private String character_name_4;
}
