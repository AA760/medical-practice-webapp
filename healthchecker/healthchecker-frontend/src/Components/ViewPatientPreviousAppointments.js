import React, { useEffect } from "react";
import './viewPatientPreviousAppointments.css';
import Loader from 'react-loader-spinner';
import axios from 'axios';

export default function ViewJob() {
	const [data, updateData] = React.useState([]);
	const [patientinfo, setPatientInfo] = React.useState([]);
	//const [output, setOutput] = React.useState("");
	const [patientID, setPatientId] = React.useState("");

	const [responsePatientID, setResponsePatientId] = React.useState("");
	const patientId = event => setPatientId(event.target.value);

	
	let isLoading = true;

axios({
			method: 'get',
			url: '/meetingarchive',
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
			url: '/meetingarchive',
		}).then(res => {
			console.log(res);
			updateData(res.data)

		});
	}, []);

	if (patientID==responsePatientID) isLoading = false;

	return (
		<div className="container">
			<table>
				<tr>
					<td>
						Patient ID:
                	</td>
					<td>
						<textarea id="patientId" name="patientId" placeholder="Type your patient ID" onChange={patientId} /><br></br>
						
					</td>
				</tr>
				
			</table>
			{isLoading ? (
				<Loader type="ThreeDots" color="#2BAD60" height="100" width="100" />
			) : (
					<table className="table" aria-label="Table">

						<thead>
							<tr>
								<th>Appointments' Reason</th>
								<th>Appointment Date</th>
							</tr>
						</thead>
						<tbody>
							{data?.map(row => (
								<tr key={row.meeting_archive_id}>
									<td align="left">{row.reason}</td>
									<td align="left">{row.date_Time}</td>
								</tr>
							))}
						</tbody>
					</table>
				)}
		</div>
	);
}