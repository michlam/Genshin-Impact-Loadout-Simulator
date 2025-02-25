import { getUserIdHelper, requireAuth } from "../utils";

export async function loader({ request }) {
    const data = await requireAuth(request);
    const userId = getUserIdHelper();
    
}

export default function Characters() {

    return (
        <main>
            <h1>This is characters</h1>
        </main>
    )
}