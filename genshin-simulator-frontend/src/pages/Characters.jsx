import { Suspense } from "react";
import { getBaseCharacters } from "../services/BaseCharacterService";
import { getUserCharactersById } from "../services/UserService";
import { getUserIdHelper, requireAuth } from "../utils";
import { useLoaderData, Await } from "react-router-dom";

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
        <p key={char.name}>{char.name}</p>
    ))

    return baseCharElements;
}

export default function Characters() {
    const {baseCharacters, userCharacters} = useLoaderData();

    return (
        <main>
            <h1>This is characters</h1>
            {renderBaseCharacters(baseCharacters)}
        </main>
    )
}