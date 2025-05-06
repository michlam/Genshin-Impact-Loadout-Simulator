import "./WeaponInfo.css";

export default function WeaponInfo(props) {
    const weapon = props.weapon;

    let starsElement = "";
    for (let i = 0; i < weapon.star; i++) {
        starsElement += "⭐";
    }

    const imagePath = getImagePath(weapon.name);

    return (
        <div className="weapon-info-border">
            <div className="weapon-info-container">
                <h2>{weapon.name}</h2>
                <h4>{starsElement}</h4>
                <div className="weapon-info-details">
                    <section>
                        <h4>Type</h4>
                        <p>{weapon.type}</p>
                    </section>
                    <section>
                        <h4>Attack</h4>
                        <p>{weapon.attack}</p>
                    </section>
                    <section>
                        <h4>Secondary</h4>
                        <p>{weapon.secondary}</p>
                    </section>
                </div>
                <img src={imagePath} alt={`${weapon.name} splashart`} loading="lazy"/>
                <div className="weapon-passive">
                    <h4>Passive Coming Soon</h4>
                </div>
                
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