import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8080/api/login';

export const loginUser = (username, password) => {
    const loginBody = {
        "username": username, 
        "password": password
    };

    console.log(loginBody);

    return axios.post(REST_API_BASE_URL, loginBody);
}