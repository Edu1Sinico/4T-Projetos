<!-- Puxa as informações de Layout -->
@extends('layouts.master')

<!-- Mostra onde começa o conteúdo do site -->
@section('content')
@include('components.header')
<div class="container">
    <h1 class="my-4">Produtos</h1>

    @if ($message = Session::get('success'))
    <div class="alert alert-success">
        <p>{{ $message }}</p>
    </div>
    @endif

    <a class="btn btn-success mb-2" href="{{ route('produtos.create') }}"> Criar Novo Produto</a>

    <table class="table table-bordered">
        <tr>
            <th>No</th>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Preço</th>
            <th width="280px">Ação</th>
        </tr>
        @foreach ($produtos as $produto)
        <tr>
            <td>{{ $loop->iteration }}</td>
            <td>{{ $produto->nome }}</td>
            <td>{{ $produto->descricao }}</td>
            <td>{{ $produto->preco }}</td>
            <td>
                <!-- Redireciona para o método de exclusão --> 
                <form action="{{ route('produtos.destroy', $produto->id) }}" method="POST">
                    <a class="btn btn-info" href="{{ route('produtos.show', $produto->id) }}">Mostrar</a>
                    <a class="btn btn-primary" href="{{ route('produtos.edit', $produto->id) }}">Editar</a>

                    <!-- Evitar o tipo de ataque CSRF -->
                    @csrf
                    <!-- Chama o método DELETE -->
                    @method('DELETE')
                    <button type="submit" class="btn btn-danger">Deletar</button>
                </form>
            </td>
        </tr>
        @endforeach
    </table>
</div>
@include('components.footer')