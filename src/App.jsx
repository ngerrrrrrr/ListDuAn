import "./App.css";
import EmployeeComponent from "./components/EmployeeComponent";
import FooterComponents from "./components/FooterComponents";
import HeaderComponents from "./components/HeaderComponents";
import ListEmployeeComponents from "./Components/ListEmployeeComponents";
import { BrowserRouter, Route, Routes } from "react-router-dom";

function App() {
  return (
    <>
      <BrowserRouter>
        <HeaderComponents />
        <Routes>
          {/* //http://localhost:3000/ */}
          <Route path="/" element={<ListEmployeeComponents />}></Route>

          {/* //http://localhost:3000/employees */}
          <Route path="/employees" element={<ListEmployeeComponents />}></Route>

          {/* //http://localhost:3000/add-employee */}
          <Route path="/add-employee" element={<EmployeeComponent />}></Route>

          {/* //http://localhost:3000/edit-employee/1 */}
          <Route
            path="/edit-employee/:id"
            element={<EmployeeComponent />}
          ></Route>
        </Routes>
        <FooterComponents />
      </BrowserRouter>
    </>
  );
}

export default App;
