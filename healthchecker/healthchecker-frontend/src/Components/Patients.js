import React, { useEffect } from "react";
import './Patients.css';
import Loader from 'react-loader-spinner';
import axios from 'axios';



export default function Patients() {
	const [data, updateData] = React.useState([]);
	const [patientinfo, setPatientInfo] = React.useState([]);
	//const [output, setOutput] = React.useState("");
	const [patientID, setPatientId] = React.useState("");

	const [responsePatientID, setResponsePatientId] = React.useState("");
	const patientId = event => setPatientId(event.target.value);
	
	//stores currently logged in user's ID
	const [currentId, setCurrentId] = React.useState("");

	
	let isLoading = true;
	
	
	

axios({
			method: 'get',
			url: '/patients',
		}).then(res => {
			console.log(res);
		  
		var stringResponse = JSON.stringify(res.data)
		var arrayResponse = stringResponse.split('{')
		//var patientResponse = arrayResponse[2].split(',');
		var patientResponse;
		var patientId1;
		//var realPatientId=0;
		var i = 0;
		for (i = 1; i < arrayResponse.length; i++) 
			{
				patientResponse = arrayResponse[i].split(',');
				patientId1 = patientResponse[2].split('"patient_Id":');

				var realPatientId = parseInt(patientId1[1]);
				setResponsePatientId(realPatientId);

			}
			//setOutput(patientID);
  		});
	useEffect(() => {
		axios({
			method: 'get',
			url: '/patients',
		}).then(res => {
			console.log(res);
			updateData(res.data)

		});
	}, []);
	
	  
	//retrieves ID of the user currently logged in
	  axios({
      method: 'get',
      url: '/id',
    })
	.then((response) => {
		console.log(response);
		var cId = JSON.stringify(response.data);
		setCurrentId(cId);
	}, (error) => {
		console.log(error);
		setCurrentId("Please log in first!");
		
	});
	
	
	

	if (patientID==responsePatientID) isLoading = false;
	
 
  const [description, setDescription] = React.useState("");
  const [output, setOutput] = React.useState("");
  const Description = event => setDescription(event.target.value);
 
	
	
	

	return (
		<div className="container">
		
		
		  
				
					<h3> Patient Records </h3>
			<table>
				<tr> 
					<td>
						User id:
                	</td>
					<td>
						<textarea id="Userid" name="Userid" placeholder="Type your patient ID" onChange={patientId}>     			</textarea><br></br>
						<form>
				<button>
				Search
				</button>
				</form> 
					</td>
					
				</tr>
				
				
				
			</table>
			
			
					<table className="table" aria-label="Table">

						<thead>
							<tr>
								
								<th>First Name</th>
								<th>Last Name</th>
								<th>DOB</th>
								<th>DOR</th>
								<th>Address id</th>
								<th>Phone</th>
								<th>User ID</th>
								
								
								
								
							</tr>
							<tr>
							
							
</tr>
							</thead>

<div>
      <div className="container" >
        

        

            

          
        
       
      </div>
    </div>













						
						<tbody>
							{data?.map(row => (
								<tr key={row.patient_Id}>
									<td align="left">{row.firstName}</td>
									<td align="left">{row.lastName}</td>
									<td align="left">{row.dob}</td>
									<td align="left">{row.dor}</td>
									<td align="left">{row.addressId}</td>
									<td align="left">{row.phone}</td>
									<td align="left">{row.user_Id}</td>
									
									
									
								</tr>
							))}
						</tbody>
					</table>
				
		</div>
	);
}