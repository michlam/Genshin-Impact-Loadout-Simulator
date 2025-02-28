import { useLoaderData, useSearchParams } from "react-router-dom";
import { getUserTeamsById } from "../services/UserService";
import { getUserIdHelper, requireAuth } from "../utils";
import "./Teams.css";
import { useState } from "react";

export async function loader({ request }) {
    await requireAuth(request);
    const userId = getUserIdHelper();
    
    // We want a list of all teams. Later, we might want base characters and user characters as well.
    const userTeams = await getUserTeamsById(userId);

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
                        {char1 ? <img src={getImagePath(char1)} /> : <p>No character selected</p>}
                    </div>
                    <div className="char-container">
                        {char2 ? <img src={getImagePath(char2)} /> : <p>No character selected</p>}
                    </div>
                    <div className="char-container">
                        {char3 ? <img src={getImagePath(char3)} /> : <p>No character selected</p>}
                    </div>
                    <div className="char-container">
                        {char4 ? <img src={getImagePath(char4)} /> : <p>No character selected</p>}
                    </div>
 
                </div>
            </details>
        </>
    )

    return userTeamElement;
}

export default function Teams() {
    const userTeamsData = useLoaderData().userTeams;
    const [userTeams, setUserTeams] = useState(userTeamsData);

    return (
        <main className="teams">
            <fieldset className="teams-list">
                <legend>Teams</legend>
                {renderTeams(userTeams)}
            </fieldset>
        </main>
    )
}

function getImagePath(char) {
    return "../../characters/splasharts/" + char.split(" ").join("_") + "_Wish.webp";
}

{/* <main className="characters">
<fieldset className="character-list">
    <legend>Characters</legend>
    {renderBaseCharacters(baseCharacters, setCharFocus)}
</fieldset>

{charFocus ? <CharInfo char={char} isUnlocked={isUnlocked} /> : null}
</main> */}