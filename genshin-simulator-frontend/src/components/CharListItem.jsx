export default function CharListItem(props) {
    let imagePath = "../../characters/avatars/ui-avataricon-" + props.name.toLowerCase() + ".png";
    const bgClass = props.star == 5 ? "five-star" : "four-star";

    // We will omit any family names
    let name = props.name.split(" ");
    name = name[name.length - 1];

    // Exceptions
    if (props.name == "Kaedehara Kazuha") imagePath = "../../characters/avatars/ui-avataricon-kaedehara-kazuha.png";
    if (props.name == "Hu Tao") {
        imagePath = "../../characters/avatars/ui-avataricon-hu-tao.png";
        name = "Hu Tao";
    }

    return (
        <div className="char-list-item" onClick={() => props.setCharFocus(props.name)}>
            <div className={`char-img-container ${bgClass}`}>
                <img src={imagePath} />
                <p>{name}</p>
            </div>
        </div>
    )
}