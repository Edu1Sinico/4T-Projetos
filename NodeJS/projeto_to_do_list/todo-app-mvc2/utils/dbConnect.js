import mongoose from "mongoose";

const databaseUrl = process.env.DATABASE_URL;

if (!databaseUrl) {
    throw new Error("Database não listado no .env.local");
}

const connectMongo = async () => {
    // Se a conexão for maior que zero, significa que o usuário já está conectado ao banco de dados
    if (mongoose.connection.readyState > 0) {
        return;
    } else {
        mongoose.connect(databaseUrl)
            .then(() => console.log("MongoDB Conectado"))
            .catch(() => console.error(err));
    }
}

export default connectMongo;