import React from "react";
import './patientRegister1.css';
import axios from 'axios';


export default function PatientRegister1(){
  //Define two states
  //1. The content entered in the texbox in the form
  //2. Output to be displayed to the user
  // const [data, updateData] = React.useState([]);
  const [line1, setLine1] = React.useState("");
  const [line2, setLine2] = React.useState("");
  const [postcode, setPostcode] = React.useState("");
  const [city, setCity] = React.useState("");
  const [country, setCountry] = React.useState("");
  const [output, setOutput] = React.useState("");
  const [userName, setUserName] = React.useState("");
  const [password, setPassword] = React.useState("");
  const [role, setRole] = React.useState("");
  const [firstName, setFirstName] = React.useState("");
  const [lastName, setLastName] = React.useState("");
  const [dob, setDOB] = React.useState("");
  const [phone, setPhone] = React.useState("");

  const [USERID, setUSERID] = React.useState(0);
  const [ADDRESSID, setADDRESSID] = React.useState(0);
  // const [output, setOutput] = React.useState("");

  //Arrow function to handle content change
  const Line1 = event => setLine1(event.target.value);
  const Line2 = event => setLine2(event.target.value);
  const Postcode = event => setPostcode(event.target.value);
  const City = event => setCity(event.target.value);
  const Country = event => setCountry(event.target.value);

  const user_name = event => setUserName(event.target.value);
  const Password = event => setPassword(event.target.value);
  const Role = event => setRole(event.target.value);

  const FirstName = event => setFirstName(event.target.value);
  const LastName = event => setLastName(event.target.value);
  const DOB = event => setDOB(event.target.value);
  const Phone = event => setPhone(event.target.value);


  //ToDo: Arrow function to handle form submission on pressing Save button
  const handleSubmit = event => {
    event.preventDefault();

      let one = "/address";
      let two= "/user";
      let three="/patient";
      const requestOne = axios.post(one,{
        "line1": line1,
        "line2": line2,
        "postcode": postcode,
        "city": city,
        "country": country
      });
      const requestTwo = axios.post(two,{
        "user_name": userName,
        "password": password,
        "roles": role,
        "active": "true"
      });
      

      axios.all([requestOne, requestTwo])
      .then((response) => {
        console.log(response);
      //  setOutput("Job ad successfully added");
      }, (error) => {
        console.log(error);
        // setOutput("Job ad failed");
      });
      
      axios({
      method: 'get',
      url: '/user',
      }).then(res => {
      console.log(res);

      // updateData(res.data)
      var stringResponse = JSON.stringify(res.data)
        var arrayResponse = stringResponse.split(',');
        var idResponse = arrayResponse[(arrayResponse.length)-5].split('{"id":');
        var id=idResponse[1];
        var idNumber=parseInt(idResponse[1]);
        var realuserid=idNumber+2;

        

        var roleResponse = arrayResponse[(arrayResponse.length)-2].split('"roles":"');
        var roleResponse1 = roleResponse[1].split('"');
        var role = roleResponse1[0];
        if(role==="ROLE_PATIENT")
        {
          setUSERID(realuserid)
        }
        else
        {
          setUSERID("NULL")
        }
        // setOutput(USERID)
      });

      axios({
      method: 'get',
      url: '/address',
      }).then(res => {
      console.log(res);

      // updateData(res.data)
        var stringResponse = JSON.stringify(res.data)
        var arrayResponse = stringResponse.split(',')
        var addressResponse = arrayResponse[(arrayResponse.length)-1].split('"addressid":');
        var address=addressResponse[1].split('}]');
        var addressIdNumber=parseInt(address);
        var realAddressid=addressIdNumber+2;
        setADDRESSID(realAddressid)


      });
      axios.post(three,{
        "firstName": firstName,
        "lastName": lastName,
        "dob": dob,
        "addressId": ADDRESSID,
        "phone": phone,
        "user_Id": USERID
      }).then((response) => {
        console.log(response);
      setOutput("Your data is successful saved");
      }, (error) => {
        console.log(error);
        setOutput(USERID);
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
                  Username: 
                </td>
                <td>
                  <textarea id="userName" name="userName" placeholder="Type your user name" onChange={user_name} />
                </td>
              </tr>

              <tr>
                <td>
                  Password: 
                </td>
                <td>
                  <textarea id="password" name="password" placeholder="Type your password" onChange={Password} />
                </td>
              </tr>

              <tr>
                <td>
                  Line1: 
                </td>
                <td>
                  <textarea id="line1" name="line1" placeholder="Type your address line1" onChange={Line1} />
                </td>
              </tr>

              <tr>
                <td>
                  Line2: 
                </td>
                <td>
                  <textarea id="line2" name="password" placeholder="Type your address line2" onChange={Line2} />
                </td>
              </tr>

              <tr>
                <td>
                  Postcode: 
                </td>
                <td>
                  <textarea id="postcode" name="postcode" placeholder="Type your postcode" onChange={Postcode}/>
                </td>
              </tr>

              <tr>
                <td>
                  City: 
                </td>
                <td>
                  <textarea id="city" name="city" placeholder="Type your city" onChange={City}/>
                </td>
              </tr>

              <tr>
                <td>
                  Country: 
                </td>
                <td>
                  <textarea id="country" name="country" placeholder="Type your country" onChange={Country}/>
                </td>
              </tr>

              <tr>
                <td>
                  First Name:
                </td>
                <td>
                  <textarea id="firstName" name="firstName" placeholder="Type your first name" onChange={FirstName}/>
                </td>
              </tr>

              <tr>
                <td>
                  Last Name:
                </td>
                <td>
                  <textarea id="lastName" name="lastName" placeholder="Type your last name" onChange={LastName}/>
                </td>
              </tr>

              <tr>
                <td>
                  Date of Birth: 
                </td>
                <td>
                  <textarea id="dob" name="dob" placeholder="Type your date of birth with year-month-day format" onChange={DOB}/>
                </td>
              </tr>

              <tr>
                <td>
                  Phone: 
                </td>
                <td>
                  <textarea id="phone" name="phone" placeholder="Type your phone number" onChange={Phone}/>
                </td>
              </tr>

              <tr>
                <td>
                  Role:
                </td>
                <td>
                  <input type="radio" value="ROLE_PATIENT" name="role" onChange={Role}/> Patient
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
