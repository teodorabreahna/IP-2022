import React from "react";
import { useLocation } from "react-router-dom";
import ResponseComponent from "./Results/ResponseComponent"



function Results() {
    const navigator = useLocation();
    

    return (
        <nav className="results">
            {/* <h1> This is results Page for concepts {navigator.state.firstConcept}, {navigator.state.secondConcept}</h1> */}
            <ResponseComponent firstConcept = {navigator.state.firstConcept}  secondConcept = {navigator.state.secondConcept} />
        </nav>
    );
}

export default Results;
