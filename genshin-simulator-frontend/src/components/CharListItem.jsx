export default function CharListItem(props) {
    const imagePath = "../../characters/avatars/ui-avataricon-" + props.name.toLowerCase() + ".png";
    const bgClass = props.star == 5 ? "five-star" : "four-star";

    // We will omit any family names
    let name = props.name.split(" ");
    name = name[name.length - 1];

    return (
        <div className="char-list-item">
            <div className={`char-img-container ${bgClass}`}>
                <img src={imagePath} />
                <p>{name}</p>
            </div>
        </div>
    )
}