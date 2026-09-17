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

<h2>Método POST</h2>
<p>É um dos verbos HTTP e é usado para enviar dados ao servidor para criar um novo recurso. Ao contrário do GET, que busca dados, o POST modifica o estado do servidor ao adicionar novas informações</p>

<h3>Corpo da Requisição (Request Body)</h3>
<p>É a parte de uma requisição onde os dados do cliente são enviados ao servidor, como por exemplo para enviar os dados de uma nova tarefa em formato JSON, que são lidos pelo @RequestBody</p>

<h1>Spring Data JPA</h1>

É um framework responsável por simplificar a iteração com bancos de dados erlacionais no contexto do Spring Boot, atuando como uma camada de abstração sobre o JPA (Java Persistence API), que é uma especificação de mapeamento objeto-relacional.

<p>A ideia central é facilitar a implementação de operações CRUD (Criar, Ler, Atualizar e Excluir) </p>

<h2>Mapeamento Simplificado</h2>

<p>A tradução direta do modelo orientada a objetos para o banco de dados</p>

Task (Objeto Java) => JPA => tasks (tabela relacional)

<h2>Evolução do Mapeamento</h2>

JPA especificação que permite mapear objetos Java para tabela de banco de dados => Spring Data JPA abstração que facilita e simplifica o uso prático dessa especificação no dia a dia.

<h2>Hibernate Dialect</h2>

No contexto do JPA e do Hibernate, o Dialect é uma configuração que instrui o Hibernate sobre as particularidades da linguagem SQL de cada SGBD. É essencial para que o framework gere os comando SQL compatíveis com o banco de dados utilizado, como PostgreSQL, MySQL, Oracle e etc. Cada Dialect adapta as queries automaticamente como funções, palavras reservadas e a sintaxe específica de cada sistema.

<h3>Funcionamento e importância</h3>

Ao configurar o Hibernate, a indicação do Dialect apropriado permite que a aplicação traduza as operações realizadas sobre as entidades Java em comnados SQL corretamente ormatados. Por exemplo com o Postgres Dialect, consulta e atualizações se adaptam às características do PostgreSQL.

<p>Utilizar o Dialect adequado facilita a manutenção e protabilidade da aplicação, como em casos de denecessidade de migração para outro banco de dados, atualziar a configuração pode ser o primeiro passo para o ajuste, mantendo as consistência.</p>

No application.properties, inserimos (no contexto PosgreSQL): spring.jpa.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialeact

<h2>Repository</h2>

É uma <b>interface</b> que permite interagir com o banco de dados herdando métodos de uma outra interface da JpaRepository vindo com o seguintes métodos:

| Métodos        |                     Função                     | 
|:---------------|:----------------------------------------------:| 
| findAll()      |            busca todos os registros            | 
| findById(id)   | para buscar um registro pelo seu identificador | 
| save(entity)   |       para criar ou atualizar registros        | 
| deleteById(id) |   exclui um registro pelo seu identificador    | 
| existsById(id) |      para verificar se um registro existe      | 

<h1>Fluxo da requisição HTTP</h1>

<ol>
    <li>Postman => Envia a requisição HTTP</li>
    <li>Controller => Recebe e valida a entrada </li>
    <li>Repository => Abstrai operações de dados (Salvar, buscar, atualiza ou excluir) </li>
    <li>JPA => Mapeia entidades e queries</li>
    <li>PostgreSQL => Persistência de dados</li>
</ol>

<h1>DTO (Data Transfer Object)</h1>

É um padrão de projeto usado para controlar qual informação enviamos para a pessoa usuário e qual recebemos dela. A ideia principal é evitar expor campos internos da Entity (como createdAt ou internalCode) que não são relevantes para o frontend, garantindo segurança e retorno de dados mais limpo.


| DTO (O que o cliente vê) | Entity(O que existe no banco) | 
|:-------------------------|:-----------------------------:| 
| Long id                  |            Long id            | 
| String title             |         String title          | 
| Boolean completed        |       Boolean completed       | 
| -                        |       Integer internId        | 
| -                        |   LocalDateTime createdDate   | 



<h1>Glossário Spring</h1>

<p><b>@RestController</b> ela informa ao Spring que a classe é um controlador e que os métpdps dentro ela devem retornar dados diretamente (JSON ou XML) em vez de nomes de views. Crucial para construir APIs RESTful</p>
<p><b>@RequestMapping</b> usada para mapear requisições HTTP para métodos de manipulador de específicos em uma classe controladore. Define o caminho base (ou recurso) para todos os endpoints dentro da classe.</p>
<p><b>@GetMapping</b> é anotação especialiazada para mapear requisições HTTP GET. Utilizada para definir endpoints que recuperam dados.</p>
<p><b>@RequestParam</b> usada para extrair parâmetros de consulta (query parameters) da URL. Esses parâmetros aparecem após o ? na URL. Permite que capture o valor de completed e use no seumétodos. O atributo required = false indica que o parâmetro é opcional</p>
<p><b>@PathVariable</b> extrai valores de variáveis diretamente do caminho da URL em casos onde há placeholders por exemplo, {id} e o passa como argumento para o método.</p>
<p><b>Classe ResponseEntity</b> responsável por representar toda a resposta HTTP, incluindo status code, os cabeçalhos e o corpo da resposta que a API envia e volta ao cliente </p>
<p><b>@PostMapping</b> é usada para mapear requisições HTTP do tipo POST para um método específico em um controller. Indica ao Spring que o método anotado deve ser executado quando uma requisição POST for feita para o endpoint especificado.</p>
<p><b>@RequestBody</b> utilizada para indicar que um parâmetro de método deve ser preenchido com o corpo da requisição HTTP. No contexto de uma API REST, significa que o Spring converterá o JSON enviado no corpo da requisição para um objeto Java.</p>
<p><b>@PutMapping</b> utilizada para mapear requisições HTTP do tipo PUT para um método específico em nosso controller.</p>
<p><b>@Entity</b> usada para maracar uma classe como entidade JPA. Isso significa que o Spring e o Hibernate (implementação do JPA) vão entender que essa classe corresponde a uma tabela no banco de dados. Cada instância será uma linha na tabela.</p>
<p><b>@Id</b> é aplicada em um campo dentro da classe Task para indicar que ele é a chave primária da entidade. A chave primária é um identificador único para cada registro na tabela do banco de dados.</p>
<p><b>@GeneratedValue(GenerationType.IDENTITY)</b> é utilizada em conjunto com @Id para especificar como o valor da chave primária será gerado. No caso de GenerationType.IDENTITY, o banco de dados será responsável pro gerar automaticamente um valor único para cada ID, geralmente de forma incremental, a cada novo registro</p>
<p><b>@NotBlank</b> utilizado para determinar que uma string em Java não seja nula, não esteja vazia e contenha pelo menos um caractere que não seja espaço em branco. Pode receber uma variável message que exibe caso a variável esteja em branco. </p>
<p><b>@Size</b> utilizado para determinar um tamanho mínimo e/ou máximo</p>
<p><b></b></p>
<p><b></b></p>