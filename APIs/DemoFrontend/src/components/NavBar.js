import React from "react";
import { Link } from "react-router-dom";
function NavBar() {
    return (
       <section class="section1"> 
        <nav className="navbar">
            <div className="title">
                <img src="iconita.svg" alt="LOGO" />
                <h2>Concept Descriptor</h2>
            </div>
            <ul>
                <li><Link to="about">ABOUT</Link></li>
                <li><Link to="/">HOME</Link></li>
            </ul>
        </nav>
       </section> 
    );
}

export default NavBar;
