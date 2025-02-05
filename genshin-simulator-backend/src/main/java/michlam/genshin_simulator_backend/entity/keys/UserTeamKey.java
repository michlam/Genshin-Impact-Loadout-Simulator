package michlam.genshin_simulator_backend.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

import java.io.Serializable;

@Embeddable
public class UserTeamKey implements Serializable {
    @Column(nullable = false)
    private Long user_id;

    @Column(nullable = false)
    private Integer team_num;
}
