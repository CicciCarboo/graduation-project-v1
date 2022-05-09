import TodoItem from "./TodoItem";
import useFetch from "./useFetch";
import {useEffect, useState} from "react";
import axios from "axios";


const TodoList = () => {

    const [tasks, setTasks] = useState([]);
    const [loadingStatus, setLoadingStatus] = useState(false);
    const todoArray = [{imageUrl:"/images/eatBreakfast.png",
        usageType: "EATBREAKFAST", name: "Pictogram Eat breakfast", imageAltText: "Breakfast on table", message: "Eat breakfast"}];

    //from GeeksForGeeks
//    This is the original useFetch hook from GeeksForGeeks, but it doesn't work, because the variable/object "data" can not be recognised in the JSX when called as such: console.log(data).
//    The reason beeing: GeeksForGeeks called the field by the wrong name, they should have called it by "dataInfo".
    const { data, loading, error, refetch } = useFetch(
        "http://localhost:8080/api/v1/images");


    console.log("loading: ", loading)
    console.log("error: ", error)
    /*{console.log("refetch: ", refetch)} Triggers too many rerenderings.*/
    console.log("data: ", data)
    // console.log("data: ", dataInfo[2].name) Does not work during loading, Can only load after data state is set the first time.

    // const taskArray = data;
    let banan = {name: "empty"};
    // New code from 2022-05-09
    // TODO fix useEffect, it runs too early

    // Template
    // useEffect(() => {
    //     setTimeout(() => {
    //         setCount((count) => count + 1);
    //     }, 1000);
    // });

    useEffect(()=>{

        (async () => {
            try{
                const result = await axios.get(
                    "http://localhost:8080/api/v1/images"
                )
                console.log("result.data from fetch: ", result.data);
                setTasks(result.data);
            }catch(error){
                console.error(error);
            }
        })()

    }, [])

    console.log("current state of 'tasks'-array: ", tasks);


    return (
        <div className="todo-list__container list-group">
            {/*{loading ? <p>Loading....</p> : (*/}
            {/*    <ul>*/}
            {/*        Ready to display! try useFetch in an useEffect, otherwise problems with loading!*/}
            {/*        /!*{taskArray.map((task, index)=><TodoItem key={index} task={task}/>)}*!/*/}

            {/*    </ul>*/}
            {/*)*/}
            {/*}*/}
            {/*<ul className="todo-ul p-0">*/}
            {/*    {todoArray.map((task,index)=><TodoItem key={index} task={task}/>)}*/}
            {/*</ul>*/}
            <ul className="todo-ul p-0">
                {tasks.map((task,index)=><TodoItem key={index} task={task}/>)}
            </ul>

        </div>
    );
};

export default TodoList;