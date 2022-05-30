import './App.css';

import TodoList from "./components/TodoList";
import {useState} from "react";

function App() {

    // state to change checked
    const [resetIsChecked, setResetIsChecked] = useState(false);
    // when new ListItem is checked, set resetBox to false

    const handleResetChange = () => {

        if(resetIsChecked){
            setResetIsChecked(false);
        }else {
            setResetIsChecked(true);
        }
        console.log("Reset-checkbox status: ", resetIsChecked);
    }

    return (
        <div className="App container bg-warning bg-opacity-10">
            <div className="headings_container">
                <div className="headings_wrapper pt-4">
                    <h1 className="fw-semibold fs-4">Ny startar vi dagen.</h1>
                    <h2 className="fw-bold fs-2">Let's GO!</h2>
                </div>
                <input id="reset-todo-items_checkbox" type="checkbox" checked={resetIsChecked} onChange={handleResetChange}/>
                <label className="d-flex justify-content-around" htmlFor="reset-todo-items_checkbox">Återställ listan</label>
            </div>
            <TodoList resetCheckedState={resetIsChecked}/>
            <div className="source_div pt-4">
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
