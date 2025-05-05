package michlam.genshin_simulator_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "base_weapons")
public class BaseWeapon {
    @Id
    private String name;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Integer star;

    @Column(nullable = false)
    private Integer attack;

    @Column(nullable = false)
    private String secondary;

    @Column(nullable = false)
    private String passive_name;

    @Column(nullable = false)
    private String passive_text;
}
