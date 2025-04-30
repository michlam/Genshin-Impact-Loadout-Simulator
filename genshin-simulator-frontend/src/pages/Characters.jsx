import { getBaseCharacters } from "../services/BaseCharacterService";
import { getUserCharactersById } from "../services/UserService";
import { getUserIdHelper, requireAuth } from "../utils";
import { useLoaderData, Await } from "react-router-dom";
import CharListItem from "../components/CharListItem.jsx";
import "./Characters.css"
import { useState } from "react";
import CharInfo from "../components/CharInfo";

export async function loader({ request }) {
    const userId = getUserIdHelper();
    console.log(sessionStorage.getItem("userId"));
    
    // We want a list of all characters, and a list of usercharacters
    const baseCharacters = await getBaseCharacters();
    const userCharacters = await getUserCharactersById(userId);

    return {
        "baseCharacters": baseCharacters.data,
        "userCharacters": userCharacters.data,
    }
}

function renderBaseCharacters(chars, setCharFocus) {
    const baseCharElements = chars.map((char) => (
        <CharListItem key={char.name} name={char.name} star={char.star} 
                      setCharFocus={setCharFocus}/> 
    ))

    return baseCharElements;
}

export default function Characters() {
    const {baseCharacters, userCharacters} = useLoaderData();
    const [charFocus, setCharFocus] = useState(null);
  
    const char = getCharacterInfo(charFocus, baseCharacters);
    let isUnlocked = false;
    if (char) isUnlocked = userCharacters.includes(char.name);


    return (
        <main className="characters">
            <fieldset className="character-list">
                <legend>Characters</legend>
                {renderBaseCharacters(baseCharacters, setCharFocus)}
            </fieldset>

            {charFocus ? <CharInfo char={char} isUnlocked={isUnlocked} /> : null}
        </main>
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

    return null;
}
