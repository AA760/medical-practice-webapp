import React, { Component } from "react";
import { Link, Switch, Route, BrowserRouter as Router } from "react-router-dom";
import Register from "./Components/register/PatientRegister1";
import Login from "./Components/UserLogin";
import ViewJob from "./Components/viewPreviousAppointments/ViewPatientPreviousAppointments";
import UploadVideosAndArticles from "./Components/uploadVideosAndArticles/UploadVideosAndArticles";
import SortVideosAndArticles from "./Components/SortVideosAndArticlesByTime/SortVideosAndArticlesByTime";
import './App.css';

class App extends Component {
	render() {
		return (
			<Router>
				<div>
					<h1 className="header">Health Checker application</h1>
					<nav className="topnav">
						<Link to={'/'} className="nav-link">Patient Register</Link>
						<Link to={'/register'} className="nav-link">Patient Register</Link>
						<Link to={'/view'} className="nav-link">View Previous Appointments</Link>
						<Link to={'/uploadVideosAndArticles'} className="nav-link">Upload Videos And Articles</Link>
						<Link to={'/sortVideosAndArticles'} className="nav-link">Sort Videos And Articles</Link>
					</nav>
					<Switch>
						<Route exact path='/' component={Login} />
						<Route exact path='/register' component={Register} />
						<Route path='/view' component={ViewJob} />
						<Route path='/uploadVideosAndArticles' component={UploadVideosAndArticles} />
						<Route path='/sortVideosAndArticles' component={SortVideosAndArticles} />
					</Switch>
				</div>
			</Router>
		);
	}
}

export default App;

