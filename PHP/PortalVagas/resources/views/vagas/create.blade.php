@extends('layout.app')

@section('content')
    <div class="container">
        <h1 class="my-4">Criar Vaga</h1>
        @if ($errors->any())
            <div class="alert alert-danger">
                <strong>Oops!</strong> Houve alguns problemas com sua entrada.<br><br>
                <ul>
                    @foreach ($errors->all() as $error)
                        <li>{{ $error }}</li>
                    @endforeach
                </ul>
            </div>
            <br>
        @endif
        <form action="{{ route('vagas.store') }}" method="POST">
            @csrf
            <div class="form-group">
                <label for="nome">Título:</label>
                <input type="text" name="titulo" class="form-control" placeholder="Título">
            </div>
            <br>
            <div class="form-group">
                <label for="descricao">Descrição:</label>
                <textarea name="descricao" class="form-control" placeholder="Descrição"></textarea>
            </div>
            <br>
            <div class="form-group">
                <label for="localizacao">Localização:</label>
                <input type="text" name="localizacao" class="form-control" placeholder="Localização">
            </div>
            <br>
            <div class="form-group">
                <label for="salario">Salário:</label>
                <input type="text" name="salario" class="form-control" placeholder="Salário">
            </div>
            <br>
            <div class="form-group">
                <label for="empresa">Empresa:</label>
                @if (Auth::user()->nome_empresa != null)
                    <input type="text" name="empresa" class="form-control" placeholder="Empresa" value="{{Auth::user()->nome_empresa}}" readonly>
                @else
                    <input type="text" name="empresa" class="form-control" placeholder="Empresa" value="">
                @endif
            </div>
            <br>
            <div align="center" class="form-group">
                <button type="submit" class="btn btn-primary">Enviar</button>
            </div>
        </form>
    </div>
@endsection
