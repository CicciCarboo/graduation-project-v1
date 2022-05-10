import TodoItem from "./TodoItem";
import {useEffect, useState} from "react";
import axios from "axios";

import "./../styles/TodoList.css";


const TodoList = () => {

    const [tasks, setTasks] = useState([]);
    const [loading, setLoading] = useState(false);

    // Fetching data from backend
    useEffect(() => {
        setLoading(true);
        (async () => {
            try {
                const result = await axios.get(
                    "http://localhost:8080/api/v1/images"
                )
                console.log("result.data from useEffect for fetch: ", result.data);
                setTasks(result.data);
                setLoading(false);
            } catch (error) {
                console.error(error);
            }
        })()

    }, [])

    console.log("current state of 'tasks'-array: ", tasks);


    return (
        <div className="todo-list__container d-flex align-items-center list-group">
            <div className="todo-list__wrapper rounded border border-warning border-3">
                <div className="todo-list list-group">
                    {loading ? <p>Loading....</p> : (
                        <ul className="todo-ul p-0">
                            {tasks.map((task, index) => <TodoItem key={index} index={index} task={task}/>)}
                        </ul>
                    )
                    }
                </div>
            </div>
        </div>
    );
};

export default TodoList;