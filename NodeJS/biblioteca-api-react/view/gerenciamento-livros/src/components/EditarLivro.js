import React, { useState, useEffect } from 'react'; // Importa o React e os hooks useState e useEffect
import axios from 'axios'; // Importa a biblioteca axios para fazer requisições HTTP
import { useParams, useNavigate } from 'react-router-dom'; // Importa useParams para obter parâmetros da URL e useNavigate para navegação programática


function EditarLivro() {
    // Obtém o parâmetro 'id' da URL usando useParams. Este 'id' é usado para buscar e atualizar o livro específico.
    const { id } = useParams();

    // Define os estados para os campos do formulário. Inicialmente, todos os valores são strings vazias.
    const [titulo, setTitulo] = useState('');
    const [autor, setAutor] = useState('');
    const [ano, setAno] = useState('');
    const [genero, setGenero] = useState('');


    // Hook useNavigate é usado para redirecionar programaticamente após a atualização do livro.
    const navigate = useNavigate();


    // useEffect é usado para buscar os dados do livro quando o componente é montado ou o 'id' muda.
    useEffect(() => {
        // Faz uma requisição GET para a API para buscar os detalhes do livro com o 'id' especificado.
        axios.get(`http://localhost:5000/livros/${id}`)
            .then(response => {
                // Atualiza os estados com os dados do livro obtidos da API.
                setTitulo(response.data.titulo);
                setAutor(response.data.autor);
                setAno(response.data.ano);
                setGenero(response.data.genero);
            })
            .catch(error => console.error('Erro ao buscar o livro:', error)); // Lida com erros durante a requisição
    }, [id]); // O efeito será executado sempre que o 'id' mudar


    // Função para atualizar o livro
    const atualizarLivro = (e) => {
        e.preventDefault(); // Previne o comportamento padrão do formulário, que é recarregar a página


        // Faz uma requisição PUT para a API para atualizar o livro com o 'id' especificado com os dados do formulário.
        axios.put(`http://localhost:5000/livros/${id}`, { titulo, autor, ano, genero })
            .then(() => navigate('/')) // Se a requisição for bem-sucedida, navega para a página principal ('/')
            .catch(error => console.error('Erro ao atualizar livro:', error)); // Lida com qualquer erro que ocorra durante a requisição
    };


    return (
        <form onSubmit={atualizarLivro}> {/* Define que a função atualizarLivro será chamada quando o formulário for enviado */}
            <h1>Editar Livro</h1> {/* Título da página */}

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
            <button type="submit">Atualizar</button>
        </form>
    );
}


export default EditarLivro; // Exporta o componente EditarLivro para que possa ser usado em outras partes da aplicação