package michlam.genshin_simulator_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseCharacterDto {
    private String name;
    private String title;
    private Integer star;
    private String element;
    private String weapon_type;
}
