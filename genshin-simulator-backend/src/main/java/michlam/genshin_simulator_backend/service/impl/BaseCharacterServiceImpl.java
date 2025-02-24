package michlam.genshin_simulator_backend.service.impl;

import lombok.AllArgsConstructor;
import michlam.genshin_simulator_backend.dto.BaseCharacterDto;
import michlam.genshin_simulator_backend.entity.BaseCharacter;
import michlam.genshin_simulator_backend.exception.ResourceNotFoundException;
import michlam.genshin_simulator_backend.mapper.Mapper;
import michlam.genshin_simulator_backend.repository.BaseCharacterRepository;
import michlam.genshin_simulator_backend.service.BaseCharacterService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BaseCharacterServiceImpl implements BaseCharacterService {
    private BaseCharacterRepository baseCharacterRepository;

    @Override
    public List<BaseCharacterDto> getBaseCharacters() {
        List<BaseCharacter> baseCharacters = baseCharacterRepository.findAll();
        List<BaseCharacterDto> baseCharacterDtos = new ArrayList<BaseCharacterDto>();

        for (BaseCharacter baseCharacter : baseCharacters) {
            baseCharacterDtos.add(Mapper.mapToBaseCharacterDto(baseCharacter));
        }

        return baseCharacterDtos;
    }
}
