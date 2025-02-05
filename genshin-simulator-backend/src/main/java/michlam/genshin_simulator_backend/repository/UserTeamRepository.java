package michlam.genshin_simulator_backend.repository;

import michlam.genshin_simulator_backend.entity.UserTeam;
import michlam.genshin_simulator_backend.entity.keys.UserTeamKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTeamRepository extends JpaRepository<UserTeam, UserTeamKey> {
}
