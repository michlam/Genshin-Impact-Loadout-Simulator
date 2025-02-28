import { useLoaderData } from "react-router-dom";
import { getUserTeamsById } from "../services/UserService";
import { getUserIdHelper, requireAuth } from "../utils";
import "./Teams.css";

export async function loader({ request }) {
    await requireAuth(request);
    const userId = getUserIdHelper();
    
    // We want a list of all teams. Later, we might want base characters and user characters as well.
    const userTeams = await getUserTeamsById(userId);

    return {
        "userTeams": userTeams.data,
    }
}


export default function Teams() {
    const { userTeams } = useLoaderData();
    // console.log(userTeams);

    return (
        <main className="teams">
            <fieldset className="teams-list">
                <legend>Teams</legend>
                {/* {renderTeams(userTeams)} */}
            </fieldset>
        </main>
    )
}

{/* <main className="characters">
<fieldset className="character-list">
    <legend>Characters</legend>
    {renderBaseCharacters(baseCharacters, setCharFocus)}
</fieldset>

{charFocus ? <CharInfo char={char} isUnlocked={isUnlocked} /> : null}
</main> */}