import React from "react";
import './DoctorRegister.css';
import axios from 'axios';

export default function DoctorRegister() {
  
  //Variables to store form input data
  const [firstName, setFirstName] = React.useState("");
  const [lastName, setLastName] = React.useState("");
  const [doctorNumber, setDoctorNumber] = React.useState("");
  const [email, setEmail] = React.useState("");
  const [dob, setDob] = React.useState("");
  //const [address, setAddress] = React.useState("");
  const [line1, setLine1] = React.useState("");
  const [line2, setLine2] = React.useState("");
  const [postcode, setPostcode] = React.useState("");
  const [city, setCity] = React.useState("");
  const [country, setCountry] = React.useState("");
  const [phone, setPhone] = React.useState("");
  
//  const [USERID, setUSERID] = React.useState(0);
//  const [ADDRESSID, setADDRESSID] = React.useState(0);
  
  const [usernameV, setUsername] = React.useState("");
  const [passwordV, setPassword] = React.useState("");
  const [roleV, setRole] = React.useState("");
  const [activeV, setActive] = React.useState("");
//  const [idV, setId] = React.useState("");
  
//  const [id2V, setId2] = React.useState("");
//  const [password2V, setPassword2] = React.useState("");
  
  const [outputSubmit, setOutputSubmit] = React.useState("");
//  const [outputDelete, setOutputDelete] = React.useState("");
// const [outputPassword, setOutputPassword] = React.useState("");

  //Arrow functions to handle content change
  const firstNameContentChange = event => setFirstName(event.target.value);
  const lastNameContentChange = event => setLastName(event.target.value);
  const doctorNumberContentChange = event => setDoctorNumber(event.target.value);
  const emailContentChange = event => setEmail(event.target.value);
  const dobContentChange = event => setDob(event.target.value);
  
  const line1ContentChange = event => setLine1(event.target.value);
  const line2ContentChange = event => setLine2(event.target.value);
  const postcodeContentChange = event => setPostcode(event.target.value);
  const cityContentChange = event => setCity(event.target.value);
  const countryContentChange = event => setCountry(event.target.value);
  const phoneContentChange = event => setPhone(event.target.value);

  const usernameContentChange = event => setUsername(event.target.value);
  const passwordContentChange = event => setPassword(event.target.value);
  const roleContentChange = event => setRole(event.target.value);
  const activeContentChange = event => setActive(event.target.value);
//  const idContentChange = event => setId(event.target.value);
  
//  const id2ContentChange = event => setId2(event.target.value);
//  const password2ContentChange = event => setPassword2(event.target.value);


  //Arrow function to handle submit button press
  const handleSubmit = event => {
    event.preventDefault();
    setOutputSubmit("Register button pressed.")
	
	
    axios({
      method: 'post',
      url: '/doctor',
	  data: {
		  firstName: firstName, 
		  lastName: lastName, 
		  doctorNumber: doctorNumber,
		  email: email, 
		  dob: dob,
		  line1: line1,
		  line2: line2,
		  postcode: postcode,
		  city: city,
		  country: country, 
		  phone: phone,
		  userName: usernameV,
		  password: passwordV,
		  roles: roleV,
		  active: activeV
	  }
    })
	.then((response) => {
		console.log(response);
		setOutputSubmit("Success");
	}, (error) => {
		console.log(error);
		setOutputSubmit("Success");
	});
	
  };



  return (
    <div>
      <div className="container">
		  
			<form>
				<h1>Registration form</h1>
				<p>First Name:</p>
				<textarea id="firstName" name="firstName" 
				onChange={firstNameContentChange}/>
				
				<p>Last Name:</p>
				<textarea id="lastName" name="lastName" 
				onChange={lastNameContentChange}/>
				
				<p>Doctor Number:</p>
				<textarea id="doctorNumber" name="doctorNumber" 
				onChange={doctorNumberContentChange}/>
				
				<p>Email Address:</p>
				<textarea id="email" name="email" 
				onChange={emailContentChange}/>
				
				<p>Date of Birth:</p>
				<textarea id="dob" name="dob" 
				onChange={dobContentChange}/>
				
				<p>Address Line 1:</p>
				<textarea id="line1" name="line1" 
				onChange={line1ContentChange}/>
				
				<p>Address Line 2:</p>
				<textarea id="line2" name="line2" 
				onChange={line2ContentChange}/>
				
				<p>Postcode:</p>
				<textarea id="postcode" name="postcode" 
				onChange={postcodeContentChange}/>
				
				<p>City:</p>
				<textarea id="city" name="city" 
				onChange={cityContentChange}/>
				
				<p>Country:</p>
				<textarea id="country" name="country" 
				onChange={countryContentChange}/>
				
				<p>Phone Number:</p>
				<textarea id="phone" name="phone" 
				onChange={phoneContentChange}/>
				
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
			
			
	 
      </div>
    </div>
  );
}
