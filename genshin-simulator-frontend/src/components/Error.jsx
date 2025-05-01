import { useRouteError } from "react-router-dom"
import GanyuUpsetEmoji from "../assets/emojis/ganyu_upset.webp";
import "./Components.css";

export default function Error() {
    const error = useRouteError();

    return (
        <main className="error">
            <h1>Oops, looks like there was an error. Please try logging in again.</h1>
            <img src={GanyuUpsetEmoji} />
        </main>
    )
}