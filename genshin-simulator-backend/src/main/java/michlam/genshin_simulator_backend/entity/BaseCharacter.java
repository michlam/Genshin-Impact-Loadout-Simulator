package michlam.genshin_simulator_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "base_characters")
public class BaseCharacter {
    @Id
    private String name;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Integer star;

    @Column(nullable = false)
    private String element;

    @Column(nullable = false)
    private String weapon_type;
}
