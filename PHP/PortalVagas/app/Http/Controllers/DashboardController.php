<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Vaga;

class DashboardController extends Controller
{
    public function index(Request $request){
        $search = $request->input('search');
        $vagas = Vaga::when($search,function ($query, $search) {
            return $query->where('titulo','like', "%{$search}%")
                    ->orWhere('descricao','like', "%{$search}%")
                    ->orWhere('localizacao','like', "%{$search}%")
                    ->orWhere('empresa','like', "%{$search}%");
        })->get();

        return view('usuarios.dashboard', compact('vagas'));
    }
}
