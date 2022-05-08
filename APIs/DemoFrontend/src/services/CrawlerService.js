



class CrawlerService {
    callApi(conceptOne, conceptTwo, moduleURL) {
        try{
           const axios = require('axios');
            var data = { "concept1": conceptOne, "concept2": conceptTwo, };

            var config = {
                method: 'post',
                url: moduleURL,
                headers: {
                    'Content-Type': 'application/json'
                },
                data: data
            };
            return axios(config);
        }
        catch (err)
        {
            console.error(err);
        }
    
    }

}



export default new CrawlerService();
