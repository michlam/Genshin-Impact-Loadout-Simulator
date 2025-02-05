package michlam.genshin_simulator_backend.repository;

import michlam.genshin_simulator_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
