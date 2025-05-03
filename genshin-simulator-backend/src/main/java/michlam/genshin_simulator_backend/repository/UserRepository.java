package michlam.genshin_simulator_backend.repository;

import michlam.genshin_simulator_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @NativeQuery("DELETE FROM genshin.users WHERE username LIKE 'test%';")
    void testDeleteUsers();
}
