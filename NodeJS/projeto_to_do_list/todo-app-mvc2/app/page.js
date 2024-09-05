'use client';

import { useState, useEffect } from 'react';

export default function Home() {
  const [todos, setTodos] = useState([]);
  const [desc, setDesc] = useState([]);
  const [newTodo, setNewTodo] = useState('');
  const [newDesc, setNewDesc] = useState('');


  useEffect(() => {
    fetchTodos();
  }, []);


  const fetchTodos = async () => {
    const response = await fetch('/api/todos');
    const data = await response.json();
    setTodos(data.data);
  };


  const addTodo = async () => {
    const response = await fetch('/api/todos', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ title: newTodo, description: newDesc }),
    });
    const data = await response.json();
    setTodos([...todos, data.data]);
    setDesc([...desc, data.data]);
    setNewDesc('');
    setNewTodo('');
  };


  const deleteTodo = async (id) => {
    await fetch(`/api/todos/${id}`, {
      method: 'DELETE',
    });
    setTodos(todos.filter((todo) => todo._id !== id));
  };

  const updateTodo = async (id, description, status) => {

  };


  return (
    <div>
      <h1>To-Do List</h1>
      <input
        type="text"
        value={newTodo}
        onChange={(e) => setNewTodo(e.target.value)}
      />

      <input
        type="text"
        value={newDesc}
        onChange={(e) => setNewDesc(e.target.value)}
      />

      <button onClick={addTodo}>Adicionar Tarefa</button>
      <ul>
        {todos.map((todo) => (
          <li key={todo._id}>
            {todo.title} - {todo.description} - {todo.status}
            <button onClick={() => deleteTodo(todo._id)}>Excluir</button>
          </li>
        ))}
      </ul>
    </div>
  );
}