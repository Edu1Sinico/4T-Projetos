<?php

use App\Http\Controllers\MeuModelController;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\ProdutoController;

Route::get('/', function () {
    return view('Home');
});

Route::get('/produto', function () {
    return view('Produtos');
});

// Rota para listar todos os produtos
Route::get('/produto', [ProdutoController::class, 'index']);

Route::get('/contato', function () {
    return view('Contato');
});

Route::get('/meu-model', [MeuModelController::class]);
