import React, { useEffect, useState } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import NavBar from './components/NavBar';
import HomeComponent from './components/HomeComponent';
import RegistrationComponent from './components/RegistrationComponent';
import 'bootstrap/dist/css/bootstrap.min.css';
import Base from './components/userComp/Base';
import HomeUser from './components/userComp/HomeUser';
import Footer from './components/Footer';
import AddDisease from './components/userComp/AddDisease';



export default function App() {
  const [name, setName] = useState(JSON.parse(localStorage.getItem('userLoged')));

  useEffect(() => {
    const item = JSON.parse(localStorage.getItem('userLoged'));
    if (item) {
      setName(item);
    }
  }, []);

  return (
    <Router>
      <div>
        <NavBar name={name} setName={setName} />
        <Routes>
          <Route path="/" element={<HomeComponent setName={setName} />} />
          <Route path="/register" element={<RegistrationComponent />} />
          <Route path="/user" element={<Base />}>
            <Route path="home" element={<HomeUser />} />
            <Route path="adddisease" element={<AddDisease/>} />
          </Route>
        </Routes>
         <Footer/> 
      </div>
    </Router>
  );
}
