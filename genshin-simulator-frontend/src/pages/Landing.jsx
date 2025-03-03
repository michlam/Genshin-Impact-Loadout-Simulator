import { Link } from "react-router-dom";
import "./Landing.css";

export default function Landing() {
    return (
        <main className="landing">
            <div className="landing-content">
                <h1>
                    Optimize your Genshin Impact team loadouts and builds.
                </h1>

                <Link to="/teams" className="landing-link">
                    Customize your teams
                </Link>
            </div>
        </main>
    )
}