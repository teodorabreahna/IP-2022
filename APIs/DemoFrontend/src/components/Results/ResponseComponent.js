import React from 'react';
import CrawlerService from '../../services/CrawlerService';
// import DataProcessingService from '../../services/DataProcessingService'
// import StatisticsService from '../../services/StatisticsService';
import ResultObject from './ResultObject';
import ComponentCaller from '../../services/ComponentCaller'

const CRAWLER_REST_API_URL = 'https://crawler2-ip.herokuapp.com/crawler';
const DATA_PROCESSING_REST_API_URL = 'https://dataprocessing-ip.herokuapp.com/dataprocessing';
const STATISTICS_REST_API_URL = 'https://stats-ip.herokuapp.com/stats';

class ResponseComponent extends React.Component {
    

    constructor(props) {
        super(props);
        this.state = {
            jsonData: ""
        }
    }

   async componentDidMount() {

        var intermediateData={"data" : "un stirng nu conteaza ce"};

        //-------------------------        CRAWLER CALL     --------------------------------------
        intermediateData = await CrawlerService.callApi(this.props.firstConcept, this.props.secondConcept, CRAWLER_REST_API_URL);
        console.log("crawler response:", intermediateData.data);
        //-------------------------         END CRAWLER CALL        -------------------------------

        this.setState({jsonData: JSON.stringify(intermediateData.data)})

        //-------------------------         DATA PROCESSING CALL    --------------------------------
        intermediateData = await ComponentCaller.callApi(intermediateData.data, DATA_PROCESSING_REST_API_URL);
        console.log("data processing response:", intermediateData.data );
        //-------------------------     END  DATA PROCESSING CALL    --------------------------------

        //-------------------------         STATISTICS CALL    --------------------------------
        intermediateData = await ComponentCaller.callApi(intermediateData.data, STATISTICS_REST_API_URL);
        console.log("statistics response:", intermediateData.data);
        //-------------------------     END STATISTICS CALL    --------------------------------


        this.resultObject = new ResultObject(intermediateData.data);
        console.log("FINAL RESPONSE", this.resultObject);

        this.setState({jsonData: JSON.stringify(intermediateData.data)})
    }

    render() {
    
        return (
            <h2>The HTTP response: {this.state.jsonData}</h2>   // Aici o sa vina cam tot front-u BACIU
        )
        
    }

    
}

export default ResponseComponent;