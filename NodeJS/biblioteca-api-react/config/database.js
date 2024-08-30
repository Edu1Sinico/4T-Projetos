const mongoose = require('mongoose'); // Importando o módulo do mongoose
require('dotenv').config(); // Importando o módulo do dotenv

mongoose.connect(process.env.DATABASE_URL) // Estabelece a conexão com o banco de dados
.then(() => console.log('Conectado ao MongoDB'))
.catch(err => console.error('Erro ao conectar ao MongoDB', err));

module.exports = mongoose;