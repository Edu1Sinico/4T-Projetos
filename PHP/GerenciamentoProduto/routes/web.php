<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\ProdutoController;

Route::get('/', function () {
    return view('welcome');
});

// Altera as rotas conforme o método for chamado
Route::resource('produtos', ProdutoController::class);
