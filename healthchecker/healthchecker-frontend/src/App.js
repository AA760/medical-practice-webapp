import React, { Component } from "react";
import {Link, Switch, Route, BrowserRouter as Router } from "react-router-dom";
import AdminManageAccount from "./Components/AdminManageAccount";
import './App.css';

class App extends Component {
  render() {
    return (
      <Router>
        <div>
          <h1 className="App-header">Healthchecker Application</h1>
          <nav className="topnav">
              <Link to={'/adminManageAccount'} className="App-link">Manage Accounts</Link>
          </nav>
          <Switch>
              <Route exact path='/adminManageAccount' component={AdminManageAccount} />
          </Switch>
        </div>
      </Router>
    );
  }
}

export default App;

