package michlam.genshin_simulator_backend.service;
import michlam.genshin_simulator_backend.dto.BaseCharacterDto;
import michlam.genshin_simulator_backend.entity.BaseCharacter;
import java.util.List;

public interface BaseCharacterService {
    List<BaseCharacterDto> getBaseCharacters();
    BaseCharacterDto getBaseCharacterByName(String name);
}