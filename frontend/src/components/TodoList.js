import TodoItem from "./TodoItem";
import {useEffect, useState} from "react";
import axios from "axios";


const TodoList = () => {

    const [tasks, setTasks] = useState([]);
    const [loading, setLoading] = useState(false);

    // Fetching data from backend
    useEffect(()=>{
        setLoading(true);
        (async () => {
            try{
                const result = await axios.get(
                    "http://localhost:8080/api/v1/images"
                )
                console.log("result.data from useEffect for fetch: ", result.data);
                setTasks(result.data);
                setLoading(false);
            }catch(error){
                console.error(error);
            }
        })()

    }, [])

    console.log("current state of 'tasks'-array: ", tasks);


    return (
        <div className="todo-list__container list-group">
            {loading ? <p>Loading....</p> : (
                <ul className="todo-ul p-0">
                    {tasks.map((task,index)=><TodoItem key={index} task={task}/>)}
                </ul>
            )
            }
        </div>
    );
};

export default TodoList;