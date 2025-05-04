package michlam.genshin_simulator_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseWeaponDto {
    private String name;
    private String type;
    private Integer star;
    private Integer attack;
    private String secondary;
    private String passive_name;
    private String passive_text;
}
