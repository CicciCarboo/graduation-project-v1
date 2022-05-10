import React from 'react';
import "./../styles/TodoItem.css";

const TodoItem = (props) => {

    // let starColor = "warning";
    let starColor = "danger";


    console.log("From TodoItem.js: props.tasks: ",props.task);
    return (
        <div className="todo-item__container">
            <div className="todo-item__wrapper">
                <label className="list-group-item d-flex justify-content-between align-items-center">
                    <input className="form-check-input me-1" type="checkbox" value={props.task.usageType}/>
                        <div className="star__container">
                            <div className="star__wrapper">
                                {/*<i className="bi bi-star-fill"></i>*/}
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     className= {`star bi bi-star-fill text-${starColor}`} viewBox="0 0 16 16">
                                    <path
                                        d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                </svg>
                            </div>
                        </div>
                        <div className="todo__container">
                            <div className="todo__wrapper">
                                <p className="todo__paragraph m-0">{props.task.message}</p>
                            </div>
                        </div>
                        <div className="image__container">
                            <div className="image__wrapper">
                                <img src={props.task.imageUrl} className="task__image img-thumbnail" alt={props.task.imageAltText}/>
                            </div>
                        </div>
                </label>
            </div>

        </div>
);
};

export default TodoItem;