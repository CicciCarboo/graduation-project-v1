import './App.css';
import MyDay from "./components/MyDay";
import NavigationBar from "./components/NavigationBar";
import Footer from "./components/Footer";



function App() {

    return (
        <div className="App container bg-warning bg-opacity-10">
            <NavigationBar/>
            <MyDay/>
            <Footer/>
        </div>
    );
}

export default App;
