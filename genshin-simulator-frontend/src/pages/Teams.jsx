import { useLoaderData, useSearchParams } from "react-router-dom";
import { getUserCharactersById, getUserTeamsById } from "../services/UserService";
import { getUserIdHelper } from "../utils";
import "./Teams.css";
import { useState } from "react";
import Selector from "../components/Selector";
import { getBaseCharacters } from "../services/BaseCharacterService";

export async function loader({ request }) {
    const userId = getUserIdHelper();
    
    const baseCharacters = await getBaseCharacters();
    const userCharacters = await getUserCharactersById(userId);
    const userTeams = await getUserTeamsById(userId);

    return {
        "baseCharacters": baseCharacters.data,
        "userCharacters": userCharacters.data,
        "userTeams": userTeams.data,
    }
}

function renderTeams(userTeams, setFocus) {
    const userTeamsElements = userTeams.map((team, index) => {
        return renderTeam(
            index + 1,
            team.character_name_1,
            team.character_name_2,
            team.character_name_3,
            team.character_name_4,
            setFocus
        )
    })

    return userTeamsElements;
}

function renderTeam(teamNum, char1, char2, char3, char4, setFocus) {
    const userTeamElement = (
        <details className="team" key={teamNum} name="team">
            <summary>{`Team ${teamNum}`}</summary>
            <div className="team-content">
                <div className="char-container char1" onClick={() => setFocus({"teamNum": teamNum, "charNum": 1})}>
                    {char1 ? <img src={getImagePath(char1)} /> : <p>No character selected</p>}
                </div>
                <div className="char-container char2" onClick={() => setFocus({"teamNum": teamNum, "charNum": 2})}>
                    {char2 ? <img src={getImagePath(char2)} /> : <p>No character selected</p>}
                </div>
                <div className="char-container char3" onClick={() => setFocus({"teamNum": teamNum, "charNum": 3})}>
                    {char3 ? <img src={getImagePath(char3)} /> : <p>No character selected</p>}
                </div>
                <div className="char-container char4" onClick={() => setFocus({"teamNum": teamNum, "charNum": 4})}>
                    {char4 ? <img src={getImagePath(char4)} /> : <p>No character selected</p>}
                </div>

                </div>
        </details>
    )

    return userTeamElement;
}

export default function Teams() {
    const baseCharacters = useLoaderData().baseCharacters;
    const userCharacters = useLoaderData().userCharacters;
    const userTeamsData = useLoaderData().userTeams;
    const [userTeams, setUserTeams] = useState(userTeamsData);

    const [focus, setFocus] = useState(null);

    return (
        <main className="teams">
            <fieldset className="teams-list">
                <legend>Teams</legend>
                {renderTeams(userTeams, setFocus)}
            </fieldset>

            {
                !focus ? null :
                <Selector 
                    focus={focus} 
                    setFocus={setFocus}
                    userTeams={userTeams}
                    setUserTeams={setUserTeams} 
                    baseCharacters={baseCharacters} 
                    userCharacters={userCharacters}
                /> 
            }
        </main>
    )
}

function getImagePath(char) {
    return "../../characters/splasharts/" + char.split(" ").join("_") + "_Wish.webp";
}