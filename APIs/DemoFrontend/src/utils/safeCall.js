import React from 'react';


async function safeCall(callApi,data,URL)
{
        let response = await callApi(data,URL).catch(err => {
            console.log(err);
        });
        return response;
    
}

export default safeCall();