import { useState } from 'react'
import './App.css'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import LoginComponent from './components/LoginComponent';
import HomeComponent from './components/HomeComponent';

function App() {

  
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path='/' element = {<HomeComponent />} />
          <Route path='/login' element = {<LoginComponent />} />
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
