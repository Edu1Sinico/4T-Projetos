import React, { useState } from 'react'; // Importa o React e o hook useState
import axios from 'axios'; // Importa a biblioteca axios para fazer requisições HTTP
import { useNavigate } from 'react-router-dom'; // Importa o hook useNavigate para navegação programática


function NovoLivro() {
    // Define os estados para os campos do formulário. Inicialmente, todos os valores são strings vazias.
    const [titulo, setTitulo] = useState('');
    const [autor, setAutor] = useState('');
    const [ano, setAno] = useState('');
    const [genero, setGenero] = useState('');


    // Hook useNavigate é usado para redirecionar programaticamente após o envio do formulário.
    const navigate = useNavigate();


    // Função para adicionar um novo livro
    const adicionarLivro = (e) => {
        e.preventDefault(); // Previne o comportamento padrão do formulário, que é recarregar a página


        // Faz uma requisição POST para a API para adicionar um novo livro com os dados do formulário
        axios.post('http://localhost:5000/livros', { titulo, autor, ano, genero })
            .then(() => {
                // Se a requisição for bem-sucedida, navega para a página principal ('/')
                navigate('/');
            })
            .catch(error => console.error('Erro ao adicionar livro:', error)); // Lida com qualquer erro que ocorra durante a requisição
    };


    return (
        <form onSubmit={adicionarLivro}> {/* Define que a função adicionarLivro será chamada quando o formulário for enviado */}
            <h1>Novo Livro</h1> {/* Título da página */}

            {/* Campo para o título do livro */}
            <input
                type="text"
                value={titulo}
                onChange={e => setTitulo(e.target.value)} // Atualiza o estado 'titulo' quando o valor do campo muda
                placeholder="Título"
                required // Torna este campo obrigatório
            />

            {/* Campo para o autor do livro */}
            <input
                type="text"
                value={autor}
                onChange={e => setAutor(e.target.value)} // Atualiza o estado 'autor' quando o valor do campo muda
                placeholder="Autor"
                required // Torna este campo obrigatório
            />

            {/* Campo para o ano de publicação do livro */}
            <input
                type="number"
                value={ano}
                onChange={e => setAno(e.target.value)} // Atualiza o estado 'ano' quando o valor do campo muda
                placeholder="Ano de Publicação"
                required // Torna este campo obrigatório
            />

            {/* Campo para o gênero do livro */}
            <input
                type="text"
                value={genero}
                onChange={e => setGenero(e.target.value)} // Atualiza o estado 'genero' quando o valor do campo muda
                placeholder="Gênero"
                required // Torna este campo obrigatório
            />

            {/* Botão para enviar o formulário */}
            <button type="submit">Adicionar</button>
        </form>
    );
}


export default NovoLivro; // Exporta o componente NovoLivro para que possa ser usado em outras partes da aplicação
