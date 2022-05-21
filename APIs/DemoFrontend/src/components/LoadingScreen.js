import React from "react";
function LoadingScreen(props) {
    
    return (
        <div className="lds-roller-wrapper">
           <div className="lds-ring"><div></div><div></div><div></div><div></div></div>
           {
               props.loadingStatusTexts.map(info => <div key={info}>{info}</div>)
           }
        </div>
    );
}
export default LoadingScreen;