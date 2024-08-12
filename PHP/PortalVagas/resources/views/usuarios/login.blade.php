@extends('layouts.app')


@section('content')
<div class="container">
    <h1>Login</h1>
    <form method="POST" action="{{ route('usuarios.login') }}">
        @csrf


        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" name="email" class="form-control" required autofocus>
        </div>
        <br>
        <div class="form-group">
            <label for="senha">Senha</label>
            <input type="password" name="senha" class="form-control" required>
        </div>
        <br>
        <div align="center" class="form-group">
            <button type="submit" class="btn btn-primary">Registrar-se</button>
        </div>
    </form>
</div>
@endsection
