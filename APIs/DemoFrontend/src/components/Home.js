import React from "react";
import { Link } from "react-router-dom";
function Home() {
    return (
       <section className="section2">
        <div className="im-pr">
            <img src="principal1.jpg" alt="errrstdsrsddsrrsttddrdsdrssddsdrrssrrssrddsssrdssrd" />
            <div className="im-pr2">
                <div className="mess1">
                    <h3>Curious about something?</h3>
                </div>
                <div className="mess2">
                    <h4>Tired of browsing countless websites <br /> for answers?</h4>
                </div>
                <div className="mess3">
                    <h3><br />Our application does all the <br /> hard work! We gather information from <br /> various sources and
                        process it just for you!</h3>
                    <br />
                </div>
                <div className="start">
                    <Link to="input">GET STARTED</Link>
                </div>
            </div>
        </div>
       </section> 
    );
}

export default Home;
