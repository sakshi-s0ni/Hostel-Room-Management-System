import Allocate from "../services/allocate";
import { useEffect, useState } from "react"
import 'antd/dist/reset.css';
import {
  Row,
  Typography,
  Layout,
} from "antd";
const { Title } = Typography;
const { Header, Content, Footer, Sider } = Layout;


const Arooms = () => {

  const [arooms, setaRooms] = useState([])
  const allocateR = async () => {
    try {
      // Call payBill() at the backend 
      const response = await Allocate.allocateR()
      return response;
    }
    catch (exception) {
      // notificationHandler(`Failed to get the "${hostelObject.description}" room info`, 'error')
    }
  }

  useEffect(() => {
    // declare the data fetching function
    const fetchData = async () => {
      const data = await allocateR();
      setaRooms(data);
      console.log(data);
    }
  
    // call the function
    fetchData()
      // make sure to catch any error
      .catch(console.error);
  }, [])

  
  return (
    <Layout style={{ minHeight: "100vh", display: 'flex', justifyContent: 'center', textAlign: 'center', backgroundImage: "url(./iiitb.png)", backgroundRepeat: 'no-repeat' }}>
      <Content>
        <div>
          <Row justify="center" align="bottom">
            <Title className="center_title" level={3} style={{ marginTop: '100px', fontSize: '50px' }}>
              Available Rooms
            </Title>
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
            </tr>
            {arooms.map((item, index) => (
              <tr key={index}>
                <td>{item.hostelId}</td>
                <td>{item.hostelName}</td>
                <td>{item.floor}</td>
                <td>{item.roomNumber}</td>
                {/* <td>{item.studentHostelFk}</td> */}
              </tr>
            ))}
          </table>
        </div>
      </Content>
    </Layout>
  );
}

export default Arooms;