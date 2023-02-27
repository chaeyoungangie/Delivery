import React, { useEffect } from 'react'
import styled from "styled-components"
import { useState } from "react";
import { useNavigate } from 'react-router-dom';

const Container = styled.div`
    width: 100%;
    height: 100vh;
    display: flex;
    position: relative;
`
const Wrapper = styled.div`
  height: 100%;
  display: flex;
`
const InfoContainer = styled.div`
  flex: 1;
  padding: 50px;
`
const Title = styled.h1`
  font-size: 30px;
`
const Button = styled.button`
  padding: 10px;
  font-size: 20px;
  background-color: transparent;
  cursor: pointer;
`

const UserAccount = (props) => {    
    const navigate = useNavigate();
    const [firstname, setFirstname] = useState("")
    const [lastname, setLastname] = useState("")
    const [username, setUsername] = useState("")
    const [email, setEmail] = useState("")

    useEffect(() => {
        fetch("/api/v1/users/getAccount", {
            method: "POST",
            headers: {
                'Content-type': 'application/json',
                'Authorization': 'Bearer ' + props.token
            },
            body: JSON.stringify ({
                token: props.token
            })
            })
            .then(res => res.json())
            .then(res => {
                setFirstname(res.firstname)
                setLastname(res.lastname)
                setUsername(res.username)
                setEmail(res.email)
            })
            .catch(err=> { 
                console.log("invalid login")
                console.log(err) 
            });
    }, []);
 
    return (
        <Container>
            <Wrapper >
                <InfoContainer>
                    <Title> 이름: {firstname}, {lastname} </Title>
                    <Title> 아이디: {username} </Title>
                    <Title> 이메일: {email} </Title>
                    <Button onClick={() => navigate("/changeaccountinfo")} > 회원정보 변경 </Button>
                    <Button onClick={() => navigate("/order")} > 주문목록 보기 </Button>
                </InfoContainer>
            </Wrapper>
        </Container>
    )
};
export default UserAccount;

