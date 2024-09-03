import mongoose, { connect, mongo} from "mongoose";

const connectMongo = async () => {
    mongoose.connect(process.env.DATABASE_URL)
    .then( () => console.log("Mongo Conecatado"))
    .catch( err => console.error('Erro ao conectar ao MongoDB', err));
}