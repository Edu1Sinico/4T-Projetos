<header class="p-3 text-bg-dark">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
                    <use xlink:href="#bootstrap"></use>
                </svg>
            </a>

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="/" class="nav-link px-2 text-secondary">Home</a></li>
                <li><a href="/dashboard" class="nav-link px-2 text-white">Dashboard</a></li>
                @auth
                    @if (Auth::user()->isEmpresa())
                        <li><a href="/vagas" class="nav-link px-2 text-white">Vagas</a></li>
                    @endif
                @endauth
            </ul>


            @auth
                <div class="text-end" style="display: flex; align-items: center; justify-content: space-evenly; width: 40%">
                        <div class="title">Bem-vindo, <span>{{ Auth::user()->nome }}</span>!</div>

                    <form action="{{ route('usuario.logout') }}" method="POST">
                        @csrf
                        <input type="submit" value="Sair" class="btn btn-danger">
                    </form>
                @else
                    <a href="\login">
                        <button type="button" class="btn btn-outline-light me-2">Login</button></a>
                    <a href="\registro">
                        <button type="button" class="btn btn-warning">Registrar-se</button></a>
                </div>
            @endauth
        </div>
    </div>
</header>
