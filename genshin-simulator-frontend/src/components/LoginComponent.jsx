import React, { useState } from 'react'
import { Link } from 'react-router-dom'

function LoginComponent() {
    return (
        <div>
            <h1>Login Component</h1>
            <Link to="/">
                <button>Go to home page</button>
            </Link>
        </div>
    )
}

export default LoginComponent