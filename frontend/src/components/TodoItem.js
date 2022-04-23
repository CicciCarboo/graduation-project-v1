import React from 'react';

const TodoItem = (props) => {
    return (
        <div className="todo-item__container">
            <div className="todo-item__wrapper">
                <div className="star__containter">
                    <div className="star__wrapper">***STAR!***
                        <img className="star"/>
                    </div>
                </div>
                <div className="todo__containter">
                    <div className="todo__wrapper">
                        <p className="todo__paragraph">{props.todo}</p>
                    </div>
                </div>
                <div className="image__containter">
                    <div className="image__wrapper">BILD på todo
                        <img/>
                    </div>
                </div>

            </div>

        </div>
    );
};

export default TodoItem;