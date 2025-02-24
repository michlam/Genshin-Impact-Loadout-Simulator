import "./Components.css";
import { Link } from "react-router-dom";

export default function Header() {
    return (
        <header>
            <Link className="site-logo" to="/">GENSHIN LOADOUTS</Link>
            <button>Sign in</button>
            
        </header>
    )
}