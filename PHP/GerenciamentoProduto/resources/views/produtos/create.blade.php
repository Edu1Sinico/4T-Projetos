<!-- Puxa as informações de Layout -->
@extends('layouts.master')

<!-- Mostra onde começa o conteúdo do site -->
@section('content')
<div class="container">
    <h1 class="my-4">Criar Produto</h1>

    <!-- Verifica se existe algum erro e exibe a mensagem -->
    @if ($errors->any())
        <div class="alert alert-danger">
            <strong>Oops!</strong> Houve alguns problemas com sua entrada.<br><br>
            <ul>
                <!-- Verifica todos os erros e exibe na tela -->
                @foreach ($errors->all() as $error)
                    <li>{{ $error }}</li>
                @endforeach
            </ul>
        </div>
    @endif

    <!-- Puxa o método de criação -->
    <form action="{{ route('produtos.store') }}" method="POST">
        @csrf

        <div class="form-group">
            <label for="nome">Nome:</label>
            <input type="text" name="nome" class="form-control" placeholder="Nome">
        </div>

        <div class="form-group">
            <label for="descricao">Descrição:</label>
            <textarea name="descricao" class="form-control" placeholder="Descrição"></textarea>
        </div>

        <div class="form-group">
            <label for="preco">Preço:</label>
            <input type="text" name="preco" class="form-control" placeholder="Preço">
        </div>

        <button type="submit" class="btn btn-primary">Enviar</button>
    </form>
</div>
