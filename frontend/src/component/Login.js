import React,{useState} from 'react'
import  Home from './Home';
import 'antd/dist/reset.css';
import loginService from '../services/login'
import { Button, Checkbox, Form, Input } from 'antd';
import {
    Divider,
    Row,
    Typography,
    Layout,
    message,
    Modal,
  } from "antd";
import { UserOutlined, LockOutlined } from "@ant-design/icons";
const { Title } = Typography;
const { Header, Content, Footer, Sider } = Layout;

/*
  This component renders the Login Form with all its functionalities
  startLogin is the method that uses the axios service to submit login credentials to the backend
*/
const Login = ({ startLogin }) => {
  // States for tracking form input which are the email address and password
  const [ email, setEmail ] = useState('')
  const [ password, setPassword ] = useState('')
  const [ user, setUser ] = useState(null)

  // onSubmit event handler of this form
  const handleLogin = async(event) => {
    event.preventDefault()

    const credentials = {
      "emp_email" : email,
      "emp_pass" : password
    }
    try {
      
      const userObject = await loginService.login(credentials)
      setUser(userObject)
      window.localStorage.setItem('loggedInUser', JSON.stringify(userObject))
      //console.log("Hii")
      console.log(userObject)
      //window.location.href("http://localhost:3000/home")
     // notificationHandler(`Logged in successfully as ${userObject.firstName}`, 'success')
    }
    catch (exception) {
      console.log(exception)
      //notificationHandler(`Log in failed, check username and password entered`, 'error')
    }

    // Calling startLogin with the provided credentials that will make a call to the backend
    await startLogin(credentials)
    console.log(startLogin)
    //setEmail('')
    //setPassword('')
    
  }


    return (
        <Layout style={{ minHeight: "100vh", backgroundImage:"url(./iiitb.png)",backgroundRepeat:'no-repeat'}}>
          <Content>
            <div>
              <Row justify="center" align="bottom">
                <Form
                  name="normal_login"
                  className="login-form"
                  initialValues={{ remember: true }}
                  onSubmit={handleLogin} 
                  id='login-form'
                >
                  <Title className="center_title" level={3}>
                    Employee Login
                  </Title>
                  <Divider plain>Enter details to login</Divider>
                  <Form.Item
                    name="email"
                    rules={[
                      { required: true, message: "Enter Email!" },
                    ]}
                  >
                    <Input
                      prefix={<UserOutlined className="site-form-item-icon" />}
                      placeholder="Email"
                      type='email'
                      value={email}
                      onChange = {event => setEmail(event.target.value)}
                      required
                    />
                  </Form.Item>
  
                  <Form.Item
                    name="password"
                    rules={[
                      { required: true, message: "Enter Password!" },
                    ]}
                  >
                    <Input
                      prefix={<LockOutlined className="site-form-item-icon" />}
                      type="password"
                      placeholder="Password"
                      value={password}
                      onChange={event => setPassword(event.target.value)}
                      id= "password"
                      required
                    />
                  </Form.Item>
  
                  <Form.Item>
                    <Button
                      type="primary"
                      htmlType="submit"
                      className="login-form-button" 
                      onClick={(e) => handleLogin(e)}
                    >
                      Log in
                    </Button>
                  </Form.Item>
  
                </Form>
              </Row>
            </div>
          </Content>
        </Layout>
      );
                  }
export default Login