import axios from 'axios';


class ModuleService {
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

export default new ModuleService();
