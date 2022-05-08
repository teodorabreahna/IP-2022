import axios from 'axios';

//E FOLOSIT PENTRU DATA PROCESSING SI STATISTICS<,

class DataProcessingService {
    callApi(jsonData, moduleURL) {


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

}

export default new DataProcessingService();
