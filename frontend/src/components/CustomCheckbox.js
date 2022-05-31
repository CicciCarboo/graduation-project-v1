import React, {useEffect, useState} from 'react';

const CustomCheckbox = ({id, task, resetIsChecked, setResetIsChecked}) => { // id=`checkbox_${index}`

    const [starColor, setStarColor] = useState("secondary");
    const [backgroundColor, setBackgroundColor] = useState("warning");
    const [percentage, setPercentage] = useState("10");
    const [borderColor, setBorderColor] = useState("warning");
    const [isChecked, setIsChecked] = useState(false);

    const resetStar = () =>{
        setStarColor("secondary");
        setBackgroundColor("warning");
        setBorderColor("warning");
        setPercentage("10");
        setIsChecked(false);
        // console.log("Un-clicked star.");
    }

    const handleChange = () => {

        if (isChecked) {
            resetStar()
        } else {
            setStarColor("warning");
            setBackgroundColor("success");
            setBorderColor("success");
            setPercentage("50");
            setIsChecked(true);
            // console.log("Star has been clicked!");
        }
    }

    useEffect(() => {
        // console.log("From resetCheckedStates useEffect");

        // this part only runs if star is checked, therefore no eternal loop.
        if(isChecked){
            resetStar();
            setResetIsChecked(false);
            // console.log("just ran 'resetStar()' for %s, should be blank now", task.name)
        }
    }, [resetIsChecked])

    return (
        <div
            className={`custom-checkbox bg-${backgroundColor} bg-opacity-${percentage} border border-4 rounded border-${borderColor} p-2`}>
            <input type="checkbox" checked={isChecked} id={id} name={id} onChange={handleChange}
                   value={task.usageType}/>
            <label className="d-flex justify-content-around" htmlFor={id}>
                <div className="star__container d-flex align-content-center flex-wrap">
                    <div className="star__wrapper">
                        <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor"
                             className={`star bi bi-star-fill text-${starColor}`} viewBox="0 0 16 16" aria-label="star">
                            <path
                                d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                        </svg>
                    </div>
                </div>
                <div className="todo__container d-flex align-content-center flex-wrap">
                    <div className="todo__wrapper">
                        <p className="todo__paragraph m-0 d-flex flex-wrap">{task.name}</p>
                    </div>
                </div>
                <div className="image__container">
                    <div className="image__wrapper">
                        <img src={task.imageUrl} className="task__image img-thumbnail" alt={task.imageAltText}/>
                    </div>
                </div>
            </label>
        </div>
    );
};

export default CustomCheckbox;