import React from 'react';
import CrawlerService from '../../services/CrawlerService';
// import DataProcessingService from '../../services/DataProcessingService'
// import StatisticsService from '../../services/StatisticsService';

const CRAWLER_REST_API_URL = 'http://localhost:8090/crawl';
//const DATAPROCESSING_REST_API_URL = '';
//const STATISTICS_REST_API_URL = '';

class ResponseComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            jsonData: ""
        }
    }

    componentDidMount() {

        var intermediateData;
        //fiecare serviciu un callback la celalalt momentan
        CrawlerService.callApi(this.props.firstConcept, this.props.secondConcept, CRAWLER_REST_API_URL)
            .then((crawlerResponse) => {
                console.log("CRAWLER RESPONSE", crawlerResponse.data);
                intermediateData = crawlerResponse.data;
            })
            // .then(
            //     DataProcessingService.callApi(intermediateData,DATAPROCESSING_REST_API_URL) etc
            // )
            .then(() => { this.setState({ jsonData: JSON.stringify(intermediateData) }); });



        // Aici o sa fie apelate toate componentele, iar ultimul rand va fi un setState. In jsonData va fi tot ce primim de la statistici

    }

    render() {
        return (
            <h2>The HTTP response: {this.state.jsonData}</h2>   // Aici o sa vina cam tot front-u BACIU
        )
    }

    async callAllModules() {
        //this.props.firstConcept = concept1, this.props.secondConcept = concept2



    }
}

export default ResponseComponent;