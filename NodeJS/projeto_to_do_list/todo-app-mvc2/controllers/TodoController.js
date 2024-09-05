import todo from "@/models/Todo";
import connectMongo from "@/utils/dbConnect";
import closeConnectionMongo from '@/utils/dbCloseConnection'

// CRUD

// Get
export const getTodos = async () => {
    await connectMongo;
    return await todo.find({}) &&
        await closeConnectionMongo();
};

// Create
export const createTodos = async (data) => {
    await connectMongo();
    return await Todo.create(data) &&
        await closeConnectionMongo();
};

// Update
export const updateTodo = async (id, data) => {
    await connectMongo();
    return await Todo.findByIdAndUpdate(id, data, {
        new: true,
        runValidators: true,
    }) &&
        await closeConnectionMongo();
};

// Delete
export const deleteTodo = async (id) => {
    await connectMongo();
    return await Todo.deleteOne({ _id: id }) &&
        await closeConnectionMongo();
};
