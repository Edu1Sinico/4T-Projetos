import mongoose from "mongoose";

const closeConnectionMongo = async () => {
    if (mongoose.connection.readyState > 0) {
        mongoose.disconnect;
    }
}

export default closeConnectionMongo;
