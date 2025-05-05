import { useLoaderData } from "react-router-dom";
import { getBaseWeapons } from "../services/BaseWeaponService";
import { getUserIdHelper } from "../utils";
import "./Weapons.css"
import { useState } from "react";

export async function loader({ request }) {
    const userId = getUserIdHelper();
    const baseWeapons = await getBaseWeapons();

    return {
        "baseWeapons": baseWeapons.data,
    }
}

export default function Weapons() {
    const {baseWeapons} = useLoaderData();
    const [weaponFocus, setWeaponFocus] = useState(null);


    return (
        <main className="weapons">
            <fieldset className="weapon-list">
                <legend>Weapons</legend>
            </fieldset>
        </main>
    )
}
