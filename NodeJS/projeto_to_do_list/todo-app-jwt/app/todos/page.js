'use client';


import { useEffect, useState } from 'react';
import { useRouter } from 'next/navigation';


export default function TodoPage() {
    const [todos, setTodos] = useState([]);
    const [newTodo, setNewTodo] = useState('');
    const router = useRouter();


    useEffect(() => {
        const fetchTodos = async () => {
            const token = localStorage.getItem('token');
            if (!token) {
                router.push('/login'); // Redireciona para login se o usuário não estiver autenticado
                return;
            }


            const response = await fetch('/api/todos', {
                headers: {
                    Authorization: `Bearer ${token}`, // Envia o token no header da requisição
                },
            });


            if (response.ok) {
                const data = await response.json();
                setTodos(data.todos);
            } else {
                router.push('/login'); // Redireciona para login se houver erro
            }
        };


        fetchTodos();
    }, [router]);


    const addTodo = async () => {
        const token = localStorage.getItem('token');
        const response = await fetch('/api/todos', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                Authorization: `Bearer ${token}`,
            },
            body: JSON.stringify({ title: newTodo }),
        });


        const data = await response.json();
        setTodos([...todos, data.todo]);
        setNewTodo('');
    };


    const deleteTodo = async (id) => {
        const token = localStorage.getItem('token');
        await fetch(`/api/todos?id=${id}`, {
            method: 'DELETE',
            headers: {
                Authorization: `Bearer ${token}`,
            },
        });


        setTodos(todos.filter((todo) => todo._id !== id));
    };


    return (
        <div>
            <h1>To-Do List</h1>
            <input
                type="text"
                value={newTodo}
                onChange={(e) => setNewTodo(e.target.value)}
                placeholder="Nova tarefa"
            />
            <button onClick={addTodo}>Adicionar Tarefa</button>
            <ul>
                {todos.map((todo) => (
                    <li key={todo._id}>
                        {todo.title}
                        <button onClick={() => deleteTodo(todo._id)}>Excluir</button>
                    </li>
                ))}
            </ul>
        </div>
    );
}
