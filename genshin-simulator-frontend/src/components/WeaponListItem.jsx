export default function WeaponListItem(props) {
    // TODO: NEED MORE PREP WORK FOR THE IMAGE PATH (ex: remove apostrophes)
    let imagePath = "../../characters/avatars/ui-avataricon-" + props.name.toLowerCase() + ".png";

    let bgClass;
    if (props.star == 5) bgClass = "five-star";
    if (props.star == 4) bgClass = "four-star";
    if (props.star == 3) bgClass = "three-star";

    // We will omit any family names
    let name = props.name.split(" ");
    name = name[name.length - 1];

    return (
        <div className="weapon-list-item" onClick={() => props.setWeaponFocus(props.name)}>
            <div className={`weapon-img-container ${bgClass}`}>
                <img src={imagePath} />
            </div>
        </div>
    )
}