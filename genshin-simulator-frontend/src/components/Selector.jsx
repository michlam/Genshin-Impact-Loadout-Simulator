import "./Selector.css";

export default function Selector(props) {
    const userCharacters = props.userCharacters;
    const baseCharacters = props.baseCharacters;

    function renderCharacters() {
        const charElements = baseCharacters.map((char) => {
            if (!userCharacters.includes(char.name)) return null;
            // We have all the base characters that the user actually owns now.

            const imagePath = "../../characters/avatars/ui-avataricon-" + char.name.toLowerCase() + ".png";
            const bgClass = char.star == 5 ? "five-star" : "four-star";
        
            let name = char.name.split(" ");
            name = name[name.length - 1];

            return (
                <div className={`selector-list-item ${bgClass}`}>
                    <img src={imagePath}/>
                </div>
            )
        })

        return charElements;
    }

    return (
        <fieldset className="selector-container">
            <legend>Character Select</legend>
            Selector: {props.focus.teamNum}, {props.focus.charNum}
            {renderCharacters(props.focus.teamNum, props.focus.charNum)}
        </fieldset>
    )
}    