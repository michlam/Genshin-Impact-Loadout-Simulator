import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8080/api/base-characters';

export const getBaseCharacters = () => {
    return axios.get(REST_API_BASE_URL,
        {
            headers: {
                'Authorization': `Bearer ${sessionStorage.getItem("token")}`
            }
        });
}

export const getBaseCharacterByName = (name) => {
    return axios.get(REST_API_BASE_URL + "/" + name,
    {
        headers: {
            'Authorization': `Bearer ${sessionStorage.getItem("token")}`
        }
    });
}