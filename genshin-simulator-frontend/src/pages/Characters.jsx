import { getBaseCharacters } from "../services/BaseCharacterService";
import { getUserCharactersById } from "../services/UserService";
import { getUserIdHelper, requireAuth } from "../utils";
import { useLoaderData, Await } from "react-router-dom";
import CharListItem from "../components/CharListItem.jsx";
import "./Characters.css"
import { useState } from "react";
import CharInfo from "../components/CharInfo";

export async function loader({ request }) {
    await requireAuth(request);
    const userId = getUserIdHelper();
    
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
    console.log(userCharacters);

    return (
        <main className="characters">
            <div className="character-list">
                {renderBaseCharacters(baseCharacters, setCharFocus)}
            </div>

            {charFocus ? <CharInfo charFocus={charFocus} baseCharacters={baseCharacters} userCharacters={userCharacters}/> : null}
        </main>
    )
}