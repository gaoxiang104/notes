import './App.css';
import { useRoutes } from 'react-router-dom'
import Home from './screens/home/Home';
import Clock from './screens/state/Clock';
import Layout from './screens/layout/Layout';


function App() {
  let element = useRoutes([
    {
      path: "/", element: <Layout />,
      children: [
        { index: true, element: <Home /> },
        { path: 'state/clock', element: <Clock /> }
      ]
    }
  ]);
  return element;
}

export default App;
