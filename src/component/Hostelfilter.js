import { useEffect, useState } from "react"
import 'antd/dist/reset.css';
import {
  Row,
  Typography,
  Layout,
} from "antd";
const { Title } = Typography;
const { Header, Content, Footer, Sider } = Layout;

const Hostels = () => {

  const [hrooms, sethRooms] = useState([])
  const [selectedOpt, selectOpt] = useState([])
 
const [opt,setOpt]= useState([])
  useEffect(() => {
    // declare the data fetching function
    fetch("http://localhost:8080/HostelAllocation-1.0-SNAPSHOT/api/hostel/getHostel")
        .then(response => response.json())
        .then((data) => {
            setOpt(data);
            console.log(data);  
        })
}, [])
  return (
    <Layout style={{ minHeight: "100vh", display: 'flex', justifyContent: 'center', textAlign: 'center', backgroundImage: "url(./iiitb.png)", backgroundRepeat: 'no-repeat' }}>
      <Content>
        <div>
          <Row justify="center" align="bottom">
            <Title className="center_title" level={3} style={{ marginTop: '100px', fontSize: '50px' }}>
              Filter on Hostel
            </Title>
            <Row justify="center">
              {opt.map((n, index) => (
                <button key={index} onClick ={()=>{
                  selectOpt(n)
                  fetch(`http://localhost:8080/HostelAllocation-1.0-SNAPSHOT/api/hostel/filterhname/${n}`).then(response => response.json())
                  .then((data) => {
                      sethRooms(data);
                      console.log(data);  
                  })
                }}>
                  {n}
                  
                </button>))}
            </Row>
            
          </Row>
          <table justify="center" align="center">
            <tr>
              <th>
                Hostel Id
              </th>
              <th>
                Hostel Name
              </th>
              <th>
                Floor
              </th>
              <th>
                Room Number
              </th>
              {/* <th>
                Student Name
              </th> */}
            </tr>
            {hrooms.map((item, index) => (
              <tr key={index}>
                <td>{item.hostelId}</td>
                <td>{item.hostelName}</td>
                <td>{item.floor}</td>
                <td>{item.roomNumber}</td>
                <td>{item.studentHostelFk}</td>
                <td>{item && item.studHostelFk && item.studHostelFk.fname}</td>
              </tr>
            ))}
          </table>
        </div>
      </Content>
    </Layout>
  );
}

export default Hostels;