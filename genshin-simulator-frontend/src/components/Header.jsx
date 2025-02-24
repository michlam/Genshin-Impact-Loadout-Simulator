import "./Components.css";
import { Link, NavLink } from "react-router-dom";

export default function Header() {
    // Active -> We are currently at this url
    const activeStyles = {
        fontWeight: "700",
    }

    return (
        <header>
            <Link className="site-logo" to="/">GENSHIN LOADOUTS</Link>
            <nav>
                <NavLink to="teams" style={({isActive}) => isActive ? activeStyles : null} className={"navlink"}>
                    Teams
                </NavLink>

                <NavLink to="characters" style={({isActive}) => isActive ? activeStyles : null} className={"navlink"}>
                    Characters
                </NavLink>

                <NavLink to="login" style={({isActive}) => isActive ? activeStyles : null} className={"navlink"}>
                    Log In
                </NavLink>
            </nav>
            
        </header>
    )
}