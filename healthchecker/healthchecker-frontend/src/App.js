import React, { Component } from "react";
import {Link, Switch, Route, BrowserRouter as Router } from "react-router-dom";
import AdminManageAccount from "./Components/AdminManageAccount";
import UserLogin from "./Components/UserLogin";
import './App.css';
import springlogo from './Components/springlogo.png'

class App extends Component {
  render() {
    return (
      <Router>
	  
        <div>
          <h1 className="App-header">Healthchecker Application</h1>
          <nav className="topnav">
              <Link to={'/'} className="App-link">|| Homepage ||</Link>
			  <Link to={'/userLogin'} className="App-link">|| User Login ||</Link>
			  <Link to={'/adminManageAccounts'} className="App-link">Manage Accounts ||</Link>
          </nav>
          <Switch>
              <Route exact path='/'/>
			  <Route exact path='/adminManageAccounts' component={AdminManageAccount} />
              <Route exact path='/userLogin' component={UserLogin} />
          </Switch>
        </div>
      </Router>
    );
  }
}

export default App;

