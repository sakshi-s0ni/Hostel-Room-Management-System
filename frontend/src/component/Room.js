import HostelService from '../services/roomlist';
import { useEffect, useState } from "react"
import 'antd/dist/reset.css';
//import { useNavigate } from "react-router-dom";
import {
  Row,
  Typography,
  Layout,
  message,
  Modal,
} from "antd";
import axios from "axios";
const { Title } = Typography;
const { Header, Content } = Layout;


const Room = () => {
  //const navigate = useNavigate();
  const loggedInUser = window.localStorage.getItem('loggedInUser')
  useEffect(() => {
    if (!loggedInUser) {
        window.location.href = "http://localhost:3000/home";
    }
})
  const [rooms, setRooms] = useState([])
  const getR = async () => {
    try {
      
      const response = await HostelService.getR()
      return response;
    }
    catch (exception) {

      // notificationHandler(`Failed to get the "${hostelObject.description}" room info`, 'error')
    }
  }
  const [alloc, setalRooms] = useState([])
  const [stid , setStid] = useState([])
  const update = async (hostelId,studId) => {
    try {
      console.log(hostelId)
      console.log(studId)
      axios.put(`http://localhost:8080/HostelAllocation-1.0-SNAPSHOT/api/hostel/allocate/${hostelId}/${studId}`)
        .then(response => response.json())
        .then((data) => {
            setalRooms(data);
            console.log(data);  
        })
    }
    catch (exception) {
      console.log(exception);
    }
  }

  useEffect(() => {
    // declare the data fetching function
    const fetchData = async (hostelId,studId) => {
      const data = await update(hostelId,studId);
      setalRooms(data);
      console.log(data);
    }
  
    // call the function
    fetchData()
      // make sure to catch any error
      .catch(console.error);
  }, [])

  useEffect(() => {
    // declare the data fetching function
    const fetchData = async () => {
      const data = await getR();
      setRooms(data);
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
              Rooms List
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
              <th>
                Student Name
              </th>
              <th>
                Id for Allocate/Modify 
              </th>
            </tr>
            {rooms.map((item, index) => (
              <tr key={index}>
                <td>{item.hostelId}</td>
                <td>{item.hostelName}</td>
                <td>{item.floor}</td>
                <td>{item.roomNumber}</td>
                <td>{item && item.studHostelFk && item.studHostelFk.fname}</td>
                <td><input type="number" id = "studid" onChange={event => {//console.log(event.target.value); 
                setStid(event.target.value)}}></input></td>
                <td><button type="button" onClick={(e)=>{
                  update(item.hostelId,stid)
                  }}>  Update </button></td>
                
              </tr>
            ))}
          </table>
        </div>
      </Content>
    </Layout>
  );
}

export default Room;