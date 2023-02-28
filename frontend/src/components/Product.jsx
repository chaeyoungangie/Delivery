import React from 'react'
import styled from "styled-components";
import ProductItem from "./ProductItem";
import { Row, Col } from "react-bootstrap";

const Container = styled.div``;

export default function Product( {items}) {
  return (
    <Container>
      <Row>
        {items.map((item) => (
            <Col md='4'>
                <ProductItem item={item} key={item.id} />
            </Col>
        ))}
      </Row>
    </Container>
  )
}
