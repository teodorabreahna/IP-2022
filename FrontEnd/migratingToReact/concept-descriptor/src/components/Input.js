import React from 'react'
import { useNavigate } from "react-router-dom";
function Input() {

    const navigate = useNavigate();

    const conceptHandler = (e) => {

        e.preventDefault();
        navigate("/results");
        console.log("HELLO");
    }

    return (
        <div className="im-pr-index2">
            <div className="search-bars">
                <form onSubmit={conceptHandler}>
                    <input type="text" className="sb" defaultValue="e.g. man" /><br />
                    <input type="text" className="sb" defaultValue="e.g. woman" /><br />
                    <button type="submit" className="submit">Submit</button>
                </form>
            </div>
            <img src="statistici.svg" alt="statistics" />
        </div>
    )
}

export default Input;

