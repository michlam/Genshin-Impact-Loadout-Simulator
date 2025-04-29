import { redirect } from "react-router-dom"

export async function requireAuth(request) {
    const pathname = new URL(request.url).pathname

    // TEMPORARILY FAKING LOGIN SESSIONS BY STORING A VARIABLE IN LOCAL STORAGE
    const isLoggedIn = localStorage.getItem("loggedin")

    if (false) {
        throw redirect(
            `/login?redirectTo=${pathname}`
        )
    }
}

 // WE ARE FAKING THE LOGIN WITH LOCAL STORAGE FOR NOW
export function loginHelper(userId, username, token) {
    sessionStorage.setItem('userId', userId);
    sessionStorage.setItem('username', username);
    sessionStorage.setItem('token', token);

    console.log(sessionStorage);
}

export function logoutHelper() {
    sessionStorage.clear();
}

export function getUserIdHelper() {
    return sessionStorage.getItem("userId");
}
