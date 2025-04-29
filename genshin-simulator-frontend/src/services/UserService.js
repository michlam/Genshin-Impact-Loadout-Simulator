import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8080/api/users';



export const signUpUser = (username, password) => {
    const signUpBody = {
        "username": username,
        "password": password
    };

    return axios.post(REST_API_BASE_URL, signUpBody);
}

export const getUserCharactersById = (userId) => {
    const body = {
        "id": userId
    }

    return axios.post(REST_API_BASE_URL + "/characters", body, {
        headers: {
            'Authorization': `Bearer ${sessionStorage.getItem("token")}`
        }
    });
}

export const unlockUserCharacter = (userId, charName) => {
    const body = {
        "id": userId,
        "name": charName
    }

    return axios.post(REST_API_BASE_URL + "/characters/unlock", body);
}

export const getUserTeamsById = (userId) => {
    const body = {
        "id": userId
    }

    return axios.post(REST_API_BASE_URL + "/teams", body);
}

export const updateUserTeam = (userTeam) => {
    return axios.put(REST_API_BASE_URL + "/teams", userTeam);
}