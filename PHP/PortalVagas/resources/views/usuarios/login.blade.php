@extends('layout.app')


@section('content')
<div class="container">
    <h1>Login</h1>
    <form method="POST" action="{{ route('usuarios.login') }}">
        @csrf


        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" name="email" placeholder="Insira o seu Email" class="form-control" required autofocus>
        </div>
        <br>
        <div class="form-group">
            <label for="password">Senha</label>
            <input type="password" name="password" placeholder="Insira sua senha" class="form-control" required>
        </div>
        <br>
        <div align="center" class="form-group">
            <button type="submit" class="btn btn-primary">Entrar</button>
        </div>
    </form>
</div>
@endsection
