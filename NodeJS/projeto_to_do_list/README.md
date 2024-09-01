# Projeto To-Do-List

>  ## _índice:_

- [Introdução](#introdução);
- [Objetivos do Projeto](#objetivos-do-projeto);
- [Cronograma](#cronograma);
- [Funcionalidades](#funcionalidades);
- [Design e Estilos](#design-e-estilos);
- [Análise de riscos](#análise-de-riscos);
- [Estrutura de Programação](#estrutura-de-programação);

>  ## _Introdução_
A organização eficiente das tarefas diárias é um desafio constante para muitas instituições, incluindo o SENAI. Para melhorar a produtividade e garantir que todas as atividades sejam executadas de forma ordenada e dentro dos prazos estabelecidos, a escola SENAI identificou a necessidade de uma solução simples e eficaz. Em resposta a essa demanda, fui encarregado de desenvolver uma aplicação de gerenciamento de tarefas (To-Do-List) voltada especificamente para os colaboradores da instituição.

Este projeto visa fornecer uma ferramenta prática e intuitiva que permitirá aos colaboradores organizar suas tarefas de maneira mais eficiente e segura. A aplicação não apenas facilitará o acompanhamento e a conclusão das atividades, mas também promoverá um ambiente de trabalho mais organizado e produtivo, contribuindo positivamente para o cumprimento dos objetivos institucionais.

<br>

> ## _Objetivos do Projeto_
Fornecer uma ferramenta intuitiva e eficiente para a organização de tarefas dos colaboradores.<br><br>
Os principais objetivos desse sistema, são:<br>

**1. Específicos:**
Automatizar o processo de gerenciamento de tarefas.

<br>

**2. Mensuráveis:**
Acompanhar a quantidade de tarefas concluídas semanalmente.

<br>

**3. Atingíveis:**
Garantir que o sistema seja acessível e fácil de usar para todos os colaboradores.

<br>

**4. Relevantes:**
Aumentar a produtividade e eficiência dos colaboradores na execução de suas tarefas.

<br>

**5. Temporais:**
Concluir o desenvolvimento e implementação do projeto em 6 meses.


<br>

> ## _Cronograma_


<br>

> ## _Funcionalidades_


<br>

### _Manual de Instrução:_

**_Fluxograma de Uso:_**

**_Fluxograma de Classe:_**

<br>

> ## _Design e Estilos_


<br>

> ## _Análise de riscos_
Aqui estão alguns possíveis problemas que podem ocorrer durante o projeto:<br><br>

**1. Riscos Funcionais:**
- Sincronização de Tarefas: Risco de falha na sincronização entre dispositivos, podendo resultar em informações desatualizadas. Mitigação: Testes extensivos de sincronização.
- Exclusão de Tarefas: Possíveis dificuldades na exclusão de tarefas, levando ao acúmulo de informações desnecessárias. Mitigação: Sistema de confirmação de exclusão e testes rigorosos.
<br>

**2. Riscos de Segurança:**
- Injeção de Código: Risco de inserção de scripts maliciosos nos campos de entrada. Mitigação: Validação e sanitização das entradas de dados.
- Acesso Não Autorizado: Possibilidade de acessos não autorizados a informações sensíveis. Mitigação: Autenticação segura com multifator e criptografia de dados.
<br>

**3. Riscos de Desempenho:**
- Lentidão no Carregamento: O aumento do número de tarefas pode causar lentidão. Mitigação: Otimização de consultas e lazy loading.
- Sobrecarga do Servidor: Acesso simultâneo por muitos usuários pode sobrecarregar o servidor. Mitigação: Balanceamento de carga e escalabilidade automática.
<br>

**4. Riscos de Confiabilidade:**
- Perda de Dados: Risco de perda de dados em falhas ou manutenção. Mitigação: Backups automáticos regulares.
- Atualizações Problemáticas: Atualizações podem introduzir novos bugs. Mitigação: Testes em ambiente de staging antes da produção.
<br>

**5. Riscos de Usabilidade:**
- Interface Complexa: Interface pode ser difícil de usar para alguns colaboradores. Mitigação: Testes de usabilidade para garantir uma interface intuitiva.
- Compatibilidade de Dispositivos: A aplicação pode não funcionar corretamente em todos os dispositivos. Mitigação: Testes de compatibilidade com diferentes dispositivos e navegadores.

<br>

> ## _Estrutura de Programação_
**Framework React**
<br>
React é uma biblioteca JavaScript amplamente utilizada para a construção de interfaces de usuário (UI) dinâmicas e interativas. Desenvolvido pelo Facebook, ele permite a criação de componentes reutilizáveis, facilitando a manutenção e a escalabilidade de projetos. React oferece uma abordagem eficiente para a atualização da UI com seu Virtual DOM, o que resulta em melhor desempenho e uma experiência de usuário mais fluida.

<hr>

**Compilador Node.js**
<br>
Node.js é um ambiente de execução JavaScript no lado do servidor, que permite a construção de aplicações escaláveis e de alta performance. Ele é baseado no motor V8 do Google Chrome e possibilita a criação de servidores web rápidos, suportando um grande número de conexões simultâneas. Node.js é conhecido por sua eficiência em lidar com operações de I/O, tornando-o ideal para aplicações em tempo real.

<hr>

**MongoDB**
<br>
MongoDB é um banco de dados NoSQL que armazena dados em documentos JSON-like, oferecendo flexibilidade e escalabilidade para aplicações modernas. Diferente dos bancos de dados relacionais tradicionais, o MongoDB permite a manipulação e consulta de grandes volumes de dados não estruturados de forma ágil. Sua arquitetura distribuída facilita o gerenciamento de dados em larga escala e oferece alta disponibilidade.

<hr>

**Autenticador JWT**
<br>
JWT (JSON Web Token) é um padrão de autenticação e troca de informações seguras entre partes, utilizado principalmente em sistemas web. Ele permite a autenticação de usuários sem a necessidade de manter sessões no servidor, facilitando a escalabilidade e melhorando a segurança. O JWT contém informações codificadas sobre o usuário e sua validade, permitindo a verificação de identidade de forma simples e eficiente.

<hr>

**Bootstrap**
<br>
Bootstrap é um popular framework de front-end utilizado para criar interfaces web responsivas e modernas. Desenvolvido pela equipe do Twitter, ele oferece uma ampla gama de componentes prontos, como botões e formulários, além de um sistema de grid flexível que facilita o design para diferentes dispositivos.

<hr>

**Github**
<br>
Além disso, utilizamos o Git como sistema de controle de versão, permitindo o armazenamento seguro de todos os arquivos do projeto e da documentação. O Git não só facilita a colaboração entre os membros da equipe, como também assegura que todas as mudanças no código sejam registradas e possam ser revertidas, se necessário, garantindo assim um desenvolvimento mais organizado e controlado.

