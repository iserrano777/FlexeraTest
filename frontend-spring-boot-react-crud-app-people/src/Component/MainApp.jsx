import React, { Component } from 'react';
import ListPeopleComponent from './ListPeopleComponent';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import PeopleComponent from './PeopleComponent';

class MainApp extends Component {
    render() {
        return (
            <Router>
                <>
                    <h1>People Application</h1>
                    <Switch>
                        <Route path="/" exact component={ListPeopleComponent} />
                        <Route path="/people" exact component={ListPeopleComponent} />
                        <Route path="/people/:id" component={PeopleComponent} />
                    </Switch>
                </>
            </Router>
        )
    }
}

export default MainApp