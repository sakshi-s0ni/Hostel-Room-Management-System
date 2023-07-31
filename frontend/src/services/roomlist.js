import axios from 'axios'

// The API endpoint where rooms are located
const roomsurl = 'http://localhost:8080/HostelAllocation-1.0-SNAPSHOT/api/hostel/get/1';

// Gets all bills which belong to a user
const getR = async () => {
    const response = await axios.get(`${roomsurl}`)
  // The .data field would now contain the rooms of the users
  console.log(response.data);
  return response.data
}
const roomObj = { getR }

export default roomObj