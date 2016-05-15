# friendsjooby
<p align="center">
	<img src="https://assets-cdn.github.com/images/modules/site/personal-ill-learn.png" alt="ROR Resources Cover" style="max-width:1%;">
</p>

<h1 align="center">FriendJooby</h1>

<p align="center">Projeto Tópicos Especiais - Engenharia de Software</p>

## :mortar_board: Integrantes

<a id="user-content-Índice" class="anchor" href="#Índice" aria-hidden="true"></a>
<p align="center">
	<a href="https://github.com/Ibirajara" target="_blank">Ibirajara Barrel Junior</a> •
</p>

## :computer: Atividades
Developer | Method | @Test | Descrição
:-- | :-- | :-- | :--
[ Ibirajara Barrel Junior   ] | Get |  OK       | Exibe "Welcome to your Address book!!";
[ Ibirajara Barrel Junior   ] | Get/todos |  NO       | Exibe todos os contatos;
[ Ibirajara Barrel Junior   ] | Post/todos |  OK       | Inclui novo contato;
[ Ibirajara Barrel Junior   ] | Get/find:id |  OK       | Retorna contato por id;


## :beginner: Requisitos 
* Install <a href="http://www.oracle.com/technetwork/java/javase/downloads/index.html" target="_blank">JDK 8+</a>
* Install <a href="http://maven.apache.org/" target="_blank">Maven 3+</a>
* Use <a href="https://daringfireball.net/projects/markdown/" target="_blank">Markdown 1.0.1</a>


## :fallen_leaf: Comandos Básicos (Criação do projeto - MVN)
Comando | Funcionalidade
:-- | :-- 
mvn archetype:generate -B -DgroupId=com.mycompany -DartifactId=my-app -Dversion=1.0-SNAPSHOT -DarchetypeArtifactId=jooby-archetype -DarchetypeGroupId=org.jooby -DarchetypeVersion=1.0.0.CR3 | Cria um novo projeto a partir do local onde esta sendo executado;
mvn jooby: run | Inicia o servidor local;


## :octocat: Comandos Básicos (Upando projeto - GitHub)
Comando | Funcionalidade
:-- | :-- 
git init | Inicia o Git;
git add . | Adiciona  todos os documentos locais ao GitHub;
git commit -m "mensagem de commit" | Efetua o commit;
git push nomedoSeuProjeto | Confirma o commit, em seguida solicita o usuario e senha;
git pull nomedoSeuProjeto master | Trás todas as modificações do GitHub para o computador local;
git config --global user.email seuEmail | Seta um email global para o computador;
git config --global user.name seuNome | Seta um nome global para o computador;


## A aplicação possui quatro métodos, são eles:
	* GET: Retorna "Welcome to your Address book!!" no index;
	* GET/todos: Retorna a lista de contatos;
	* POST/todos: Adiciona um novo contato passando os dados(Nome e telefone) através de POST.
	* GET/find/:id Busca um contato baseado no id passado como parâmetro.


Para executá-la é preciso iniciar o servidor com o código que está na tabela "Comandos Básicos (Criação do projeto - MVN)".
Com o servidor iniciado acessamos a aplicação através de url.
## :octocat: Acessando aplicação
URL | Funcionalidade
:-- | :-- 
http://localhost:8080/ | Retorna "Welcome to your Address book!!" no index;
http://localhost:8080/todos | Retorna a lista de contatos;
http://localhost:8080/todos | Adiciona um novo contato;
http://localhost:8080/find:id | Retorna o usuário referente ao id.
