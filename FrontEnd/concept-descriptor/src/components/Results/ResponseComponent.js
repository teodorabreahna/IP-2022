import React from 'react';
import CrawlerService from '../../services/CrawlerService';
// import DataProcessingService from '../../services/DataProcessingService'
// import StatisticsService from '../../services/StatisticsService';
import ResultObject from './ResultObject';
import ComponentCaller from '../../services/ComponentCaller'

const CRAWLER_REST_API_URL = 'http://localhost:8090/crawl';
const DATA_PROCESSING_REST_API_URL = 'http://localhost:8090/crawl';
const STATISTICS_REST_API_URL = 'http://localhost:8090/crawl';

class ResponseComponent extends React.Component {
    

    constructor(props) {
        super(props);
        this.state = {
            jsonData: ""
        }
    }

   async componentDidMount() {

        var intermediateData;

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
            <body>
            <div className='Body-div'>
                <div className='different'>
                    <div className='left-div'>

                        <div className='text-info'>
                            <h2>First concept:</h2>
                        </div>

                        <div className='Concept'>
                            {this.props.firstConcept}
                        </div>
                        <div className='text-info'>
                             <h2>First concept definition:</h2>
                         </div>
                        <div className='info'>
                            <h4>
                                blah blah blah blah blah
                                blah blah blah blah blah
                                blah blah blah blah blah
                                blah blah blah blah blah
                                blah blah blah blah blah
                            </h4>
                        </div>
                        <div className='text-info'>
                             <h2>First concept chart:</h2>
                         </div>
                        <div className='chart'>
                            <h6>
                                ceva tabela/chart sau cum vrei sa ii spui
                                blah blah blah blah blah
                                blah blah blah blah blah
                                blah blah blah blah blah
                                blah blah blah blah blah
                                blah blah blah blah blah
                            </h6>
                        </div>
                    </div>

                    <div className='right-div'>
                        <div className='text-info'>
                            <h2>Second concept:</h2>
                        </div>
                        <div className='Concept'>
                            {this.props.secondConcept}
                        </div>
                        <div className='text-info'>
                             <h2>Second concept definition:</h2>
                         </div>
                        <div className='info'>
                            <h4>
                                blah blah blah blah blah
                                blah blah blah blah blah
                                blah blah blah blah blah
                                blah blah blah blah blah
                                blah blah blah blah blah
                            </h4>
                        </div>

                        <div className='text-info'>
                             <h2>Second concept chart:</h2>
                         </div>

                        <div className='chart'>
                            <h6>
                                ceva tabela/chart sau cum vrei sa ii spui
                                blah blah blah blah blah
                                blah blah blah blah blah
                                blah blah blah blah blah
                                blah blah blah blah blah
                                blah blah blah blah blah
                            </h6>
                        </div>
                    </div>
                </div>
                <div className='text-info'>
                    <h2>Common chart:</h2>
                </div>
                <div className='common'>
                    <h6>
                        TABELA COMUNA DINTRE CELE 2 CONCEPTE;
                        blah blah blah blah blah
                        blah blah blah blah blah
                        blah blah blah blah blah
                        blah blah blah blah blah
                        blah blah blah blah blah
                        blah blah blah blah blah
                        blah blah blah blah blah
                        blah blah blah blah blah
                        blah blah blah blah blah
                    </h6>
                </div>
                <br />
                <br />
            </div> 
            <footer className='footer'>

            </footer>
        </body>      
        )
        
    }

    
}

export default ResponseComponent;