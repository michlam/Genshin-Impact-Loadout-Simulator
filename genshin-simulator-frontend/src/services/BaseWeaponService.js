import axios from "axios";

// const REST_API_BASE_URL = 'http://localhost:8080/api/base-weapons';
const REST_API_BASE_URL = 'https://casual-pangolin-seemingly.ngrok-free.app/api/base-weapons';

export const getBaseWeapons = () => {
    return axios.get(REST_API_BASE_URL,
        {
            headers: {
                'Authorization': `Bearer ${sessionStorage.getItem("token")}`,
                'ngrok-skip-browser-warning': '1' 
            }
        });
}

export const getBaseWeaponByName = (name) => {
    return axios.get(REST_API_BASE_URL + "/" + name,
    {
        headers: {
            'Authorization': `Bearer ${sessionStorage.getItem("token")}`,
            'ngrok-skip-browser-warning': '1' 
        }
    });
}