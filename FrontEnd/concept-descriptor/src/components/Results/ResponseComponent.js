import React from 'react';
import CrawlerService from '../../services/CrawlerService';

class ResponseComponent extends React.Component{

    constructor(props)
    {
        super(props);
        this.state={
            jsonData:[]
        }
    }

    componentDidMount()
    {
        CrawlerService.callApi(this.props.firstConcept,this.props.secondConcept).then((response) =>
        {
            this.setState({jsonData: response.data});
        })

        // Aici o sa fie apelate toate componentele, iar ultimul rand va fi un setState. In jsonData va fi tot ce primim de la statistici
        
    }

    render()
    {
        return (
          <h2>The HTTP response: {this.state.jsonData}</h2>   // Aici o sa vina cam tot front-u, cu datele puse asa unde e nevoie
        )
    }
}

export default ResponseComponent;