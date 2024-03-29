import './App.css';
import { useRoutes } from 'react-router-dom'
import Home from './screens/home/Home';
import Clock from './screens/state/Clock';
import Layout from './screens/layout/Layout';
import Toggle from './screens/handling-events/Toggle';
import NameFormFun from './screens/nameFormFun/NameFormFun';


function App() {
  let element = useRoutes([
    {
      path: "/", element: <Layout />,
      children: [
        { index: true, element: <Home /> },
        { path: 'state/clock', element: <Clock /> },
        { path: 'handling-event/toggle', element: <Toggle /> },
        { path: 'name-form-fun/NameFormFun', element: <NameFormFun /> },
      ]
    }
  ]);
  return element;
}

export default App;
