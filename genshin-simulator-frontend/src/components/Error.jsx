import { useRouteError } from "react-router-dom"
import GanyuUpsetEmoji from "../assets/emojis/ganyu_upset.webp";
import "./Components.css";

export default function Error() {
    const error = useRouteError();
    console.log(error);

    return (
        <main className="error">
            <h1>Oops, looks like there was a server error. Please try again later.</h1>
            <img src={GanyuUpsetEmoji} />
        </main>
    )
}