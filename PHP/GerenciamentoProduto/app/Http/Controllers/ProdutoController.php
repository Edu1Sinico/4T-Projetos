<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Produto;

class ProdutoController extends Controller
{

    public function index()
    {
        $produto = Produto::all();
        // O método retorna todos os valores da tabela e o endereço da url com todas as informações.
        return view('produtos.index', compact('produtos'));
    }

    public function create()
    {
        // Apenas direciona o usário para a página de criação
        return view('produtos.create');
    }

    // Método que faz a comunicação com o banco de dados e adiciona os valores.
    public function store(Request $request)
    {
        // Realiza a validação dos campos obrigatórios.
        $request->validate([
            'nome' => 'required',
            'preco' => 'required|decimal',
        ]);

        // Chama um método padrão d laravel para adicionar as informações no model
        Produto::create($request->all());

        // Se tudo der certo, ele retorna com a mensagem de sucesso.
        return redirect()->route('produtos.index')->with('success', 'Produto criado com sucesso.');
    }

    /**
     * Display the specified resource.
     */
    public function show(Produto $produto)
    {
        // página que retorna com o valor selecionado específico.
        return view('produtos.show', compact('produto'));
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(Produto $produto)
    {
        // página que retorna com o valor selecionado específico para ser editado.
        return view('produtos.show', compact('produto'));
    }

    // Método que faz a comunicação com o banco de dados e atualizar os valores especificos.
    public function update(Request $request, string $id)
    {
        // Realiza a validação dos campos obrigatórios.
        $request->validate([
            'nome' => 'required',
            'preco' => 'required|decimal',
        ]);

        // Chama um método padrão d laravel para atualizar as informações no model
        Produto::update($request->all());

        // Se tudo der certo, ele retorna com a mensagem de sucesso.
        return redirect()->route('produtos.index')->with('success', 'Produto criado com sucesso.');
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(Produto $produto)
    {
        $produto->delete();

        return redirect()->route('produtos.index')->with('success', 'Produto Deletado com Sucesso.');
    }
}
