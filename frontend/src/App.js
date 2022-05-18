import './App.css';

import TodoList from "./components/TodoList";

function App() {
  return (
    <div className="App container bg-warning bg-opacity-10">
      <h1>Välkommen till LetsGO!</h1>
      <h2>din digitala kom-ihåg-lista.</h2>
      <h3>Ny startar vi dagen. Let's GO!</h3>

        <TodoList/>
    </div>
  );
}

export default App;
