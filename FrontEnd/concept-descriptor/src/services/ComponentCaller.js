



class ComponentCaller {
    callApi(jsonData, moduleURL) {
        try{
           const axios = require('axios');
            var config = {
                method: 'post',
                url: moduleURL,
                headers: {
                    'Content-Type': 'application/json'
                },
                data: jsonData
            };
            return axios(config);
        }
        catch (err)
        {
            console.error(err);
        }
    
    }

}



export default new ComponentCaller();
