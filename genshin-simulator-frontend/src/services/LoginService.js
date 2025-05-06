import axios from "axios";

// const REST_API_BASE_URL = 'http://localhost:8080/api/login';
const REST_API_BASE_URL = 'https://casual-pangolin-seemingly.ngrok-free.app/api/login';


export const loginUser = (username, password) => {
    const loginBody = {
        "username": username, 
        "password": password
    };

    return axios.post(REST_API_BASE_URL, loginBody,
        {
            headers: {
                'ngrok-skip-browser-warning': '1' 
            }
        });
}
