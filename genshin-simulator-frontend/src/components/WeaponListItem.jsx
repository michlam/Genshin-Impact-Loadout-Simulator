export default function WeaponListItem(props) {
    const imagePath = getImagePath(props.name);
    const bgClass = getBgClass(props.star);

    return (
        <div className="weapon-list-item" onClick={() => props.setWeaponFocus(props.name)}>
            <div className={`weapon-img-container ${bgClass}`}>
                <img src={imagePath} />
            </div>
        </div>
    )
}

/**
 * Helper function to retrieve the weapon's image path
 */
function getImagePath(weaponName) {
    let name = weaponName.toLowerCase().split(" ").join("-");
    let imagePath = "/weapons/icons/" + name + ".png";

    return imagePath;
}

/**
 * Helper function to retrieve the weapon's background based on the star
 */
function getBgClass(star) {
    if (star == 5) return "five-star";
    if (star == 4) return "four-star";
    if (star == 3) return "three-star";
}

