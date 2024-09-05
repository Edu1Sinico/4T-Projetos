import todo from "@/models/Todo";
import connectMongo from "@/utils/dbConnect";

// Get
export const getTodos = async () => {
    await connectMongo();
    return await todo.find({});
};

// Create
export const createTodos = async (data) => {
    await connectMongo();
    return await todo.create(data);
};

// Update
export const updateTodo = async (id, data) => {
    await connectMongo();
    return await todo.findByIdAndUpdate(id, data, {
        new: true,
        runValidators: true,
    });
};

// Delete
export const deleteTodo = async (id) => {
    await connectMongo();
    return await todo.deleteOne({ _id: id });
};

