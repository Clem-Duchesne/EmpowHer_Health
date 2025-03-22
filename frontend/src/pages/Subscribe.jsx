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
        <div className="login-container">
            <h2>Subscribe</h2>
            <form onSubmit={handleSubmit}>
                {errorMessage && <div style={{ color: 'red' }}>{errorMessage}</div>}

                <div className="input-group">
                <label htmlFor="email">Email</label>
                <input
                    type="email"
                    id="email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    placeholder="Enter your email"
                    required
                />
                </div>

                <div className="input-group">
                <label htmlFor="password">Password</label>
                <input
                    type="password"
                    id="password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    placeholder="Enter your password"
                    required
                />
                </div>

                <button type="submit">Subscribe</button>
            </form>
        </div>
    );
 
}

export default Subscribe