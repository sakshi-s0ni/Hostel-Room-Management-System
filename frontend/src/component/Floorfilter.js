
import { useEffect, useState } from "react"
import 'antd/dist/reset.css';
import {
  Row,
  Typography,
  Layout,
} from "antd";
const { Title } = Typography;
const { Header, Content, Footer, Sider } = Layout;


const Floors = () => {

  const [flr, setFlr] = useState([])
  const [selectedOpt, selectOpt] = useState([])
 
const [opt,setOpt]= useState([])
  useEffect(() => {
    // declare the data fetching function
    fetch("http://localhost:8080/HostelAllocation-1.0-SNAPSHOT/api/hostel/getFloor")
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
              Filter by Floors
            </Title>
            {opt.map((n, index) =>(
              <button key={index} onClick ={async()=>{
                selectOpt(n);
                //console.log(n)
                await fetch(`http://localhost:8080/HostelAllocation-1.0-SNAPSHOT/api/hostel/filterfloors/${n}`).then(response => response.json())
                .then((data) => {
                    setFlr(data);
                    console.log(data);  
                })
              }}>
                {n}
                
              </button>))}
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
              <th>
                Student
              </th>
            </tr>
            {flr.map((item, index) => (
              <tr key={index}>
                <td>{item.hostelId}</td>
                <td>{item.hostelName}</td>
                <td>{item.floor}</td>
                <td>{item.roomNumber}</td>
                <td>{item && item.studHostelFk && item.studHostelFk.fname}</td>
              </tr>
            ))}
          </table>
        </div>
      </Content>
    </Layout>
  );
}

export default Floors;