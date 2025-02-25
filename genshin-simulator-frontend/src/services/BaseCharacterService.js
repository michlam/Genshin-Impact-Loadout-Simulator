import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8080/api/base-characters';

export const getBaseCharacters = () => {
    return axios.get(REST_API_BASE_URL);
}

export const getBaseCharacterByName = (name) => {
    return axios.get(REST_API_BASE_URL + "/" + name);
}