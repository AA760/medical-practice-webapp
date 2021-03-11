import React, { Component } from "react";
import { Link, Switch, Route, BrowserRouter as Router } from "react-router-dom";
import Register from "./Components/PatientRegister1";
import DoctorRegister from "./Components/DoctorRegister";
import Login from "./Components/UserLogin";
import ViewJob from "./Components/ViewPatientPreviousAppointments";
import UploadVideosAndArticles from "./Components/UploadVideosAndArticles";
import SortVideosAndArticles from "./Components/SortVideosAndArticlesByTime";
import AdminManageAccount from "./Components/AdminManageAccount";
import './App.css';

class App extends Component {
	render() {
		return (
			<Router>
				<div>
					<h1 className="header">Health Checker application</h1>
					<nav className="topnav">
						<Link to={'/'} className="nav-link">Login Page</Link>
						<Link to={'/register'} className="nav-link">Patient Register</Link>
						<Link to={'/DoctorRegister'} className="nav-link">Doctor Register</Link>
						<Link to={'/view'} className="nav-link">View Previous Appointments</Link>
						<Link to={'/uploadVideosAndArticles'} className="nav-link">Upload Videos And Articles</Link>
						<Link to={'/sortVideosAndArticles'} className="nav-link">Sort Videos And Articles</Link>
						<Link to={'/adminManageAccounts'} className="nav-link">Admin - Manage Accounts</Link>
					</nav>
					<Switch>
						<Route exact path='/' component={Login} />
						<Route exact path='/register' component={Register} />
						<Route path='/DoctorRegister' component={DoctorRegister} />
						<Route path='/view' component={ViewJob} />
						<Route path='/uploadVideosAndArticles' component={UploadVideosAndArticles} />
						<Route path='/sortVideosAndArticles' component={SortVideosAndArticles} />
						<Route path='/adminManageAccounts' component={AdminManageAccount} />
					</Switch>
				</div>
			</Router>
		);
	}
}

export default App;

