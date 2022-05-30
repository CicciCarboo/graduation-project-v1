import "./../styles/TodoItem.css";
import CustomCheckbox from "./CustomCheckbox";

const TodoItem = (props) => {

    console.log("From TodoItem.js: props.tasks: ",props.task);
    return (
        <div className="todo-item__container" >
            <div className="todo-item__wrapper">
                <CustomCheckbox id={`checkbox_${props.index}`} task={props.task} resetCheckedState={props.resetCheckedState}/>
            </div>

        </div>
);
};

export default TodoItem;