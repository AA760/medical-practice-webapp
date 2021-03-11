import React from "react";
import './adminManageAccount.css';
import axios from 'axios';

export default function AdminManageAccount() {
  
  //Variables to store form input data
  const [usernameV, setUsername] = React.useState("");
  const [passwordV, setPassword] = React.useState("");
  const [roleV, setRole] = React.useState("");
  const [activeV, setActive] = React.useState("");
  const [idV, setId] = React.useState("");
  
  const [id2V, setId2] = React.useState("");
  const [password2V, setPassword2] = React.useState("");
  
  const [outputSubmit, setOutputSubmit] = React.useState("");
  const [outputDelete, setOutputDelete] = React.useState("");
  const [outputPassword, setOutputPassword] = React.useState("");

  //Arrow functions to handle content change
  const usernameContentChange = event => setUsername(event.target.value);
  const passwordContentChange = event => setPassword(event.target.value);
  const roleContentChange = event => setRole(event.target.value);
  const activeContentChange = event => setActive(event.target.value);
  const idContentChange = event => setId(event.target.value);
  
  const id2ContentChange = event => setId2(event.target.value);
  const password2ContentChange = event => setPassword2(event.target.value);
  

  //Arrow function to handle submit button press
  const handleSubmit = event => {
    event.preventDefault();
    setOutputSubmit("Register button pressed.")
	
	
    axios({
      method: 'post',
      url: '/createUser',
	  data: {
		  userName: usernameV,password: passwordV,roles: roleV,active: activeV
	  }
    })
	.then((response) => {
		console.log(response);
		setOutputSubmit("Success");
	}, (error) => {
		console.log(error);
		setOutputSubmit("Fail");
	});
	
  };

  //Arrow function to handle delete button press
  const handleDelete = event => {
    event.preventDefault();
    setOutputDelete("Delete button pressed.")
	
	
    axios({
      method: 'delete',
      url: '/deleteId/'+idV,
	  
	  
    })
	.then((response) => {
		console.log(response);
		setOutputDelete("Success");
	}, (error) => {
		console.log(error);
		setOutputDelete("Fail");
	});
	
  }
  
  //Arrow function to handle update button press
  const handleUpdate = event => {
    event.preventDefault();
    setOutputPassword("Update button pressed.")
	
	
    axios({
      method: 'put',
      url: '/changePassword',
	  data: {
		  id: id2V,password: password2V
	  }
    })
	.then((response) => {
		console.log(response);
		setOutputPassword("Success");
	}, (error) => {
		console.log(error);
		setOutputPassword("Fail");
	});
	
  };


  return (
    <div>
      <div className="container">
		  
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
			
			<div className="box">
			<p>{outputSubmit}</p>
			</div>
			
			
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
				<p>{outputDelete}</p>
				</div>
			
			<form>
				
				<h1>Change Password</h1>
				<p>ID:</p>
				<textarea id="id2" name="id2"
				onChange={id2ContentChange} />
				
				<p>New Password:</p>
				<textarea id="password2" name="password2"
				onChange={password2ContentChange} />
			</form>
			
			<form>
				<button  onClick={handleUpdate}>
				Update
				</button>
			</form>
			
			<div className="box">
			<p>{outputPassword}</p>
			</div>
			
	 
      </div>
    </div>
  );
}
