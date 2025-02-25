import { redirect } from "react-router-dom"

export async function requireAuth(request) {
    const pathname = new URL(request.url).pathname

    // TEMPORARILY FAKING LOGIN SESSIONS BY STORING A VARIABLE IN LOCAL STORAGE
    const isLoggedIn = localStorage.getItem("loggedin")

    if (!isLoggedIn) {
        throw redirect(
            `/login?redirectTo=${pathname}`
        )
    }
}
