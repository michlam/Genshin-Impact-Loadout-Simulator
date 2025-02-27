import React from 'react'

export default function Footer() {
    return (
        <footer>
            <section>
                <div className='footer-left'>
                    <h4>GENSHIN LOADOUTS</h4>
                    <h1>Experiment with every team combination!</h1>
                    <p className='attribution'>
                        2025 Michael Lam. Assets from HoYoverse. All rights reserved to their respective owners.
                    </p>
                </div>

                <div className='footer-right'>
                    <h4>Socials</h4>
                    <p><a href="https://www.linkedin.com/in/michlam812/" target='_blank'>LinkedIn</a></p>
                    <p><a href="https://github.com/michlam" target="_blank">GitHub</a></p>
                </div>

                <button onClick={() => localStorage.clear()}>Clear user for logout</button>
            </section>
        </footer>
    )
}

