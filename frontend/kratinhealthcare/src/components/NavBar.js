import React from 'react';
import { useNavigate } from 'react-router-dom';
import IsLogInUSer from '../services/Autho';

export default function NavBar({ name, setName }) {
  const navigate = useNavigate();

  const logOut = () => {
    localStorage.removeItem('userLoged');
    setName(null);
    navigate('/');
  };

  return (
    <div className='row'>
      <nav className='navbar bg-body-primary' style={{ backgroundColor: 'skyblue' }}>
        <div className='container m-0 col-lg-9 col-md-6 col-sm-12'>
          <a href='/'>
            <img src='./kratin.png' alt='Bootstrap' width='80' height='24' />
          </a>
        { IsLogInUSer() && <a href='/user/addDeases' > Add Disease</a>}
        </div>
        <div className='col-lg-3 col-md-6 col-sm-12'>
          <div>
            {name && name.email} &nbsp;&nbsp;
            {name && (
              <span className='btn btn-danger' onClick={logOut}>
                Logout
              </span>
            )}
          </div>
        </div>
      </nav>
    </div>
  );
}