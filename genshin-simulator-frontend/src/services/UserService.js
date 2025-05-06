import axios from "axios";

// const REST_API_BASE_URL = 'http://localhost:8080/api/users';
const REST_API_BASE_URL = 'https://casual-pangolin-seemingly.ngrok-free.app/api/users';

export const signUpUser = (username, password) => {
    const signUpBody = {
        "username": username,
        "password": password
    };

    return axios.post(REST_API_BASE_URL + "/add", signUpBody,
    {
        headers: {
            'ngrok-skip-browser-warning': '1' 
        }
    });
}

export const getUserCharactersById = (userId) => {
    const body = {
        "id": userId
    }

    return axios.post(REST_API_BASE_URL + "/characters", body, {
        headers: {
            'Authorization': `Bearer ${sessionStorage.getItem("token")}`,
            'ngrok-skip-browser-warning': '1' 
        }
    });
}

export const unlockUserCharacter = (userId, charName) => {
    const body = {
        "id": userId,
        "name": charName
    }

    return axios.post(REST_API_BASE_URL + "/characters/unlock", body, {
        headers: {
            'Authorization': `Bearer ${sessionStorage.getItem("token")}`,
            'ngrok-skip-browser-warning': '1' 
        }
    });
}

export const getUserTeamsById = (userId) => {
    const body = {
        "id": userId
    }

    return axios.post(REST_API_BASE_URL + "/teams", body, {
        headers: {
            'Authorization': `Bearer ${sessionStorage.getItem("token")}`,
            'ngrok-skip-browser-warning': '1' 
        }
    });
}

export const updateUserTeam = (userTeam) => {
    return axios.put(REST_API_BASE_URL + "/teams", userTeam, {
        headers: {
            'Authorization': `Bearer ${sessionStorage.getItem("token")}`,
            'ngrok-skip-browser-warning': '1' 
        }
    });
}