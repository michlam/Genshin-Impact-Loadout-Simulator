import React from 'react'
import { Link } from 'react-router-dom'

function HomeComponent() {
  return (
    <div>
      <h1>Home Component</h1>
      <Link to="/login">
        <button>Go to login page</button>
      </Link>
    </div>
  )
}

export default HomeComponent