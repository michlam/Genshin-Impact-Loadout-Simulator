import "./CharInfo.css";

export default function CharInfo(props) {
    const char = getCharacterInfo(props.charFocus, props.baseCharacters);
    const imagePath = "../../public/characters/splasharts/" + 
        char.name.split(" ").join("_") + 
        "_Wish.webp";
    

    return (
        <div className="char-info-container">
            <img src={imagePath} />
            <p>{char.name}</p>
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