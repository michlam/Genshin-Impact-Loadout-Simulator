import GanyuUpsetEmoji from "../assets/emojis/ganyu_upset.webp";
import "./NotFound.css";

export default function NotFound() {
    return (
        <main className="not-found">
            <h1>The page you were looking for was not found.</h1>
            <img src={GanyuUpsetEmoji} />
        </main>
    )
}