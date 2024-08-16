<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Inscricao;
use App\Models\Vaga;
use Illuminate\Support\Facades\Auth;

class InscricaoController extends Controller
{
    public function add(Request $request, Vaga $vaga){
        $inscricao = Inscricao::firstOrCreate(['usuario_id' => Auth::id(), 'vaga_id' => $vaga->id]);

        return redirect()->route('vagas.show', $inscricao->id)->with('success','Inscrição adicionada à vaga.');
    }
}
