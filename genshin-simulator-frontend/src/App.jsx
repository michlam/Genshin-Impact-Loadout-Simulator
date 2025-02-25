import './App.css'
import { BrowserRouter, createBrowserRouter, createRoutesFromElements, Route, RouterProvider, Routes } from 'react-router-dom'
import Layout from './components/Layout.jsx'
import Login, {action as loginAction} from './pages/Login.jsx'
import SignUp, {action as signUpAction} from './pages/SignUp.jsx'
import NotFound from './pages/NotFound.jsx'
import Landing from './pages/Landing'
import Teams, {loader as teamsLoader} from './pages/Teams'
import Characters, {loader as charactersLoader} from './pages/Characters'


function App() {
  const router = createBrowserRouter(createRoutesFromElements(
    <Route path='/' element={<Layout />}>
      <Route index element={<Landing />} />
      <Route path="login" action={loginAction} element={<Login />} />
      <Route path="signUp" action={signUpAction} element={<SignUp />} />

      <Route path="teams" loader={teamsLoader} element={<Teams />} />
      <Route path="characters" loader={charactersLoader} element={<Characters />} />

      <Route path="*" element={<NotFound />} />
    </Route>

  ))

  return (
    <RouterProvider router={router} />
  )
}

export default App
