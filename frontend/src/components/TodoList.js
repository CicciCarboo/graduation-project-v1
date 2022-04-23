import React from 'react';
import TodoItem from "./TodoItem";
// import brushHair from "./../images/brushHair.png";


const TodoList = () => {

    const todoArray = [{imageUrl:"/images/eatBreakfast.png",
        todo: "Eat breakfast"}];



    return (
        <div className="todo-list__container list-group">
            <ul className="todo-ul p-0">
                {todoArray.map((todo)=><TodoItem todo={todo}/>)}
            </ul>


        </div>
    );
};

export default TodoList;