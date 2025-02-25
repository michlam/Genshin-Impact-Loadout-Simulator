import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8080/api/users';

export const signUpUser = (username, password) => {
    const signUpBody = {
        "username": username,
        "password": password
    };

    return axios.post(REST_API_BASE_URL, signUpBody);
}