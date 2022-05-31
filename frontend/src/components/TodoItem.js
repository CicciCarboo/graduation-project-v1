import "./../styles/TodoItem.css";
import CustomCheckbox from "./CustomCheckbox";

const TodoItem = ({index, task, resetIsChecked, setResetIsChecked}) => {

    // console.log("From TodoItem.js: tasks: ",task);
    return (
        <div className="todo-item__container" >
            <div className="todo-item__wrapper">
                <CustomCheckbox id={`checkbox_${index}`} task={task} resetIsChecked={resetIsChecked} setResetIsChecked={setResetIsChecked}/>
            </div>

        </div>
);
};

export default TodoItem;