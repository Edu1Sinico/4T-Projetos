@extends('layout.app')

@section('content')
    <div class="home-title" style="border-bottom: 3px solid black; padding: 15px;">
        <h2>Dashboard - Vagas</h2>
    </div>
    <br>
    <form method="GET" action="{{ route('dashboard') }}" style="display: flex; align-items: center; justify-content: space-evenly; width: 50%">
        <input type="search" name="search" class="form-control me-2" placeholder="Pesquisar vagas..." value="{{ request('search') }}">
        <button type="submit" class="btn btn-primary">Pesquisar</button>
    </form>
    <br>
    <div class="row">
        @foreach ($vagas as $vaga)
            <div class="col-md-4">
                <div class="card">
                    <img src="/assets/img/imagem2.png" class="card-img-top" alt="{{ $vaga->titulo }}">
                    <div class="card-body">
                        <h5 class="card-title">{{ $vaga->titulo }}</h5>
                        <h6 class="card-title">{{ $vaga->empresa }}</h6>
                        <p class="card-text">{{ $vaga->descricao }}</p>
                        <p class="card-text">Localização: {{ $vaga->localizacao }}</p>
                        <p class="card-text">Salário: R$ {{ $vaga->salario }}</p>
                        <a href="{{ route('vagas.show', $vaga->id) }}" class="btn btn-primary">Ver Vaga</a>
                    </div>
                </div>
            </div>
        @endforeach
    </div>
@endsection