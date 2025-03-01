import { useEffect } from "react";
import { updateUserTeam } from "../services/UserService";
import "./Selector.css";

export default function Selector(props) {
    const userCharacters = props.userCharacters;
    const baseCharacters = props.baseCharacters;

    function renderCharacters(teamNum, charNum) {
        const userTeam = props.userTeams[teamNum - 1];
        const teamChars = [userTeam.character_name_1, userTeam.character_name_2, userTeam.character_name_3, userTeam.character_name_4];

        let charElements = baseCharacters.map((char) => {
            if (!userCharacters.includes(char.name)) return null;

            const imagePath = "../../characters/avatars/ui-avataricon-" + char.name.toLowerCase() + ".png";
            const bgClass = char.star == 5 ? "five-star" : "four-star";
            const selectedClass = teamChars.includes(char.name) ? "selected" : "";
        
            let name = char.name.split(" ");
            name = name[name.length - 1];

            return (
                <div className={`selector-list-item ${bgClass} ${selectedClass}`} onClick={() => updateTeamHandler(teamNum, charNum, char.name, teamChars)}>
                    <img src={imagePath}/>
                </div>
            )
        })

        return charElements;
    }

    function updateTeamHandler(teamNum, charNum, charName, teamChars) {
        if (teamChars.includes(charName)) return;

        // Structured clone is needed because JS copies objects by reference
        let newUserTeams = structuredClone(props.userTeams);
        newUserTeams[teamNum - 1]["character_name_" + charNum] = charName;
        
        // Update the userteams state and call api
        props.setUserTeams(newUserTeams);
    }

    useEffect(() => {
        updateUserTeam(props.userTeams[props.focus.teamNum - 1]);
    }, [props.userTeams]);

    return (
        <fieldset className="selector-container">
            <legend>Team {props.focus.teamNum} - Character {props.focus.charNum}</legend>
 
            <div className="selector-list-item-none">
                None
            </div>
    
            {renderCharacters(props.focus.teamNum, props.focus.charNum)}
        </fieldset>
    )
}    