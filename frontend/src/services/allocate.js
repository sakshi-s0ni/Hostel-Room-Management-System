import axios from 'axios'

const emptyrooms = 'http://localhost:8080/HostelAllocation-1.0-SNAPSHOT/api/hostel/availrooms';

const allocateR = async () => {
    const response = await axios.get(`${emptyrooms}`)
    console.log(response.data);
    return response.data
}
const roomObj = { allocateR }

export default roomObj