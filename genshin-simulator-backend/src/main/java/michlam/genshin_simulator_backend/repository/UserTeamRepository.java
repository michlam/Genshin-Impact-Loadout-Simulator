package michlam.genshin_simulator_backend.repository;

import michlam.genshin_simulator_backend.entity.BaseCharacter;
import michlam.genshin_simulator_backend.entity.UserTeam;
import michlam.genshin_simulator_backend.entity.keys.UserTeamKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserTeamRepository extends JpaRepository<UserTeam, UserTeamKey> {
    @NativeQuery("SELECT * FROM genshin.user_teams WHERE user_id = ?1")
    List<UserTeam> findTeamsById(@Param("user_id") Long user_id);

    @NativeQuery("SELECT * FROM genshin.user_teams WHERE user_id = ?1 AND team_num = ?2")
    UserTeam findTeamByIdAndNum(@Param("user_id") Long user_id, @Param("team_num") Integer team_num);
}
