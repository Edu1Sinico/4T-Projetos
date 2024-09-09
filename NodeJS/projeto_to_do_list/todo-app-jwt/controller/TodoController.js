import Todo from "@/models/Todo";
import connectMongo from "@/utils/dbConnect";

// Carregar Todos
export const getTodos = async (req) => {
    await connectMongo();
    try {
        const todos = Todo.find({ UserId: req.user.userId });
        res.json(200).json({ todos });
    } catch (error) {
        res.status(500).json({ error })
    }
}

// Criar Tarefa
export const addTodo = async (req) => {
    const { title } = req.body;
    await connectMongo();

    try {
        const newTodo = new Todo({
            title,
            UserId: req.user.userId, // Associa a tarefa ao usuário logado
        });
        await newTodo.save();
        res.status(201).json({ todo: newTodo });
    } catch (error) {
        res.status(500).json({ nessage: 'Erro ao adicionar tarefa' });
    }
}

// Atualizar Tarefa
export const updateTodo = async (req) => {
    const { id } = req.query;
    const { title } = req.body;
    await connectMongo();

    try {
        const updateTodo = await Todo.findOneAndUpdate(
            { _id: id, UserId: req.user.userId },
            { title },
            { status: true }
        );
        if (!updateTodo) return res.status(404).json({
            message: 'Tarefa não encontrada'
        });
        res.status(200).json({ todo: updateTodo });
    } catch (error) {
        req.status(500).json({ message: 'Erro ao atulizar tarefas' });
    }
}

// delete Tarefa
export const deleteTodo = async (req) => {
    const { id } = req.query;
    await connectMongo();


    try {
        const deletedTodo = await Todo.findOneAndDelete({ _id: id, UserId: req.user.userId });
        if (!deletedTodo) return res.status(404).json({ message: 'Tarefa não encontrada' });
        res.status(200).json({ message: 'Tarefa deletada com sucesso' });
    } catch (error) {
        res.status(500).json({ message: 'Erro ao deletar tarefa' });
    }
};


