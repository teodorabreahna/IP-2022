
class ComponentCaller {
    static callApi(JSONData, serviceUrl) //as a real JSON, not a string
    {

        var config = {
            method: 'post',
            url: serviceUrl,
            headers: {
                'Content-Type': 'application/json'
            },
            data: JSONData
        };

        return axios(config);
    }
}