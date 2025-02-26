import { getBaseCharacters } from "../services/BaseCharacterService";
import { getUserCharactersById } from "../services/UserService";
import { getUserIdHelper, requireAuth } from "../utils";
import { useLoaderData, Await } from "react-router-dom";
import CharListItem from "../components/CharListItem.jsx";
import "./Characters.css"

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

function renderBaseCharacters(chars) {
    const baseCharElements = chars.map((char) => (
        <CharListItem key={char.name} name={char.name} star={char.star} /> 
    ))

    return baseCharElements;
}

export default function Characters() {
    const {baseCharacters, userCharacters} = useLoaderData();

    return (
        <main className="characters">
            <div className="character-list">
                {renderBaseCharacters(baseCharacters)}
            </div>
        </main>
    )
}