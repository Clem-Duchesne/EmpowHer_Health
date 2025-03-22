import logo from './logo.svg';
import './App.css';
import axios from 'axios';
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Header from './components/Header';
import Footer from './components/Footer';
import Login from './pages/Login';
import Subscribe from './pages/Subscribe';
import Home from './pages/Home';
import Profile from './pages/Profile';

function App() {

  return (
      <>
        <BrowserRouter>
        <Routes>
            <Route path="/" index element={<Home />} />
            <Route path="/login" element={<Login />} />
            <Route path="/subscribe" element={<Subscribe />} />
            <Route path="/profile" element={<Profile />} />
        </Routes>
      </BrowserRouter>
      </>
  );
}

export default App;
