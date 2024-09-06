import mongoose from "mongoose";

const dataBaseUrl = process.env.DATABASE_URL;

if (!dataBaseUrl) {
    throw new Error("Env não Preenchido");
}

const connectMongo = async () => {
    // Se a conexão for maior que zero, significa que o usuário já está conectado ao banco de dados
    if (mongoose.connection.readyState > 0) {
        return;
    } else {
        return await mongoose.connect(dataBaseUrl)
            .then(() => console.log("MongoDB Conectado"))
            .catch(() => console.error(err));
    }
}

export default connectMongo;