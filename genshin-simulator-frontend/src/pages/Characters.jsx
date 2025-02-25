import { requireAuth } from "../utils";

export async function loader({ request }) {
    const data = await requireAuth(request);
    console.log(data);
    return null;
}

export default function Characters() {
    return (
        <main>
            <h1>This is characters</h1>
        </main>
    )
}