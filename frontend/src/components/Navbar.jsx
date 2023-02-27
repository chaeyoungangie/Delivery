import { Search, ShoppingCartOutlined } from '@material-ui/icons'
import { Badge } from "@material-ui/core";
import React, { useEffect, useState } from 'react'
import styled from 'styled-components'
import { useNavigate } from "react-router-dom";

const Container = styled.div`
    height=60px;
`
const Wrapper = styled.div`
    padding: 10px 20px;
    display: flex;
    justify-content: space-between;
    align-items: center;
`
const Left = styled.div`
    flex: 1;
    display: flex;
    align-items: center;
`
const Center = styled.div`
    flex: 1;
    text-align: center;
`
const Right = styled.div`
    flex: 1;
    display: flex;
    align-items: center;
    justify-content: flex-end;
`

const Language = styled.span`
    font-size: 14px;
    cursor: pointer;
`
const SearchContainer = styled.div`
  border: 0.5px solid lightgray;
  display: flex;
  align-items: center;
  margin-left: 25px;
  padding: 5px;
`
const Input = styled.input`
    border: none;
`
const Logo = styled.h1`
    font-weight: bold;
`
const MenuItem = styled.div`
  font-size: 14px;
  cursor: pointer;
  margin-left: 25px;
`

export default function Navbar(props) {
    const navigate = useNavigate();
    const [authenticated, setAuthenticated] = useState(false);
   
    const cart = () => {
        if (authenticated === false) {
            alert("You are not logged in!")
        } else {
            navigate("/cart")
        }
    }
    const logout = () => {
        props.isAuthenticated(null)
    }
    const account = () => {
        console.log("account in")
        console.log(authenticated)
        if (authenticated === false) {
            alert("You are not logged in!")
        } else {
            navigate("/account")
        }
    }
    useEffect(() => {
        if (props.token) {
            setAuthenticated(true)
        }
    },[props, authenticated])
    
    return (
        <Container>
            <Wrapper>
                <Left> 
                    <Language> KOR </Language> 
                    <SearchContainer>
                        <Input/>
                        <Search/>
                    </SearchContainer>
                </Left>
                <Center> <Logo onClick={() => navigate("/")}> GGOGI </Logo> </Center>
                <Right>
                    <MenuItem onClick={() => navigate("/register")}> REGISTER</MenuItem>
                    {!authenticated ? (
                    <MenuItem onClick={() => navigate("/login")}> SIGN IN </MenuItem>
                    ) : (
                    <MenuItem onClick={ logout }> SIGN OUT </MenuItem>
                    )}
                    <MenuItem onClick={ account }> MY ACCOUNT </MenuItem>
                    <MenuItem onClick={ cart } >
                        <Badge color="primary">
                        <ShoppingCartOutlined />
                        </Badge>
                    </MenuItem>
                </Right>
            </Wrapper>
        </Container>
    )
}
