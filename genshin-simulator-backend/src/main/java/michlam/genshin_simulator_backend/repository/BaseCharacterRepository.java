package michlam.genshin_simulator_backend.repository;

import com.fasterxml.jackson.databind.ser.Serializers;
import michlam.genshin_simulator_backend.entity.BaseCharacter;
import michlam.genshin_simulator_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BaseCharacterRepository extends JpaRepository<BaseCharacter, String>{
    Optional<BaseCharacter> findByName(String name);
}