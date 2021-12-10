import { Route, BrowserRouter as Router, Routes } from "react-router-dom";

import './App.css';
import SignUp from './pages/SignUp.js';
import SignIn from './pages/SignIn.js';
import Home from './pages/Home.js';

function App() {
  return (
    <div className="App">
      <Router basename="/">
        <Routes>
          <Route 
            exact path="/" 
            element={<Home />}>
          </Route>
          <Route 
            path="/signin" 
            element={<SignIn />}>
          </Route>
          <Route 
            path="/signup" 
            element={<SignUp />}>
          </Route>
        </Routes>
      </Router>
    </div>
  );
}

export default App;