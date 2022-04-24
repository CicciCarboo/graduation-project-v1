import React, {useEffect} from 'react';
import TodoItem from "./TodoItem";
import useFetch from "./useFetch";
import axios from "axios";


const TodoList = () => {

    const todoArray = [{imageUrl:"/images/eatBreakfast.png",
        todo: "Eat breakfast"}];

    //from GeeksForGeeks
//    This is the original useFetch hook from GeeksForGeeks, but it doesn't work, because the variable/object "data" can not be recognised in the JSX when called as such: console.log(data).
//    The reason beeing: GeeksForGeeks called the field by the wrong name, they should have called it by "dataInfo".
    const { data: dataInfo, loading, error, refetch } = useFetch(
        "http://localhost:8080/api/v1/images");

    //These are my attempts to mend this:
    // 1) This will only return an object holding: data, loading, error, refetch, where the "data" value doesn't hold any result from the API call.
    // const data = useFetch("http://localhost:8080/api/v1/images");

    // 2) This seems to work. It gives me the result of the API call, but instead the other fields of the object are undefined.
    // const {data} = useFetch("http://localhost:8080/api/v1/images");

    // // 3) Testing with destructuring assignment, it works!
    // const { data, loading, error, refetch } = useFetch(
    //     "http://localhost:8080/api/v1/images");

    // // 4) Testing with destructuring assignment, assigned to new names. This works too, but refetch triggers to manny rerenders.
    // const { data: dataInfo, loading: loadingStatus, error: errorMessage, refetch: refetchFunction } = useFetch(
    //     "http://localhost:8080/api/v1/images");


    // useEffect(() => {
    //     fetch('https://jsonplaceholder.typicode.com/todos')
    //         .then(response => response.json())
    //         .then(json => console.log(json))
    // }, []);

    // useEffect(() => {
    //     axios.get("https://jsonplaceholder.typicode.com/todos")
    //         .then((response) => console.log(response.data));
    // }, []);

    // useEffect(() => {
    //     (async () => {
    //         try {
    //             const result = await axios.get(
    //                 "http://localhost:8080/api/v1/images")
    //             console.log(result.data);
    //         } catch (error) {
    //             console.error(error);
    //         }
    //     })()
    // })



    return (
        <div className="todo-list__container list-group">
            {/*{console.log("data: ",data)}*/}
            {/*{console.log("data[3]: ", data[3])}*/}
            {console.log("loading: ", loading)}
            {console.log("error: ", error)}
            {/*{console.log("refetch: ", refetch)}*/}

            {console.log("data: ",dataInfo)}
            {/*{console.log("data[3]: ", dataInfo[3])}*/}
            {/*{console.log("loading: ", loadingStatus)}*/}
            {/*{console.log("error: ", errorMessage)}*/}
            {/*{console.log("refetch: ", refetchFunction())} Triggers too many rerenderings. */}

            {/*{console.log(data[3].name)} can not bee read during loading*/}

            <ul className="todo-ul p-0">
                {todoArray.map((todo,index)=><TodoItem key={index} todo={todo} index={index}/>)}
            </ul>

        </div>
    );
};

export default TodoList;