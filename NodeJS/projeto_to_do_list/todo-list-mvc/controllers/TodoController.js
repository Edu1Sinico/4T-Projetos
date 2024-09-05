import Todo from '@/models/Todo';
import connectMongo from '@/utils/mongodb';

// Métodos para pegar todos os To-do

// Get
export const getTodos = async () => {
    await connectMongo;
    return await Todo.find({});
};

// Create
export const createTodos = async (data) => {
    await connectMongo();
    return await Todo.create(data);
};

// Update
export const updateTodo = async (id, data) => {
  await connectMongo();
  return await Todo.findByIdAndUpdate(id, data, {
    new: true,
    runValidators: true,
  });
};

// Delete
export const deleteTodo = async (id) => {
  await connectMongo();
  return await Todo.deleteOne({ _id: id });
};
