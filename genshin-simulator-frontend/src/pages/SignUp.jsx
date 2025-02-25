import { Form, Link, redirect, useActionData, useNavigation } from "react-router-dom"
import { signUpUser } from "../services/UserService";
import "./Login.css"

export async function action({ request }) {
    const formData = await request.formData();
    const username = formData.get('username');
    const password = formData.get('password');

    try {
        const data = await signUpUser(username, password);
        return redirect("/");
    } catch (err) {
        return err.message;
    }
}


export default function SignUp() {
    const error = useActionData();
    const navigation = useNavigation();

    return (
        <main className="login">
            <div className="login-container">
                <h1>Sign Up</h1>
                {error ? <h4>Please try another username.</h4> : null}
                
                <Form method="post" className="login-form" replace>
                    <input name="username" type="username" placeholder="Username" />
                    <input name="password" type="password" placeholder="Password" />

                    <button>
                        {navigation.state === "submitting" ? "Signing up..." : "Sign up"}
                    </button>
                </Form>

                <Link to={"/login"} className="login-container-link">
                    Already have an account?
                </Link>
            </div>
        </main>
    )
}

{/* <div className="sign-up-container">
<h1>Log In</h1>
{error ? <h4>Incorrect credentials. Please try again.</h4> : null}

<Form method="post" className="login-form" replace>
    <input name="username" type="username" placeholder="Username" />
    <input name="password" type="password" placeholder="Password" />

    <button>
        {navigation.state === "submitting" ? "Logging in..." : "Log in"}
    </button>
</Form>

<Link to={"/createAccount"} className="login-container-link">
    Don't have an account?
</Link>
</div> */}