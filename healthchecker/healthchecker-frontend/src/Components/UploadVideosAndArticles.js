import React from "react";
import './uploadVideosAndArticles.css';
import axios from 'axios';


export default function PatientRegister1(){
  //Define two states
  //1. The content entered in the texbox in the form
  //2. Output to be displayed to the user
  // const [data, updateData] = React.useState([]);
  const [name, setName] = React.useState("");
  const [description, setDescription] = React.useState("");
  const [link, setLink] = React.useState("");
  const [output, setOutput] = React.useState("");

  // const [output, setOutput] = React.useState("");

  //Arrow function to handle content change
  const Name = event => setName(event.target.value);
  const Description = event => setDescription(event.target.value);
  const Link = event => setLink(event.target.value);



  //ToDo: Arrow function to handle form submission on pressing Save button
  const handleSubmit = event => {
    event.preventDefault();

      let one = "/videosandarticles";
      const requestOne = axios.post(one,{
        "name": name,
        "description": description,
        "link": link
      });
      

      axios.all([requestOne])
      .then((response) => {
        console.log(response);
        setOutput("Videos or Articles successfully added");
      }, (error) => {
        console.log(error);
         setOutput("Videos or Articles failed");
      });



  };


  return (
    <div>
      <div className="container">
        

        <div className="box"> 
          <form className="form" noValidate>
            <br></br>
            <table>
              <tr>
                <td>
                  Name: 
                </td>
                <td>
                  <textarea id="Name" name="Name" placeholder="Type the name of videos or articles" onChange={Name} />
                </td>
              </tr>

              <tr>
                <td>
                  Description 
                </td>
                <td>
                  <textarea id="description" name="description" placeholder="Type the description of videos or articles" onChange={Description} />
                </td>
              </tr>

              <tr>
                <td>
                  Link: 
                </td>
                <td>
                  <textarea id="link" name="link" placeholder="Type the link of videos or articles" onChange={Link} />
                </td>
              </tr>
            </table>

            <button className="button" onClick={handleSubmit}>Next</button>

          </form>
        </div>
        <div className="box">
          <p>{output}</p>
        </div>
      </div>
    </div>
  );
}
