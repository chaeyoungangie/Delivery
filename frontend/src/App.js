import React from 'react'
import Home from './pages/Home'
import ProductList from './pages/ProductList';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Register from './pages/Register';
import Login from './pages/Login';
import Cart from './pages/Cart';
import SingleProduct from './pages/SingleProduct';
import Account from './pages/Account';
import { useState } from 'react';
import ChangeAccountinfo from './pages/ChangeAccountinfo';
import Order from './pages/Order';
import SingleOrder from './pages/SingleOrder';

function App() {
   
    const [token, setToken] = useState(null);
    const [authenticated, setauthenticated] = useState(false);

    const isAuthenticated = (token) => {
      if (token === null) {
          setToken(null)
          setauthenticated(false)
      } else {
          setauthenticated(true)
          setToken(token)

      }
    }

    return (
      <Router>
          <Routes>
            <Route path="/login" element={<Login isAuthenticated={ isAuthenticated } token={token} />}  />
            <Route path="/cart" element={<Cart isAuthenticated={isAuthenticated} token={token} />} />
            <Route exact path="/" element={<Home isAuthenticated={isAuthenticated} token={token} />} />
            <Route path="/register" element={<Register isAuthenticated={isAuthenticated} token={token} />} />
            <Route path="/productlist" element={<ProductList />} />
            <Route path="/singleproduct" element={<SingleProduct isAuthenticated={isAuthenticated} token={token} />} />
            <Route path="/account" element={<Account isAuthenticated={isAuthenticated} token={token} />} />
            <Route path="/changeaccountinfo" element={<ChangeAccountinfo isAuthenticated={isAuthenticated} token={token} />} />
            <Route path="/order" element={<Order isAuthenticated={isAuthenticated} token={token} />} />
            <Route path="/singleorder" element={<SingleOrder isAuthenticated={isAuthenticated} token={token} />} />
          </Routes>
      </Router>
    );
}

export default App;