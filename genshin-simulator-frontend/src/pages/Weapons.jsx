import { useLoaderData } from "react-router-dom";
import { getBaseWeapons } from "../services/BaseWeaponService";
import { getUserIdHelper } from "../utils";
import "./Weapons.css"
import { useState } from "react";
import WeaponListItem from "../components/WeaponListItem";
import WeaponInfo from "../components/WeaponInfo";

export async function loader({ request }) {
    const userId = getUserIdHelper();
    const baseWeapons = await getBaseWeapons();

    return {
        "baseWeapons": baseWeapons.data,
    }
}

function renderBaseWeapons(weapons, setWeaponFocus) {
    const baseWeaponElements = weapons.map((weapon) => (
        <WeaponListItem key={weapon.name} name={weapon.name} star={weapon.star} attack={weapon.attack} seconday={weapon.secondary} 
                        passiveName={weapon.passive_name} passiveText={weapon.passive_test} type={weapon.type} 
                        setWeaponFocus={setWeaponFocus}
        />
    ))

    return baseWeaponElements;
}

export default function Weapons() {
    const {baseWeapons} = useLoaderData();
    const [weaponFocus, setWeaponFocus] = useState(null);

    const weapon = getWeaponInfo(weaponFocus, baseWeapons);

    return (
        <main className="weapons">
            <fieldset className="weapon-list">
                <legend>Weapons</legend>
                {renderBaseWeapons(baseWeapons, setWeaponFocus)}
            </fieldset>

            {weaponFocus ? <WeaponInfo weapon={weapon} /> : null}
        </main>
    )
}

/**
 * Helper function to retrieve the information for the given weaponName. 
 * Return an object with name, type, star, attack, secondary, 
 * passiveName, and passiveText
 */
function getWeaponInfo(weaponName, baseWeapons) {
    for (let i = 0; i < baseWeapons.length; i++) {
        if (baseWeapons[i].name === weaponName) return baseWeapons[i];
    }

    return null;
}
