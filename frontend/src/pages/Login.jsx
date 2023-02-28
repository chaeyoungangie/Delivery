import React from 'react'
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";
import Footer from "../components/Footer";
import Navbar from "../components/Navbar";

const Container = styled.div`
  /* width: 100vw;
  height: 100vh;
  background: linear-gradient(
      rgba(255, 255, 255, 0.5),
      rgba(255, 255, 255, 0.5)
    ),
    url("https://images.pexels.com/photos/6984650/pexels-photo-6984650.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940")
      center;
  background-size: cover;
  display: flex;
  align-items: center;
  justify-content: center; */
`;

const Wrapper = styled.div`
  width: 25%;
  padding: 20px;
  background-color: white;
`;

const Title = styled.h1`
  font-size: 24px;
  font-weight: 300;
`;

const Form = styled.form`
  display: flex;
  flex-direction: column;
`;

const Input = styled.input`
  flex: 1;
  min-width: 40%;
  margin: 10px 0;
  padding: 10px;
`;

const Button = styled.button`
  width: 40%;
  border: none;
  padding: 15px 20px;
  background-color: teal;
  color: white;
  cursor: pointer;
  margin-bottom: 10px;
`;

const Link = styled.a`
  margin: 5px 0px;
  font-size: 12px;
  text-decoration: underline;
  cursor: pointer;
`;

const Login = (props) => {

  const navigate = useNavigate();
  const [username, setUsername] = useState("")
  const [password, setPassword] = useState("")

  const login_submit = (e) => {

    e.preventDefault()
    fetch("/api/v1/auth/login", {
      method: "POST",
      headers: {'Content-type': 'application/json'},
      body: JSON.stringify ({
        username: username,
        password: password
      })
    })
    .then(res => res.json())
    .then(res => {
        console.log(res)
        if (res.token){
          props.isAuthenticated(res.token)
          navigate("/");
        }
    })
    .catch(err=> { 
      alert("아이디와 비밀번호를 다시 한 번 확인해주세요")
    });
  }

  return (
    <Container>
      <Navbar isAuthenticated={props.isAuthenticated} token={props.token} />
      <Wrapper>
        <Title>SIGN IN</Title>
        <Form>
          <Input placeholder="username" onChange={(e)=>setUsername(e.target.value)}/>
          <Input placeholder="password" onChange={(e)=>setPassword(e.target.value)}/>
          <Button onClick={ login_submit } >LOGIN</Button>
          <Link>DO NOT YOU REMEMBER THE PASSWORD?</Link>
          <Link>CREATE A NEW ACCOUNT</Link>
        </Form>
      </Wrapper>
      <Footer/>
    </Container>
  );
};

export default Login;