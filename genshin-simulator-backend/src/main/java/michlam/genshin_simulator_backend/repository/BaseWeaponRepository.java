package michlam.genshin_simulator_backend.repository;

import michlam.genshin_simulator_backend.entity.BaseWeapon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BaseWeaponRepository extends JpaRepository<BaseWeapon, String> {
    Optional<BaseWeapon> findByName(String name);
}
