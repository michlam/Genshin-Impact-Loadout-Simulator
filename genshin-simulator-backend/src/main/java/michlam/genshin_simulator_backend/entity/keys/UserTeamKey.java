package michlam.genshin_simulator_backend.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
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
public class UserTeamKey implements Serializable {
    @Column(nullable = false)
    private Long user_id;

    @Column(nullable = false)
    private Integer team_num;
}
