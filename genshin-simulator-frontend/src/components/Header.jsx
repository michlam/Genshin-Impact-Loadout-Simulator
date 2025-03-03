import "./Components.css";
import { Link, NavLink } from "react-router-dom";

export default function Header() {
    // Active -> We are currently at this url
    const activeStyles = {
        fontWeight: "700",
    }

    const loginElement = (
        <NavLink to="login" style={({isActive}) => isActive ? activeStyles : null} className={"navlink"}>
            Log In
        </NavLink>
    )

    const logoutElement = (
        <NavLink to="login" style={({isActive}) => isActive ? activeStyles : null} onClick={() => { localStorage.clear() }} className={"navlink"}>
            Log Out
        </NavLink>
    )

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

                {localStorage.getItem("loggedin") ? logoutElement : loginElement}
            </nav>
            
        </header>
    )
}