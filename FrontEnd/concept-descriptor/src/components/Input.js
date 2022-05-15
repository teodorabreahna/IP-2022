import React from 'react'
import { useNavigate } from "react-router-dom";
function Input() {
    let concept1;
    let concept2;
    const navigate = useNavigate();

    const conceptHandler = (e) => {

        e.preventDefault();
        navigate("/results", { state: { firstConcept: concept1, secondConcept: concept2 } });
        console.log("HELLO");
    }

    const onInputChange = (event) => {
        switch (event.target.id) {
            case "concept1":
                concept1 = event.target.value;
                console.log(concept1);
                break;
            case "concept2":
                concept2 = event.target.value;
                console.log(concept2);
                break;
            default: console.log("Input ID not found");
        }
    }

    return (
        <div className="im-pr-index2">
            <div className="search-bars">
                <form onSubmit={conceptHandler}> {/*daca e de schimbat, doar sa fie form si sa arg onSubmit*/}
                    <input id="concept1" type="text" className="sb" placeholder="e.g. man" onChange={onInputChange} /><br />
                    <button type="submit" className="submit2">Submit</button>
                    <input id="concept2" type="text" className="sb" placeholder="e.g. woman" onChange={onInputChange} /><br />
                    <button type="submit" className="submit">Submit</button>
                </form>
            </div>
            <img src="statistici.svg" alt="statistics" />
        </div>
    )


}

export default Input;

