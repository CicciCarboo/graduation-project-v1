import React from 'react';

const TodoItem = (props) => {
    console.log("From TodoItem.js: props.tasks: ",props.task);
    return (
        <div className="todo-item__container">
            <div className="todo-item__wrapper">
                <label className="list-group-item d-flex justify-content-between align-items-center">
                    <input className="form-check-input me-1" type="checkbox" value={props.task.usageType}/>
                        <div className="star__containter">
                            <div className="star__wrapper">***STAR!***
                                <img className="star" alt="Star acting as check-box, to be checked when task is completed."/>
                            </div>
                        </div>
                        <div className="todo__containter">
                            <div className="todo__wrapper">
                                <p className="todo__paragraph m-0">{props.task.message}</p>
                            </div>
                        </div>
                        <div className="image__containter">
                            <div className="image__wrapper">
                                <img src={props.task.imageUrl} className="img-thumbnail" alt={props.task.imageAltText}/>
                            </div>
                        </div>
                </label>
            </div>

        </div>
);
};

export default TodoItem;