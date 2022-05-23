import React from 'react';
import CrawlerService from '../../services/CrawlerService';
// import DataProcessingService from '../../services/DataProcessingService'
// import StatisticsService from '../../services/StatisticsService';
import ResultObject from './ResultObject';
import ComponentCaller from '../../services/ComponentCaller'
import ErrorModal from '../ErrorModal';
import LoadingScreen from '../LoadingScreen';

const CRAWLER_REST_API_URL = 'https://crawler-ip.herokuapp.com/crawler';
//const DATA_PROCESSING_REST_API_URL = "https://dataprocessing-ip.herokuapp.com/dataprocessing"
const STATISTICS_REST_API_URL = 'https://stats-ip.herokuapp.com/stats';

class ResponseComponent extends React.Component {


    constructor(props) {
        super(props);
        this.state = {
            jsonData: null,
            hasError: false,
            isLoaded: false,
            loadingStatusTexts: [],
        }
    }

    async componentDidMount() {

        var intermediateData;
        var loadingStatusTexts = [];
console.log("concept1",this.props.firstConcept);


        //-------------------------        CRAWLER CALL     --------------------------------------
        console.log("object:", ({ concept1 : this.props.firstConcept, concept2: this.props.secondConcept }));
        try {
            intermediateData = await ComponentCaller.callApi({ concept1: this.props.firstConcept, concept2: this.props.secondConcept }, CRAWLER_REST_API_URL);
            console.log("crawler response:", intermediateData.data);
            console.log("data header", intermediateData );
            loadingStatusTexts.push("Crawler responded successfully.");
         
            this.setState({loadingStatusTexts: loadingStatusTexts});

            // // //-------------------------         DATA PROCESSING CALL    --------------------------------
            //  intermediateData = await ComponentCaller.callApi(intermediateData.data, DATA_PROCESSING_REST_API_URL);
            // console.log("data processing response:", intermediateData.data);
            // loadingStatusTexts.push("Data processing responded successfully.");
            // this.setState({loadingStatusTexts: loadingStatusTexts});
            // //-------------------------     END  DATA PROCESSING CALL    --------------------------------

            // //-------------------------         STATISTICS CALL    --------------------------------
            console.log("calling stats");
            intermediateData = await ComponentCaller.callApi(intermediateData.data, STATISTICS_REST_API_URL);
            console.log("statistics response:", intermediateData.data);
            loadingStatusTexts.push("Statistics responded successfully.");
            this.setState({loadingStatus: loadingStatusTexts});
            // //-------------------------     END STATISTICS CALL    --------------------------------

            this.resultObject = new ResultObject(intermediateData.data);
           
            this.setState({ jsonData: JSON.stringify(intermediateData.data),isLoaded:true,hasError:false });
        }
        catch (err) {
            this.setState({ jsonData: JSON.stringify(err), hasError: true,isLoaded:true});
            return;
        }
        //-------------------------         END CRAWLER CALL        -------------------------------
       
    }

    render() {
        this.state.jsonData !== null ?

        this.resultObject = JSON.parse(this.state.jsonData):

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
    
                "chartPie": "chart?c={type: 'pie', data:{labels: ['mere', 'pere'], datasets: [{ data:[3,3]}]}}",
                "chartBar": "chart?c={type: 'bar', data: {labels: ['Nouns', 'Adjectives', 'Verbs'], datasets:[{label: 'mere', data:[2,0,1]},{label:'pere', data:[2,0,1]}]}}"
    
                }
        );
       
       
        if(this.state.isLoaded === false)
            return <LoadingScreen loadingStatusTexts = {this.state.loadingStatusTexts}/>
        
        

        if (this.state.hasError)
            return <ErrorModal jsonData = {this.state.jsonData} />
        else
            return (<div>
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
                            {this.resultObject.def1}
                        </div>
                        <div className='text-info'>
                             <h2>First concept chart:</h2>
                         </div>
                        
                        <img className='chart' src = {`https://quickchart.io/${this.resultObject.chart1}`} alt = "Chart Missing"/>
                        

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
                            {this.resultObject.def2}
                        </div>

                        <div className='text-info'>
                             <h2>Second concept chart:</h2>
                         </div>

                       
                        <img className='chart' src = {`https://quickchart.io/${this.resultObject.chart2}`} alt = "Chart Missing"/>
                        
                    </div>
                </div>
                <div className='text-info'>
                    <h2>Intersected:</h2>
                </div>
                <div className='common'>
                    {this.resultObject.intersect.map(info => <div key = {info}> {info} </div>)}
                </div>

                <div className='text-info'>
                    <h2>Diferit1:</h2>
                </div>
                <div className='common'>
                {this.resultObject.diferit1.map(info => <div key = {info}> {info} </div>)}
                </div>

                <div className='text-info'>
                    <h2>Diferit2:</h2>
                </div>
                <div className='common'>
                {this.resultObject.diferit2.map(info => <div key = {info}> {info} </div>)}
                </div>

                <div className='text-info'>
                    <h2>ChartPie:</h2>
                </div>
                
                <img className='chart2' src = {`https://quickchart.io/${this.resultObject.chartPie}`} alt = "Chart Missing"/>
                

                <div className='text-info'>
                    <h2>ChartBar:</h2>
                </div>
                
                <img className='chart2' src = {`https://quickchart.io/${this.resultObject.chartBar}`} alt = "Chart Missing"/>
               
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