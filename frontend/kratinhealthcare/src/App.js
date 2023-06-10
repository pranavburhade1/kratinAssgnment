import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import NavBar from './components/NavBar';
import HomeComponent from './components/HomeComponent';
import RegistrationComponent from './components/RegistrationComponent';

function App() {
  return (
   <div>
    <NavBar></NavBar>
      <BrowserRouter>
    <Routes>
      <Route path='/' exact Component={HomeComponent}/>
      <Route path='/register' exact Component={RegistrationComponent}/>
    </Routes>
    </BrowserRouter>
   </div>
   
  );
}

export default App;
