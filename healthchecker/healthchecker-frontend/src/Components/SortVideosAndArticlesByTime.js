import React, { useEffect } from "react";
import './sortVideosAndArticlesByTime.css';
import Loader from 'react-loader-spinner';
import axios from 'axios';

export default function ViewJob() {
	const [data, updateData] = React.useState([]);

	let isLoading = true;

	useEffect(() => {
		axios({
			method: 'get',
			url: '/videosandarticles',
		}).then(res => {
			console.log(res);	
			updateData(res.data.reverse())
		});
	}, []);

	if (data.length > 0) isLoading = false;

	return (
		<div className="container">
			
			{isLoading ? (
				<Loader type="ThreeDots" color="#2BAD60" height="100" width="100" />
			) : (
					<table className="table" aria-label="Table">

						<thead>
							<tr>
								<th>Videos And Articles Name</th>
								<th>Videos And Articles Description</th>
								<th>Videos And Articles Link</th>
								<th>Videos And Articles Uploaded Date</th>
							</tr>
						</thead>
						<tbody>
							{data?.map(row => (
								<tr key={row.meeting_archive_id}>
									<td align="left">{row.name}</td>
									<td align="left">{row.description}</td>
									<td align="left">{row.link}</td>
									<td align="left">{row.upload_date}</td>
								</tr>
							))}
						</tbody>
					</table>
				)}
		</div>
		
	);
}