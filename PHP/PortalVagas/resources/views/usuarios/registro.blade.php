@extends('layout.app')

@section('content')
{{-- formulario --}}
<div class="container">
    <h1>Registrar-se</h1>
    <form method="POST" action="{{ route('usuarios.registro') }}">
        @csrf

        <div class="form-group">
            <label for="nome">Nome</label>
            <input type="text" name="nome" class="form-control" required>
        </div>
        <br>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" name="email" class="form-control" required>
        </div>
        <br>
        <div class="form-group">
            <label for="password">Senha</label>
            <input type="password" min="8" name="password" class="form-control" required>
        </div>
        <br>
        <div class="form-group">
            <label for="password_confirmation">Confirme a Senha</label>
            <input type="password" min="8" name="password_confirmation" class="form-control" required>
        </div>
        <br>
        <div align="center" class="form-group">
            <button type="submit" class="btn btn-primary">Registrar-se</button>
        </div>
    </form>
</div>


@endsection
