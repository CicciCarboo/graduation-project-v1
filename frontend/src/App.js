import './App.css';
import MyDay from "./components/MyDay";
import NavigationBar from "./components/NavigationBar";



function App() {

    return (
        <div className="App container bg-warning bg-opacity-10">
            <NavigationBar/>
            <MyDay/>
            <div className="source_div pt-2">
                <p className="m-0">Bildkällor: </p>
                <p className="m-0">Papunets bildbank, <a href="https://papunet.net/">www.papunet.net</a>, </p>
                <p className="m-0"> Sergio Palao / ARASAAC, Källa:
                    <a href="http://www.catedu.es/arasaac/">ARASAAC</a>, </p>
                <p className="m-0"> Sclera, Källa: <a
                    href="http://sclera.be/">Sclera</a>
                    , hämtade ca 2016</p>
            </div>
        </div>
    );
}

export default App;
