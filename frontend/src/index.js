import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';

const root = ReactDOM.createRoot(document.getElementById('root'));
const renderRoot = (element) => {
    root.render(element);
}
root.render(
  <React.StrictMode>
    <App renderRoot = {(element) => renderRoot(element)}/>
  </React.StrictMode>
);

