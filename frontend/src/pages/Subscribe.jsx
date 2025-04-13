import React, { createContext, useContext, useState } from 'react';
import axios from 'axios';

function Subscribe()
{
    // State for email and password
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [errorMessage, setErrorMessage] = useState('');
    const [isLoading, setIsLoading] = useState(false);

    // Handle form submission
    const handleSubmit = async (e) => {
    e.preventDefault();

    // Simple validation (can be expanded)
    if (!email || !password) {
      setErrorMessage('Both email and password are required.');
      return;
    }

    setIsLoading(true);
    
    // Make API call to login 
    try {
      // Make API call to your backend
      const userData = {
        email: email,
        password: password
    };

      const response = await axios.post('http://localhost:8080/users', userData);

      // Assuming the response contains user data or a token, handle the response
      console.log('Login Successful:', response.data);
      setIsLoading(false); // Reset loading state

      // Reset the form (optional)
      setEmail('');
      setPassword('');

    } catch (error) {
      // Handle error (e.g., invalid credentials or network error)
      console.error('Login failed:', error);
      setErrorMessage('Invalid email or password, please try again.');
      setIsLoading(false); // Reset loading state
    }
  };

    return (
      <div className="flex items-center justify-center min-h-screen bg-gray-100">
      <div className="bg-white p-8 rounded shadow-md w-full max-w-sm">
      <img
          src="/assets/logo.png"
          alt="EmpowHer Health Logo"
          className="mx-auto mb-6"
        />
        <h2 className="text-2xl font-bold mb-6 text-center text-empowher-dark-blue">Subscribe</h2>
        <form onSubmit={handleSubmit}>
          <div className="mb-4">
            <label className="block text-gray-700">Username</label>
            <input
              type="text"
              className="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-empowher-blue"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </div>
          <div className="mb-6">
            <label className="block text-gray-700">Password</label>
            <input
              type="password"
              className="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-empowher-blue"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>
          <div className="flex items-center justify-between">
            <button
              type="submit"
              className="w-full px-4 py-2 text-white bg-empowher-blue rounded hover:bg-blue-400 focus:outline-none focus:ring-2 focus:ring-blue-600 focus:ring-opacity-50"
            >
              Subscribe
            </button>
          </div>
        </form>
      </div>
    </div>
    );
 
}

export default Subscribe