import { useEffect, useState } from "react";
import React from 'react';
import 'antd/dist/reset.css';
import {
  Row,
  Layout,
  Typography
} from "antd";
const { Title } = Typography;
function Home(){
 // const [key, setKey] = useState('home');
  return(
    <Layout style={{ minHeight: "100vh", display: 'flex', justifyContent: 'center', textAlign: 'center', backgroundImage: "url(./iiitb.png)", backgroundRepeat: 'no-repeat' }}>
    <div>
    <Row justify="center" align="bottom">
            <Title className="center_title" level={3} style={{ marginTop: '100px', fontSize: '50px' }}>
              Home Page
            </Title>
          </Row>
      <header>  
        <button onClick={()=>{
          window.location.replace("http://localhost:3000/allroom");
        }}>All Rooms</button>
        <button onClick={()=>{
          window.location.replace("http://localhost:3000/availroom");
        }}>Available Rooms</button>
        <button onClick={()=>{
          window.location.replace("http://localhost:3000/hostelfilter");
        }}>Hostels</button>
        <button onClick={()=>{
          window.location.replace("http://localhost:3000/floorfilter");
        }}>Floors</button>

      </header>
    </div>
    </Layout>
  );
}
export default Home;