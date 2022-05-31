import React, {useState} from 'react';
import TodoList from "./TodoList";

const MyDay = () => {

    // state to change checked
    const [resetIsClicked, setResetIsClicked] = useState(false);

    const handleResetClick = () => {
        if (resetIsClicked) {
            setResetIsClicked(false);
        } else {
            setResetIsClicked(true);
        }
    }
    // console.log("After handleResetChange, resetIsClicked: ", resetIsClicked);

    return (
        <div className="my-day_container">
            <div className="headings_container">
                <div className="headings_wrapper pt-4">
                    <h1 className="fw-semibold fs-4">Ny startar vi dagen.</h1>
                    <h2 className="fw-bold fs-2">Let's GO!</h2>
                </div>
            </div>
            <TodoList resetIsChecked={resetIsClicked} setResetIsChecked={setResetIsClicked}/>
            <div className="reset-button_wrapper d-flex flex-start p-4">
                <button type="button" className="btn btn-success" onClick={handleResetClick}>Återställ listan
                </button>
            </div>
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
};

export default MyDay;