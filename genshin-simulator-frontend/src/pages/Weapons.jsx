import { getBaseCharacters } from "../services/BaseCharacterService";
import { getUserCharactersById } from "../services/UserService";
import { getUserIdHelper } from "../utils";
import "./Weapons.css"

export async function loader({ request }) {
    // const userId = getUserIdHelper();
    // console.log(sessionStorage.getItem("userId"));
    
    // // We want a list of all characters, and a list of usercharacters
    // const baseCharacters = await getBaseCharacters();
    // const userCharacters = await getUserCharactersById(userId);

    // return {
    //     "baseCharacters": baseCharacters.data,
    //     "userCharacters": userCharacters.data,
    // }
}

export default function Weapons() {
    // const {baseCharacters, userCharacters} = useLoaderData();
    // const [charFocus, setCharFocus] = useState(null);
  
    // const char = getCharacterInfo(charFocus, baseCharacters);
    // let isUnlocked = false;
    // if (char) isUnlocked = userCharacters.includes(char.name);


    return (
        <main className="weapons">
            <fieldset className="weapon-list">
                <legend>Weapons</legend>
            </fieldset>
        </main>
    )
}
