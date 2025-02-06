import { Navigate, Outlet } from "react-router-dom";

export default function AuthRoute({ isLoggedIn }) {
    const LOGIN_PATH = '/login'
    const HOME_PATH = '/'

    console.log("isLoggedIn");
    if (!isLoggedIn) {
        return <Navigate to={LOGIN_PATH} replace />;
    } else {
        return <Navigate to={HOME_PATH} replace />;
    }
}