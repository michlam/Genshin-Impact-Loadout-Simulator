import React from 'react'

function FooterComponent() {
    const style = {     
        width: "100%",
        fontSize: '11px',
        position: "absolute",
        bottom: "0",
        marginBottom: "5px",
        alignSelf: "center",
    }

    return (
        <div style={style}>
            <p>2025 - Made by <a href="https://github.com/michlam">Michael Lam</a>. Assets from HoYoverse. All rights reserved.</p>
        </div>
    )
}

export default FooterComponent
