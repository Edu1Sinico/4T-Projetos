import mongoose from "mongoose";

const TodoSchema = new mongoose.Schema({
    title: {
        type: String,
        required: true
    },
    description: {
        type: String,
        required: false
    },
    stutus: {
        type: String,
        enum: ["Pendente", "Em desenvolvimento", "Concluído"],
        default: "Pendente"
    }
})

const Todo = mongoose.models.Todo || mongoose.model('Todo', TodoSchema);

export default Todo;