import React from 'react'
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";
import Footer from "../components/Footer";
import Navbar from "../components/Navbar";

const Container = styled.div`
  /* width: 100vw;
  height: 100vh; */
  /* background: linear-gradient(
      rgba(255, 255, 255, 0.5),
      rgba(255, 255, 255, 0.5)
    ),
    url("https://images.pexels.com/photos/6984661/pexels-photo-6984661.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940")
      center;
  background-size: cover; */
  /* display: flex; */
  /* align-items: center; */
  /* justify-content: center; */
`;

const Wrapper = styled.div`
  width: 40%;
  padding: 20px; 
  background-color: white;
`;

const Title = styled.h1`
  font-size: 24px;
  font-weight: 300;
`;

const Form = styled.form`
  display: flex;
  flex-wrap: wrap;
`;

const Input = styled.input`
  flex: 1;
  min-width: 40%;
  margin: 20px 10px 0px 0px;
  padding: 10px;
`;

const Agreement = styled.span`
  font-size: 12px;
  margin: 20px 0px;
`;

const Button = styled.button`
  width: 40%;
  border: none;
  padding: 15px 20px;
  background-color: teal;
  color: white;
  cursor: pointer;
`;

const Register = (props) => {
    const navigate = useNavigate();
    const [firstname, setFirstname] = useState("")
    const [lastname, setLastname] = useState("")
    const [username, setUsername] = useState("")
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")
    const [password2, setPassword2] = useState("")
    
    const handleClicked = (e) => {
      if (password === password2) {
        e.preventDefault()
        fetch("/api/v1/auth/register", {
            method: "POST",
            headers: {'Content-type': 'application/json'},
            body: JSON.stringify({
              firstname: firstname,
              lastname: lastname,
              username: username,
              email: email,
              password: password
            })
        })
        .then(res => res.json())
        .then(res => {
            console.log(res)
            alert("회원가입이 완료되었습니다")
            navigate("/");

        })
        .catch(err => { 
            console.log("register fetch error!")
            console.log(err) 
        });
      } else {
        alert("비밀번호가 다릅니다!")
      }
        
    }


    return (
    <Container>
        <Navbar isAuthenticated={props.isAuthenticated} token={props.token} />
        <Wrapper>
        <Title>CREATE AN ACCOUNT</Title>
        <Form>
            <Input placeholder="first name" onChange={(e)=>setFirstname(e.target.value)} />
            <Input placeholder="last name" onChange={(e)=>setLastname(e.target.value)} />
            <Input placeholder="username" onChange={(e)=>setUsername(e.target.value)} />
            <Input placeholder="email" onChange={(e)=>setEmail(e.target.value)} />
            <Input placeholder="password" onChange={(e)=>setPassword(e.target.value)} />
            <Input placeholder="confirm password" onChange={(e)=>setPassword2(e.target.value)} />
            <Agreement>
            By creating an account, I consent to the processing of my personal
            data in accordance with the <b>PRIVACY POLICY</b>
            </Agreement>
            <Button onClick={ handleClicked } >CREATE</Button>
        </Form>
        </Wrapper>
        <Footer/>
    </Container>
    );
};

export default Register;