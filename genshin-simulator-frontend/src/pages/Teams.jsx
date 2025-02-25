import { requireAuth } from "../utils";

export async function loader({ request }) {
    const data = await requireAuth(request);
    console.log(data);
    return null;
}

export default function Teams() {
    return (
        <main>
            <h1>This is the teams page</h1>
        </main>
    )
}