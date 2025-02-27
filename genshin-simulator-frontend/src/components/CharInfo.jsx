import "./CharInfo.css";

export default function CharInfo(props) {
    const char = getCharacterInfo(props.charFocus, props.baseCharacters);
    const imagePath = "../../characters/splasharts/" + 
        char.name.split(" ").join("_") + 
        "_Wish.webp";

    let starsElement = "";
    for (let i = 0; i < char.star; i++) {
        starsElement += "⭐";
    }

    let unlockButton;
    if (props.userCharacters.includes(char.name)) {
        unlockButton = 
            <button className="locked">
                Unlock Character
            </button> 
    } else {
        unlockButton = 
            <button className="unlocked">
                Character Already Unlocked
            </button>
    }
    

    return (
        <div className="char-info-border">
            <div className="char-info-container">
                <h2>{char.name}</h2>
                <h4>{char.title}</h4>
                <div className="char-info-details">
                    <section>
                        <h4>Rarity</h4>
                        <p>{starsElement}</p>
                    </section>
                    <section>
                        <h4>Element</h4>
                        <p>{char.element}</p>
                    </section>
                    <section>
                        <h4>Weapon</h4>
                        <p>{char.weapon_type}</p>
                    </section>
                </div>
                <img src={imagePath} alt={`${char.name} splashart`}/>
                
                {unlockButton}
            </div>
        </div>
    )
}

/**
 * Helper function to retrieve the information for the given charName. 
 * Return an object with name, title, star, element, and weapon_type
 */
function getCharacterInfo(charName, baseCharacters) {
    for (let i = 0; i < baseCharacters.length; i++) {
        if (baseCharacters[i].name === charName) return baseCharacters[i];
    }

    throw Error("Character focus does not exist.");
}
