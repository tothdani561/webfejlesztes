import { BrowserRouter, Routes, Route } from 'react-router-dom';
import HomePage from './pages/HomePage/HomePage';
import RegisterPage from './pages/RegisterPage/Register';
import './App.css';
import ToDoCardPage from './pages/ToDoCardPage/ToDoCardPage';

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path='/register' element={<RegisterPage />} />
        <Route path='/todos' element={<ToDoCardPage />} />
      </Routes>
    </BrowserRouter>
  );  
}