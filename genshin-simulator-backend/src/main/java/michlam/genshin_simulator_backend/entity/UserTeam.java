package michlam.genshin_simulator_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_teams")
public class UserTeam {
    @Id
    private Long user_id;

    @Id
    private Integer team_num;

    private String character_name_1;
    private String character_name_2;
    private String character_name_3;
    private String character_name_4;

}
