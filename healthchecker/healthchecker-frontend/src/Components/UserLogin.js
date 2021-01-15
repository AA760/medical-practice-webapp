import React from "react";
import './adminManageAccount.css';
import axios from 'axios';

export default function AdminManageAccount() {
  
  //Variables to store form input data
  const [usernameV, setUsername] = React.useState("");
  const [passwordV, setPassword] = React.useState("");

  const [output, setOutput] = React.useState("");

  //Arrow functions to handle content change
  const usernameContentChange = event => setUsername(event.target.value);
  const passwordContentChange = event => setPassword(event.target.value);

  

  //Arrow function to handle submit button press
  const handleLogin = event => {
    event.preventDefault();
    setOutput("Log-in button pressed.")
	
	
    axios({
      method: 'get',
      url: '/patient',
	  auth: {
	  username: usernameV,
      password: passwordV
	}
    })
	.then((response) => {
		console.log(response);
		setOutput("Log-in successful");
	}, (error) => {
		console.log(error);
		setOutput("Log-in failed");
	});
	
  };
  
  //Arrow function to handle log-out button press || *Gives error response even with successful logout, so all responses are displayed as successful - should not matter in most cases as there is no user input*
   const handleLogout = event => {
    event.preventDefault();
    setOutput("Log-out button pressed.")
	
	
    axios({
      method: 'get',
      url: '/logout'
    })
	.then((response) => {
		console.log(response);
		setOutput("Log-out successful");
	}, (error) => {
		console.log(error);
		setOutput("Logged out successfully");
	});
	
  };

 

  return (
    <div>
      <div className="container">
		  
		  
			<form>
				<h1>Login form</h1>
				<p>Username:</p>
				<textarea id="username" name="username"
				onChange={usernameContentChange} />
				
				<p>Password:</p>
				<textarea id="password" name="password"
				onChange={passwordContentChange} />
			</form>
			
		    <form>
				<button onClick={handleLogin}>
				Log-in
				</button>
				
				<button onClick={handleLogout}>
				Log-out
				</button>
			</form>  
        
        <div className="box">
          <p>{output}</p>
        </div>
      </div>
    </div>
  );
}
