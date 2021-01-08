import React from "react";
import './adminManageAccount.css';
import springlogo from './springlogo.png'
import axios from 'axios';

export default function AdminManageAccount() {
  
  //Variables to store form input data
  const [usernameV, setUsername] = React.useState("");
  const [passwordV, setPassword] = React.useState("");
  const [roleV, setRole] = React.useState("");
  const [activeV, setActive] = React.useState("");
  const [idV, setId] = React.useState("");
  
  const [output, setOutput] = React.useState("");

  //Arrow functions to handle content change
  const usernameContentChange = event => setUsername(event.target.value);
  const passwordContentChange = event => setPassword(event.target.value);
  const roleContentChange = event => setRole(event.target.value);
  const activeContentChange = event => setActive(event.target.value);
  const idContentChange = event => setId(event.target.value);
  

  //Arrow function to handle submit button press
  const handleSubmit = event => {
    event.preventDefault();
    setOutput("Register button pressed.")
	
	
    axios({
      method: 'post',
      url: '/createUser',
	  data: {
		  userName: usernameV,password: passwordV,roles: roleV,active: activeV
	  }
    })
	.then((response) => {
		console.log(response);
		setOutput("Sucess");
	}, (error) => {
		console.log(error);
		setOutput("Fail");
	});
	
  };

  //Arrow function to handle delete button press
  const handleDelete = event => {
    event.preventDefault();
    setOutput("Delete button pressed.")
	
	
    axios({
      method: 'delete',
      url: '/deleteId/'+idV,
	  
	  
    })
	.then((response) => {
		console.log(response);
		setOutput("Sucess");
	}, (error) => {
		console.log(error);
		setOutput("Fail");
	});
	
  }


  return (
    <div>
      <div className="container">
        <div className="box">
          <img src={springlogo} alt="Equality icon" className="icon" />
        </div>
		  
		  
			<form>
				<h1>Registration form</h1>
				<p>Username:</p>
				<textarea id="username" name="username"
				onChange={usernameContentChange} />
				
				<p>Password:</p>
				<textarea id="password" name="password"
				onChange={passwordContentChange} />
				
				<p>Role:</p>
				<textarea id="role" name="role"
				placeholder="Example: 'ROLE_ADMIN'"
				onChange={roleContentChange}/>
				
				<p>Active:</p>
				<textarea id="active" name="active" 
				placeholder="Example: 'true'"
				onChange={activeContentChange}/>
			</form>
			
		    <form>
				<button onClick={handleSubmit}>
				Register
				</button>
			</form>
			
			
			<form>
				
				<h1>Delete User</h1>
				<p>ID:</p>
				<textarea id="id" name="id"
				onChange={idContentChange} />
			</form>
			
			<form>
				<button  onClick={handleDelete}>
				Delete
				</button>
			</form>
			
	  
        
        <div className="box">
          <p>{output}</p>
        </div>
      </div>
    </div>
  );
}
