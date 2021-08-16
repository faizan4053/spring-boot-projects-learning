import React from 'react';
import { useState } from 'react';
import { Row,Col,Form,Button,Card } from 'react-bootstrap';
import { NavLink } from 'react-router-dom';
import axios from 'axios';
const RegistrationForm = () => {
const [email,setEmail]=useState('');
const [password,setPassword]=useState('');

const emailhandler=(str)=>{
    // console.log(email);
setEmail(str);

};
const passwordhandler=(str)=>{
    // console.log(password)
    setPassword(str);
   
};

const submitforms=()=>{
    console.log(password);
    console.log(email);
        
        let user={
            userName:"doug@123.com",
            password:"doug"
        }

        axios.localhost("http://localhost:9092/getaccesstoken",user).then(res=>{
            console.log(res.data)
        })

        }

    return(
        <div className="login-container container">
        <Card style={{borderTop:"1px solid black",width:"700px",margin:"0 auto"}} bg="light">
            <Row className="justify-content-md-center">
            
             
                    <Row ><h2 className="text-center display-5">Sign In</h2></Row>
                    <br></br>
                    <Form onSubmit={submitforms} name="form">
                        <Row>
                            <Form.Group className="mb-3 " controlId="formBasicEmail">
                            <Form.Label>Email address</Form.Label>
                            <Form.Control required type="email" value={email} onChange={(e)=>emailhandler(e.target.value)} placeholder="Enter email" name="mail"/>
                            </Form.Group>
                        </Row>
                        <Row>
                            <Form.Group classsName="mb-3" controlId="formBasicPassword">
                            <Form.Label>Password</Form.Label>
                            <Form.Control required value={password} onChange={(e)=>passwordhandler(e.target.value)} type="password" placeholder="Password" name="password"/>
                            </Form.Group>
                        </Row>
                        <br/>
                        <Row className="justify-content-md-center">
                            <Col md="auto"><Button variant="primary" type="submit" >LOGIN</Button></Col>
                        </Row>
                    </Form>
                    <hr></hr>
                    <h6 className="text-center">
                        <NavLink to="/reset-password"> Forgot password?</NavLink>
                        <br/><br/>
                        New to El Dorado? <NavLink to="/register">Sign Up</NavLink>
                    </h6>
              
              
            </Row>
            </Card>
        </div>
    );
}

export default RegistrationForm;

