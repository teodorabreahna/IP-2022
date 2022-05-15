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

        this.resultObject = new ResultObject(
            {
                "concep1": {
                  "concept": "cuvant",
                  "def": "definitia cuvantului",
                  "chart": "chart?bkg=white&c={ type: 'bar', data: { labels: ['Q1', 'Q2', 'Q3', 'Q4'], datasets: [{ label: 'Users', data: [50, 60, 70, 180] }] }}"
                },
                "concep2": {
                  "concept": "cuvant",
                  "def": "definitia cuvantului",
                  "chart":"chart?bkg=white&c={ type: 'bar', data: { labels: ['Q1', 'Q2', 'Q3', 'Q4'], datasets: [{ label: 'Revenue', data: [100, 200, 300, 400] }] }}"
                },
                "intersect": [
                  "cuvant1",
                  "cuvant2",
                  "cuvant3",
                  "cuvant4"
                ],
                "differentc1": [
                  "cuvant1",
                  "cuvant2",
                  "cuvant3",
                  "cuvant4"
                ],
                "differentc2": [
                  "cuvant1",
                  "cuvant2",
                  "cuvant3",
                  "cuvant4"
                ]
              }
        );
        // asa faci call: resultObject.concep1.def
    
        return (
            <div>
            <div className='Body-div'>
                <div className='different'>
                    <div className='left-div'>

                        <div className='text-info'>
                            <h2>First concept:</h2>
                        </div>

                        <div className='Concept'>
                            {this.props.secondConcept};
                        </div>
                        <div className='text-info'>
                             <h2>First concept definition:</h2>
                         </div>
                        <div className='info'>
                            {this.resultObject.concep1.def}
                        </div>
                        <div className='text-info'>
                             <h2>First concept chart:</h2>
                         </div>
                        <div className='chart'>
                            {this.resultObject.concep1.chart}
                        </div>

                    </div>

                    <div className='right-div'>
                        <div className='text-info'>
                            <h2>Second concept:</h2>
                        </div>
                        <div className='Concept'>
                            {this.resultObject.concep2.concept}
                        </div>
                        <div className='text-info'>
                             <h2>Second concept definition:</h2>
                         </div>
                        <div className='info'>
                            {this.resultObject.concep2.def}
                        </div>

                        <div className='text-info'>
                             <h2>Second concept chart:</h2>
                         </div>

                        <div className='chart'>
                            {this.resultObject.concep2.chart}
                        </div>
                    </div>
                </div>
                <div className='text-info'>
                    <h2>First common chart:</h2>
                </div>
                <div className='common'>
                    {this.resultObject.intersect}
                </div>

                <div className='text-info'>
                    <h2>Second common chart:</h2>
                </div>
                <div className='common'>
                    {this.resultObject.intersect}
                </div>

                <br />
                <br />
            </div> 

            <footer className='footer'>
            </footer>
        </div>      
        )
        
    }

    
}

export default ResponseComponent;