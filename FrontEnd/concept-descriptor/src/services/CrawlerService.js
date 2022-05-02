import axios from 'axios';

const CRAWLER_REST_API_URL = 'http://localhost:8090/crawl';

class CrawlerService{
    callApi(concept1,concept2)
    {
        return axios.get(CRAWLER_REST_API_URL, {params: {concept: concept1, concept2: concept2}});
    }

}

export default new CrawlerService();
