import React, { useState } from 'react';
import UserServices from '../services/UserServices';
import { Link, useNavigate } from 'react-router-dom';

export default function HomeComponent({ setName }) {
  const [user, setUser] = useState({
    email: '',
    password: ''
  });
  const navigate = useNavigate();

  const upData = (event) => {
    event.preventDefault();
    setUser({ ...user, [event.target.name]: event.target.value });
  };

  const submit = (event) => {
    event.preventDefault();
    UserServices.login(user)
      .then((res) => {
        localStorage.setItem('userLoged', JSON.stringify(res.data));
        setName(res.data);
        navigate('/user/home');
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <div className='row'>
      <div className='col-lg-3 col-sm-12'></div>
      <div className='col-lg-6 col-sm-12 mt-5 p-5 border border-primary' style={{ textAlign: 'center' }}>
        <h1>Log In</h1>
        <form onSubmit={submit}>
          <div className='mb-3'>
            <label htmlFor='exampleInputEmail1' className='form-label'>
              Email address
            </label>
            <input type='email' className='form-control' id='exampleInputEmail1' name='email' onChange={upData} aria-describedby='emailHelp' />
            <div id='emailHelp' className='form-text'>
              We'll never share your email with anyone else.
            </div>
          </div>
          <div className='mb-3'>
            <label htmlFor='exampleInputPassword1' className='form-label'>
              Password
            </label>
            <input type='password' onChange={upData} className='form-control' name='password' id='exampleInputPassword1' />
          </div>
          <div className='row'>
            <div className='col-6'>
              <button type='submit' className='btn btn-primary'>Submit</button>
            </div>
            <div className='col-6'>
              <Link to='/register'>New here? Register now</Link>
            </div>
          </div>
        </form>
      </div>
      <div className='col-lg-3 col-sm-12'></div>
    </div>
  );
}
