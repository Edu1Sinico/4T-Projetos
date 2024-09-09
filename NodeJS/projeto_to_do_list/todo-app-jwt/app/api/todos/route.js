import { jwtmiddleware } from "@/utils/middleware";
import { getTodos, addTodo, updateTodo, deleteTodo } from "@/controller/TodoController";

// Método GET - Listar as tarefas do usuário
export async function GET(req) {
    return jwtmiddleware(async (req) => {
        await getTodos(req);
    })(req);
}

// Método POST - Adicionar tarefa do usuário
export async function POST(req) {
    return jwtmiddleware(async (req) => {
        await addTodo(req);
    })(req);
}

// Método PUT - Atualiza as tarefas do usuário
export async function PUT(req) {
    return jwtmiddleware(async (req) => {
        await updateTodo(req);
    })(req);
}

// Método DELETE - Deleta uma tarefa existente
export async function DELETE(req) {
    return jwtmiddleware(async (req) => {
        await deleteTodo(req);
    })(req);
}
