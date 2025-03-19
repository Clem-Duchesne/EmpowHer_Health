import logo from './logo.svg';
import './App.css';
import axios from 'axios';
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Header from './components/Header';
import Footer from './components/Footer';

function App() {

  return (
      <>
        <BrowserRouter>
        <NavBar/>
        <Routes>
            <Route path="/" index element={<Home />} />
            <Route path="/login" element={<Login />} />
            <Route path="/profile" element={<Profile />} />
        </Routes>
      </BrowserRouter>
      </>
  );
}

export default App;
