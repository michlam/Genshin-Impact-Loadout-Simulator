import "./CharInfo.css";

export default function WeaponInfo(props) {
    const weapon = props.weapon;

    let starsElement = "";
    for (let i = 0; i < weapon.star; i++) {
        starsElement += "⭐";
    }

    const imagePath = getImagePath(weapon.name);

    return (
        <div className="char-info-border">
            <div className="char-info-container">
                <h2>{weapon.name}</h2>
                <h4>{weapon.name}</h4>
                <div className="char-info-details">
                    <section>
                        <h4>Rarity</h4>
                        <p>{starsElement}</p>
                    </section>
                    <section>
                        <h4>Element</h4>
                        <p>{weapon.type}</p>
                    </section>
                    <section>
                        <h4>Weapon</h4>
                        <p>{weapon.attack}</p>
                    </section>
                </div>
                <img src={imagePath} alt={`${weapon.name} splashart`} loading="lazy"/>
                
            </div>
        </div>
    )
}

/**
 * Helper function to retrieve the weapon's image path
 */
function getImagePath(weaponName) {
    let name = weaponName.toLowerCase().split(" ").join("-");
    let imagePath = "/weapons/icons/" + name + ".png";

    return imagePath;
}