package michlam.genshin_simulator_backend.service;
import michlam.genshin_simulator_backend.entity.BaseCharacter;
import java.util.List;

public interface BaseCharacterService {
    List<BaseCharacter> getBaseCharacters();
}