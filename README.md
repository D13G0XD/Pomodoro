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