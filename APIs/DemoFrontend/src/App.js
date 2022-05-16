
import './App.css';
import './STYLES/styles.css'
import { Routes, Route } from "react-router-dom"
import Home from "./components/Home"
import About from "./components/About"
import Input from "./components/Input"
import NavBar from "./components/NavBar";
import Results from "./components/Results";
import ResponseComponent from './components/Results/ResponseComponent';

function App() {
  return (
    <div className="App">
      <NavBar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="about" element={<About />} />
        <Route path="input" element={<Input />} />
        <Route path="results" element={<Results />} />
        <Route path="ResponseComponent" element={<ResponseComponent />}/>
      </Routes>
    </div>
  );
}

export default App;