import { useLoaderData } from "react-router-dom";
import { getUserTeamsById } from "../services/UserService";
import { getUserIdHelper, requireAuth } from "../utils";
import "./Teams.css";

export async function loader({ request }) {
    await requireAuth(request);
    const userId = getUserIdHelper();
    
    // We want a list of all teams. Later, we might want base characters and user characters as well.
    console.log(userId);
    // const userTeams = await getUserTeamsById(userId);

    return {
        "userTeams": userTeams.data,
    }
}

function renderTeams(userTeams) {
    const userTeamsElements = userTeams.map((team, index) => {
        return renderTeam(
            index + 1,
            team.character_name_1,
            team.character_name_2,
            team.character_name_3,
            team.character_name_4,
        )
    })

    return userTeamsElements;
}

function renderTeam(teamNum, char1, char2, char3, char4) {
    const userTeamElement = (
        <>
            <details className="team" key={teamNum} name="team">
                <summary>{`Team ${teamNum}`}</summary>
                <div className="team-content">
                    <div className="char-container">
                        
                    </div>
                    <p>{`Character 1: ${char1}`}</p>
                    <p>{`Character 2: ${char2}`}</p>
                    <p>{`Character 3: ${char3}`}</p>
                    <p>{`Character 4: ${char4}`}</p>
                </div>
            </details>
        </>
    )

    return userTeamElement;
}

export default function Teams() {
    const { userTeams } = useLoaderData();

    return (
        <main className="teams">
            <fieldset className="teams-list">
                <legend>Teams</legend>
                {renderTeams(userTeams)}
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