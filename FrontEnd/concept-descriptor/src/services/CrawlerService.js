import axios from 'axios';



class CrawlerService {
    callApi(conceptOne, conceptTwo, moduleURL) {
        var axios = require('axios');
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

}

export default new CrawlerService();
