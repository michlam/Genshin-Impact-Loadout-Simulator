package michlam.genshin_simulator_backend.repository;

import michlam.genshin_simulator_backend.entity.UserCharacter;
import michlam.genshin_simulator_backend.entity.keys.UserCharacterKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCharacterRepository extends JpaRepository<UserCharacter, UserCharacterKey> {
}
