// WE ARE FAKING THE LOGIN WITH LOCAL STORAGE FOR NOW
export function loginHelper(userId, username, token) {
    sessionStorage.setItem('userId', userId);
    sessionStorage.setItem('username', username);
    sessionStorage.setItem('token', token);
    sessionStorage.setItem('isLoggedIn', true);
}

export function logoutHelper() {
    sessionStorage.clear();
}

export function getUserIdHelper() {
    return sessionStorage.getItem("userId");
}
