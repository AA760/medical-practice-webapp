import React from "react";
import './patientsChangeInfo.css';
import axios from 'axios';


export default function PatientsChangeInfo() {
  
  //Variables to store form input data
  const [fname, setFname] = React.useState("");
  const [lname, setLname] = React.useState("");
  const [dob, setDob] = React.useState("");
  const [phone, setPhone] = React.useState("");
 

  const [output, setOutput] = React.useState("");

  //Arrow functions to handle content change
  const fnameContentChange = event => setFname(event.target.value);
  const lnameContentChange = event => setLname(event.target.value);
  const dobContentChange = event => setDob(event.target.value);
  const phoneContentChange = event => setPhone(event.target.value);

 

  

  //Arrow function to handle update button press
  const handleUpdate = event => {
    event.preventDefault();
    setOutput("Update button pressed.")
	
	
    axios({
      method: 'put',
      url: '/changePatientInfo',
	  data: {
		  first_name: fname,last_name: lname,dob: dob,phone: phone
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



  return (
    <div>
      <div className="container">
		  
		  
			<form>
				<h1>Change Patient Information</h1>
				<p>Firstname:</p>
				<textarea id="firstname" name="firstname"
				onChange={fnameContentChange} />
				
				<p>Lastname:</p>
				<textarea id="lastname" name="lastname"
				onChange={lnameContentChange} />
				
				<p>Date of Birth:</p>
				<textarea id="dob" name="dob"
				onChange={dobContentChange} />
				
				<p>Phone:</p>
				<textarea id="lastname" name="lastname"
				onChange={lnameContentChange} />
			</form>
			
		    <form>
				<button onClick={handleUpdate}>
				Change
				</button>
			</form>  
        
        <div className="box">
          <p>{output}</p>
        </div>
      </div>
    </div>
  );
}
