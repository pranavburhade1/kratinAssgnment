import React, { useState } from 'react'
import UserServices from '../services/UserServices';

export default function HomeComponent() {

    const [user,setUser] = useState({
        email : '',
        password : ''
    });

    const upData = (event)=> {
        event.preventDefault();
        setUser({...user,[event.target.name] : event.target.value});
    }

    const submt = (event)=> {
        event.preventDefault();
       UserServices.login(user).then((res)=>{
        localStorage.setItem("userLoged", JSON.stringify(res.data))
       }).catch((err)=>{
        console.log(err);
       })
    }
  return (
    <div className='row'>
        <div className='col-lg-3 col-sm-12 '></div>
      <div className=' col-lg-6 col-sm-12 mt-5 p-5 border border-primary' style={{textAlign : 'center'}}>
        <h1>Log In</h1>
        <form onSubmit={submt}>
  <div className="mb-3">
    <label for="exampleInputEmail1" className="form-label">Email address</label>
    <input type="email" className="form-control" id="exampleInputEmail1" name='email' onChange={upData} aria-describedby="emailHelp"/>
    <div id="emailHelp" className="form-text">We'll never share your email with anyone else.</div>
  </div>
  <div className="mb-3">
    <label for="exampleInputPassword1" className="form-label">Password</label>
    <input type="password" onChange={upData} className="form-control" name='password' id="exampleInputPassword1"/>
  </div>
<div className='row'><div className='col-6'>
<button type="submit" className="btn btn-primary">Submit</button>
    </div>
    <div className='col-6'>
    <a href='/register'> new here register now</a>
        </div></div>
 

</form>
        </div>
      <div className='col-lg-3 col-sm-12'></div>
    </div>
  )
}
