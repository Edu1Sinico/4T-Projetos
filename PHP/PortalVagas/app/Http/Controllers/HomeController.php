<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Vaga;

class HomeController extends Controller
{
    public function index(){
        $vagas = Vaga::latest()->take(3)->get();
        return view('home',compact('vagas'));
    }
}
