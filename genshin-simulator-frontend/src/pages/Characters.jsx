import { getBaseCharacters } from "../services/BaseCharacterService";
import { getUserIdHelper, requireAuth } from "../utils";
import { useLoaderData } from "react-router-dom";

export async function loader({ request }) {
    await requireAuth(request);
    const userId = getUserIdHelper();
    
    // We want a list of all characters, and a list of usercharacters
    const baseCharacters = await getBaseCharacters();
    console.log(baseCharacters.data);
}

export default function Characters() {
    const loaderData = useLoaderData();

    return (
        <main>
            <h1>This is characters</h1>
        </main>
    )
}