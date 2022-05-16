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
            "concept1": "mere",
            "def1": [
             "A body of standing water, such as a lake or a pond. More specifically, it can refer to a lake that is broad in relation to its depth. Also included in place names such as Windermere."
            ],

            "chart1": "chart?bkg-white&c={ type: 'bar', data: { labels: ['ana', 'mere', 'are', 'mere'], datasets: [{ label: 'Users', data: [1, 1, 1, 1, 1] }] }}",
            "concept2": "pere",
            "def2": [
            "A priest of the Roman Catholic Church, especially a French one. Also used as a title preceding the name of such a priest.",
            "Sr. - Used after a proper name that is common to a father and his son to indicate that the father is being referred to rather than the son (junior, fils)."
            ],

            "chart2": "chart?c={ type: 'bar', data: { labels: ['ana', 'pere', 'are', 'ana', 'pere'], datasets: [{ label: 'Users', data: [1, 1, 1, 1, 1] }] }}",
            "intersect" : [
            "ana",
            "are"
            ],

            "diferit1": [
            "mere"
            ],

            "diferit2":[
            "pere"
            ],

            "chartPie": "chart?c={type: 'pie', data: {labels: ['mere', 'pere'], datasets: [{ data:[3,3]}]}}",
            "chartBar": "chart?c={type: 'bar', data: {labels: ['Nouns', 'Adjectives', 'Verbs'], datasets:[{label: 'mere', data:[2,0,1]},{label:'pere', data:[2,0,1]}]}}"

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
                            {this.resultObject.def1};
                        </div>
                        <div className='text-info'>
                             <h2>First concept chart:</h2>
                         </div>
                        <div className='chart'>
                            <img src = {`https://quickchart.io/${this.resultObject.chart1}`} alt = "Chart Missing"/>
                        </div>

                    </div>

                    <div className='right-div'>
                        <div className='text-info'>
                            <h2>Second concept:</h2>
                        </div>
                        <div className='Concept'>
                            {this.resultObject.concept2}
                        </div>
                        <div className='text-info'>
                             <h2>Second concept definition:</h2>
                         </div>
                        <div className='info'>
                            {this.resultObject.def2}
                        </div>

                        <div className='text-info'>
                             <h2>Second concept chart:</h2>
                         </div>

                        <div className='chart'>
                            <img src = {`https://quickchart.io/${this.resultObject.chart2}`} alt = "Chart Missing"/>
                        </div>
                    </div>
                </div>
                <div className='text-info'>
                    <h2>Intersected:</h2>
                </div>
                <div className='common'>
                    {this.resultObject.intersect}
                </div>

                <div className='text-info'>
                    <h2>Diferit1:</h2>
                </div>
                <div className='common'>
                    {this.resultObject.diferit1}
                </div>

                <div className='text-info'>
                    <h2>Diferit2:</h2>
                </div>
                <div className='common'>
                    {this.resultObject.diferit2}
                </div>

                <div className='text-info'>
                    <h2>ChartPie:</h2>
                </div>
                <div className='common'>
                    <img src = {`https://quickchart.io/${this.resultObject.chartPie}`} alt = "Chart Missing"/>
                </div>

                <div className='text-info'>
                    <h2>ChartBar:</h2>
                </div>
                <div className='common'>
                    <img src = {`https://quickchart.io/${this.resultObject.chartBar}`} alt = "Chart Missing"/>
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