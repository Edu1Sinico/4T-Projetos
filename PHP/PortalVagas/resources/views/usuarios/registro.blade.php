@extends('layout.app')

@section('content')
    {{-- formulario --}}
    <div class="container">
        <h1>Registrar-se</h1>
        <form method="POST" action="{{ route('usuarios.registro') }}">
            @csrf

            <div class="form-group">
                <label for="nome">Nome</label>
                <input type="text" name="nome" placeholder="Insira o seu nome" class="form-control" required>
            </div>
            <br>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" name="email" placeholder="Insira o seu Email" class="form-control" required>
            </div>
            <br>
            <div class="form-group">
                <label for="password">Senha</label>
                <input type="password" min="8" name="password" placeholder="Crie uma senha" class="form-control" required>
            </div>
            <br>
            <div class="form-group">
                <label for="password_confirmation">Confirme a Senha</label>
                <input type="password" min="8" name="password_confirmation" placeholder="Confirmar sua senha" class="form-control" required>
            </div>
            <br>
            <div class="form-check-container" style="display: flex; justify-content: space-evenly; width: 100%;">
                <div class="form-check">
                    <input class="form-check-input" type="radio" value='usuario' name="tipo" id="typeUserRadio1"
                        checked>
                    <label class="form-check-label" for="typeUserRadio1">
                        Usuário
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" value='empresa' name="tipo" id="typeUserRadio2">
                    <label class="form-check-label" for="typeUserRadio2">
                        Empresa
                    </label>
                </div>
            </div>
            <br>
            <div class="form-group-empresa" id="form-group-empresa-id" style="display: none;">
                <div class="form-group">
                    <label for="nome_empresa">Nome da Empresa</label>
                    <input type="text" name="nome_empresa" placeholder="Insira o nome da empresa" value="" class="form-control">
                </div>
                <br>
                <div class="form-group">
                    <label for="cnpj">CNPJ</label>
                    <input type="text" name="cnpj" placeholder="Insira o CNPJ" value="" class="form-control">
                </div>
            </div>
            <br>
            <div align="center" class="form-group">
                <button type="submit" class="btn btn-primary">Registrar-se</button>
            </div>

        </form>
    </div>
    <script>
        // Função para mostrar ou esconder a div com base no radio selecionado
        function toggleEmpresaDiv() {
            var empresaDiv = document.getElementById('form-group-empresa-id');
            var tipoRadio = document.querySelector('input[name="tipo"]:checked').value;

            if (tipoRadio === 'empresa') {
                empresaDiv.style.display = 'block';
            } else {
                empresaDiv.style.display = 'none';
            }
        }

        // Adiciona eventos aos radio buttons para chamar a função quando um deles for selecionado
        document.querySelectorAll('input[name="tipo"]').forEach(function(radio) {
            radio.addEventListener('change', toggleEmpresaDiv);
        });

        // Inicializa a visibilidade da div com base na seleção inicial
        toggleEmpresaDiv();
    </script>
@endsection
