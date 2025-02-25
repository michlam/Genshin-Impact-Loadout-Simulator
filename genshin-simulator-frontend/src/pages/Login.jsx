import { Form, useNavigation } from "react-router-dom";
import "./Login.css"


export default function Login() {
    const navigation = useNavigation();

    return (
        <main className="login">
            <h1>Log In</h1>
            <Form method="post" className="login-form" replace>
                <input name="username" type="username" placeholder="Username" />
                <input name="password" type="password" placeholder="Password" />

                <button>
                    {navigation.state === "submitting" ? "Logging in..." : "Log in"}
                </button>
            </Form>
        </main>
    )
}