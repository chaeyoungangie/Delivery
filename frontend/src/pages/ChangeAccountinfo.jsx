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

const ChangeAccountinfo = (props) => {

  const navigate = useNavigate();
  const [firstname, setFirstname] = useState("")
  const [lastname, setLastname] = useState("")
  const [email, setEmail] = useState("")
  const [password, setPassword] = useState("")

  const changeinfo = (e) => {
    e.preventDefault()
    fetch("/api/v1/auth/change", {
      method: "POST",
      headers: {
        'Content-type': 'application/json',
        'Authorization': 'Bearer ' + props.token
      },
      body: JSON.stringify ({
        firstname: firstname,
        lastname: lastname,
        email: email,
        password: password,
        token: props.token
      })
    })
    .then(res => res.json())
    .then(res => {
        console.log(res)
        props.isAuthenticated(res.token)
        alert("회원 정보 변경이 완료되었습니다.")
        navigate("/");
    })
    .catch(err=> { 
      alert("입력한 정보를 다시 한 번 확인해주세요.")
    });
  }

  return (
    <Container>
      <Navbar isAuthenticated={props.isAuthenticated} token={props.token} />
      <Wrapper>
        <Title> Change Account Profile </Title>
        <Form>
          <Input placeholder="First name" onChange={(e)=>setFirstname(e.target.value)}/>
          <Input placeholder="Last name" onChange={(e)=>setLastname(e.target.value)}/>
          <Input placeholder="Email" onChange={(e)=>setEmail(e.target.value)}/>
          <Input placeholder="Password" onChange={(e)=>setPassword(e.target.value)}/>
          <Title> username은 변경할 수 없습니다 </Title>
          <Button onClick={ changeinfo } > 변경 </Button>
        </Form>
      </Wrapper>
      <Footer/>
    </Container>
  );
};

export default ChangeAccountinfo;