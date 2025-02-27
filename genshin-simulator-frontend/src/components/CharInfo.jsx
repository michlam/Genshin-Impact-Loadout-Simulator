import { useState } from "react";
import { unlockUserCharacter } from "../services/UserService";
import { getUserIdHelper } from "../utils";
import "./CharInfo.css";
import { useNavigate } from "react-router-dom";


export default function CharInfo(props) {
    const navigate = useNavigate();
    const char = props.char;

    async function handleUnlock() {
        try {
            const data = await unlockUserCharacter(getUserIdHelper(), props.char.name);

            // Do a refresh to ensure that the 
            navigate(0);
        } catch (err) {
            console.log(err.message);
            return err.message;
        }
    }

    const unlockButtonElement = props.isUnlocked ?
        (<button className="unlocked">
            Character Already Unlocked
        </button>) :
        (<button onClick={handleUnlock}>
            Unlock Character
        </button>)


    let starsElement = "";
    for (let i = 0; i < char.star; i++) {
        starsElement += "⭐";
    }

    const imagePath = "../../characters/splasharts/" + char.name.split(" ").join("_") + "_Wish.webp";

    return (
        <div className="char-info-border">
            <div className="char-info-container">
                <h2>{char.name}</h2>
                <h4>{char.title}</h4>
                <div className="char-info-details">
                    <section>
                        <h4>Rarity</h4>
                        <p>{starsElement}</p>
                    </section>
                    <section>
                        <h4>Element</h4>
                        <p>{char.element}</p>
                    </section>
                    <section>
                        <h4>Weapon</h4>
                        <p>{char.weapon_type}</p>
                    </section>
                </div>
                <img src={imagePath} alt={`${char.name} splashart`}/>
                
                {unlockButtonElement}
            </div>
        </div>
    )
}