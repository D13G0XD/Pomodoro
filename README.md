# Projeto Pomodoro Spring Boot Alura
![Java](https://img.shields.io/badge/Java-%23ED8B00.svg??style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=flat&logo=spring&logoColor=white)

<p>O repositório consiste em anotações referentes ao módulo de Java Spring Boot proposto pelo curso da Alura. </p>

<h2>Introdução</h2>

<h3> O que é Backend?</h3>

É responsável pelo armazenamento e recuperação das informações. Trata-se os seguintes pontos também:

<li> 
<b>Armazenamento</b>: Guarda e recupera dados persistentes
</li>
<li><b>Regras de negócio</b>: Processamento e validação de informações</li>
<li><b>API</b>: Expõe dados para o frontend e outros sistemas</li>
<li><b>Segurança</b>: Controla autenticação e autorização</li>

<p>Ele pode ser executado em 3 pontos importantes</p>

<li> Servidores físicos: Conhecido como modelos on-premises (instalado localmente) muito utilizado ainda em bancos </li>
<li> Nuvem: Provedores como AWS, Google Cloud Plattform ou Microsoft Azure. Contrata-se o serviço desejado.</li>

<li> Execução local: Forma local de executar o backend.</li>

<h2>O que é REST?</h2>

<h3>Criando um sistema</h3>

<p>Imagine 4 aplicações que necessitam consumir informações da sua aplicação</p>

<li>Aplicativo Mobile</li>
<li>Frontend web</li>
<li>Sistema adminsitrativo</li>
<li>Aplicação de terceiros</li>

<p>Como há muitos sistemas muito provavelmente iríamos sofrer com uma falta de padronização, não sendo uma boa prática projeto</p>

<p>A ideia da API REST é estruturar uma organização do projeto, uma convenção.</p>

<h3>O que a REST define?</h3>

<li><b>URLs previsíveis:</b> Estruturas de endereços lógicas e fáceis de deduizar para identificar cada reurso da aplicação de forma única.</li>
<br>
<li><b>Verbos HTTP:</b> Uso correto dos métodos semânticos (GET, POST, PUT, DELETE) para indicar claramente a ação desejada no recurso.</li>
<br>
<li><b>Comunicação:</b> Uma troca de dados totalmente padronizada e previsível através de formatos consolidados como JSON e XML</li>

<h3>JSON</h3>

<p>Cada atributo da classe se torna uma propriedade no JSON</p>

<p> Java id -> JSON "id"</p>
<p> Java title -> JSON "title" </p>
<p> Java completed -> JSON "completed"</p>

<h2>Buscando tarefas específicas</h2>
<p>O endpoint GET /tasks retorna <b>tudo</b></p>
<p> Por possuir um acesso a URL dinâmica, podemos acessar apenas uma tarefa informando o passando o id na url.</p>

<li>GET /tasks/1 - busca a tarefa com ID 1</li>
<li>GET /tasks/2 - busca a tarefa com ID 2</li>
<li>GET /tasks/3 - busca a tarefa com ID 3</li>

<h2>Filtrando com Query Parameters</h2>
<p>Podemos filtrar tarefas ao qual já foram concluídas, por exemplo:</p>
<li>GET /tasks?completed=true</li>
<li>GET /tasks?completed=false</li>

<p>O símbolo ? separa a URL dos parâmetros. Os parâmetros seguem o formato <b>chave=valor</b></p>

<h1>Glossário de Anotações</h1>

<p><b>@RestController</b> ela informa ao Spring que a classe é um controlador e que os métpdps dentro ela devem retornar dados diretamente (JSON ou XML) em vez de nomes de views. Crucial para construir APIs RESTful</p>
<p><b>@RequestMapping</b> usada para mapear requisições HTTP para métodos de manipulador de específicos em uma classe controladore. Define o caminho base (ou recurso) para todos os endpoints dentro da classe.</p>
<p><b>@GetMapping</b> é anotação especialiazada para mapear requisições HTTP GET. Utilizada para definir endpoints que recuperam dados.</p>
<p><b>@RequestParam</b> usada para extrair parâmetros de consulta (query parameters) da URL. Esses parâmetros aparecem após o ? na URL. Permite que capture o valor de completed e use no seumétodos. O atributo required = false indica que o parâmetro é opcional</p>
<p><b>@PathVariable</b> extrai valores de variáveis diretamente do caminho da URL em casos onde há placeholders por exemplo, {id} e o passa como argumento para o método.</p> 