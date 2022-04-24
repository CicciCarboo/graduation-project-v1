import TodoItem from "./TodoItem";
import useFetch from "./useFetch";


const TodoList = () => {

    const todoArray = [{imageUrl:"/images/eatBreakfast.png",
        todo: "Eat breakfast"}];

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

    const taskArray = data;


    return (
        <div className="todo-list__container list-group">
            {loading ? <p>Loading....</p> : (
                <ul>
                    Ready to display! try useFetch in an useEffect, otherwise problems with loading!
                    {/*{taskArray.map((task, index)=><TodoItem key={index} task={task}/>)}*/}

                </ul>
            )
            }
            {/*<ul className="todo-ul p-0">                */}
            {/*    {todoArray.map((todo,index)=><TodoItem key={index} todo={todo} index={index}/>)}*/}
            {/*</ul>*/}

        </div>
    );
};

export default TodoList;