package michlam.genshin_simulator_backend.repository;

import michlam.genshin_simulator_backend.entity.UserCharacter;
import michlam.genshin_simulator_backend.entity.keys.UserCharacterKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserCharacterRepository extends JpaRepository<UserCharacter, UserCharacterKey> {
    @NativeQuery("SELECT character_name FROM genshin.user_characters WHERE user_id = ?1")
    List<String> findCharactersById(@Param("user_id") Long user_id);
}
