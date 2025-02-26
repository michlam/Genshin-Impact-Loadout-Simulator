export default function CharListItem(props) {
    const imagePath = "../../characters/avatars/ui-avataricon-" + props.name.toLowerCase() + ".png";
    const bgClass = props.star == 5 ? "five-star" : "four-star";

    return (
        <div className="char-list-item">
            <div className={`char-img-container ${bgClass}`}>
                <img src={imagePath} />
            </div>
            {props.name}
        </div>
    )
}