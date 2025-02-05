package michlam.genshin_simulator_backend.repository;

import michlam.genshin_simulator_backend.entity.BaseCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseCharacterRepository extends JpaRepository<BaseCharacter, String>{
}