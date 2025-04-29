import { Form, Link, redirect, useActionData, useNavigation } from "react-router-dom";
import "./Login.css"
import { loginUser } from "../services/LoginService";
import { loginHelper } from "../utils";

export async function action({ request }) {
    const formData = await request.formData();
    const username = formData.get('username');
    const password = formData.get('password');
    const pathname = new URL(request.url).searchParams.get("redirectTo") || "/teams";

    try {
        const data = await loginUser(username, password);
        const userId = data.data.userId;
        const jwtToken = data.data.token;

        loginHelper(userId, username, jwtToken);
        return redirect(pathname);
    } catch (err) {
        return err.message;
    }
}


export default function Login() {
    const error = useActionData();
    const navigation = useNavigation();

    return (
        <main className="login">
            <div className="login-container">
                <h1>Log In</h1>
                {error ? <h4>Incorrect credentials. Please try again.</h4> : null}

                <Form method="post" className="login-form" replace>
                    <input name="username" type="username" placeholder="Username" />
                    <input name="password" type="password" placeholder="Password" />

                    <button>
                        {navigation.state === "submitting" ? "Logging in..." : "Log in"}
                    </button>
                </Form>

                <Link to={"/signUp"} className="login-container-link">
                    Don't have an account?
                </Link>
            </div>
        </main>
    )
}