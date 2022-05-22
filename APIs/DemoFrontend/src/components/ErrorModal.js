import React from "react";
import { useNavigate } from "react-router-dom";

function LoginLayout(props) {
  
    let navigate = useNavigate(); 
    const routeChange = () =>{ 
      let path = `/input`; 
      navigate(path);
    }
    console.log(props.jsonData);
    let errorBody = JSON.parse(props.jsonData);
    let endPoint = errorBody.config.url;
  
    return (
        <div className="frame">
                         <div className="modal">
                             <img src="https://www.svgrepo.com/show/283971/alarm.svg" width="44" height="38" />
                            <span className="errorTitle">Oh snap!</span>
                           {
                                 endPoint.includes("crawler")?
                                 <p style={{fontWeight: "bold"}}>It seems like the concepts are invalid. <br/> We couldn't find anything related to them.</p> :  <p>An error has occured. <br/></p>
                             }
                          
                           
                             <p>Error Name: {errorBody.name ? errorBody.name : "none"}</p>
                             <p>Message: {errorBody.message ? errorBody.message : "none"}<br/></p>
                             <p>Status: {errorBody.status ?  errorBody.status : "none"}<br/></p>
                             <p>Code: {errorBody.code ? errorBody.code : "none"}<br/></p>
                         <p>EndPoint that failed: {errorBody.config.url}</p>
                             <div className="button" onClick={routeChange}>Try Again</div>
                         </div>
               </div>
    );
  }
  export default LoginLayout;