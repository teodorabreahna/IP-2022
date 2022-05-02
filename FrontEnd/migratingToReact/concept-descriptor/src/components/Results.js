import React from "react";



import { useLocation } from "react-router-dom";

function NavBar() {
    const navigator = useLocation();
    return (
        <nav className="results">
            <h1> This is results Page for concepts {navigator.state.firstConcept}, {navigator.state.secondConcept}</h1>
        </nav>
    );
}

export default NavBar;
