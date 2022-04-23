import React from 'react';
import TodoItem from "./TodoItem";

const TodoList = () => {

    const todoArray = ["Eat breakfast", "Brush teeth", "Get dressed", "Go to school"];



    return (
        <div className="todo-list__container list-group">
            Hej från Listhållaren.
            Här under skapas vår lista med morgonuppgifter.
            <ul className="todo-ul p-0">
                {todoArray.map((todo)=><TodoItem todo={todo}/>)}
            </ul>


        </div>
    );
};

export default TodoList;