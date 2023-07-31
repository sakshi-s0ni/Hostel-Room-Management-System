import './App.css';
import { useState, useEffect } from 'react'
import React from "react";
import { createRoot } from "react-dom/client";
import {
  createBrowserRouter,
  RouterProvider,
  Route,
  useNavigate
} from "react-router-dom";
import ReactDOM from 'react-dom/client';
import loginService from './services/login'
import Login from './component/Login';
import Notification from './component/Notification';
import Home from './component/Home';
import Arooms from './component/Availrooms'
import Hostels from './component/Hostelfilter'
import Room from './component/Room';
import Floors from './component/Floorfilter';


const App = (props) => {
  // user state will store the logged in user object, if no login has been done yet then it will be null
  const [ user, setUser ] = useState(null)
//const navigate = useNavigate();
  // These states are used to control the notifications that show up at the top of the screen for events like 
  // login, signup, watchlist creation, etc.
  const [ notification, setNotification ] = useState(null)
  const [ notificationType, setNotificationType ] = useState(null)
  const notificationHandler = (message, type) => {
    setNotification(message)
    setNotificationType(type)

    setTimeout(() => {
      setNotificationType(null)
      setNotification(null)
    }, 3000)
  }
  // Function that handles login of users
  const handleLogin = async (credentials) => {
    console.log("in")
    try {
      
      const userObject = await loginService.login(credentials)
      setUser(userObject)
      window.localStorage.setItem('loggedInUser', JSON.stringify(userObject))
      window.location.replace("http://localhost:3000/home");
      //console.log(window.location.href);
     //navigate('/home');
     notificationHandler(`Logged in successfully as ${userObject.firstName}`, 'success')
    }
    catch (exception) {
      console.log(exception)
      notificationHandler(`Log in failed, check username and password entered`, 'error')
    }
  }

  useEffect(() => {
    const loggedInUser = window.localStorage.getItem('loggedInUser')
    console.log(loggedInUser)
    if (loggedInUser)
    setUser(JSON.parse(loggedInUser))
  }, [])

  const router = createBrowserRouter([
    {
      path: "/",
      element:<Login startLogin={handleLogin}/> ,
    },
    {
      path: "/home",
      element:<Home/> ,
    },
    {
      path: "/allroom",
      element:<Room/> ,
    },
    {
      path: "/availroom",
      element: <Arooms/>,
    },
    {
      path: "/hostelfilter",
      element: <Hostels/>,
    },
    {
      path: "/floorfilter",
      element: <Floors/>,
    },
  ]);
  props.renderRoot(<RouterProvider router={router} />)
  return (
    <div>
      {/* Header of the page */}
      <div className='text-center page-header p-2 regular-text-shadow regular-shadow'>
          <div className='display-6 font-weight-bold'>
            Room Allocation Application
          </div>
      </div>
      
      {/* Notification component that will render only when the notification state is not null */}
      <Notification notification={notification} type={notificationType} />
      {
        /* Show Login form when no login has happened */
        user === null && 
        <Login startLogin={handleLogin}/>
      }

      {
        user !== null &&
         <Home/>
      }
    </div>
  )
  
  
}
export default App;


