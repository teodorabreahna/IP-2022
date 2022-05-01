import React from "react";
import { Link } from "react-router-dom";
function Home() {
    return (
        <div class="im-pr">
            <img src="principal1.jpg" alt="errrstdsrsddsrrsttddrdsdrssddsdrrssrrssrddsssrdssrd" />
            <div class="im-pr2">
                <div class="mess1">
                    <h3>Curious about something?</h3>
                </div>
                <div class="mess2">
                    <h4>Tired of browsing countless websites <br /> for answers?</h4>
                </div>
                <div class="mess3">
                    <h3><br />Our application does all the <br /> hard work! We gather information from <br /> various sources and
                        process it just for you!</h3>
                    <br />
                </div>
                <div class="start">
                    <Link to="input">GET STARTED</Link>
                </div>
            </div>
        </div>
    );
}

export default Home;
