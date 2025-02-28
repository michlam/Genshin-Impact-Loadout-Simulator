import { useLoaderData } from "react-router-dom";
import { getUserTeamsById } from "../services/UserService";
import { getUserIdHelper, requireAuth } from "../utils";

export async function loader({ request }) {
    await requireAuth(request);
    const userId = getUserIdHelper();
    
    // We want a list of all teams. Later, we might want base characters and user characters as well.
    const userTeams = await getUserTeamsById(userId);

    return {
        "userTeams": userTeams.data,
    }
}


export default function Teams() {
    const { userTeams } = useLoaderData();
    console.log(userTeams);

    return (
        <main>
            <h1>This is the teams page</h1>
        </main>
    )
}