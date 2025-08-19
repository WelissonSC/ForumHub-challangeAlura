Fórum Hub - Spring Boot
Descrição

Este é um projeto de exemplo de Fórum Hub, desenvolvido como challenge da Alura.
Ele utiliza Spring Boot, JPA/Hibernate, MySQL (XAMPP), DTOs e Spring Security com autenticação básica.

O projeto permite:

Criar, listar, atualizar e deletar tópicos

Proteção de endpoints via autenticação

Uso de DTOs para entrada e saída de dados

Tecnologias

Java 17+

Spring Boot 3+

Spring Data JPA

Spring Web

Spring Security

Lombok

MySQL (XAMPP)


Configuração do Banco de Dados

Inicie o MySQL pelo XAMPP.

Crie o banco de dados:

CREATE DATABASE forum_alura;


Configure o application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/forum_alura?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

Rodando a aplicação

Compile e execute o projeto:

mvn spring-boot:run


A aplicação vai subir na porta 8181 (ou a configurada no application.properties).

Endpoints
Autenticação

Usuário: welisson

Senha: 123456

Autenticação básica (Basic Auth HTTP)

Tópicos
Método	Endpoint	Descrição
GET	/topicos	Lista todos os tópicos
GET	/topicos/{id}	Busca um tópico por ID
POST	/topicos	Cria um novo tópico
PUT	/topicos/{id}	Atualiza um tópico
DELETE	/topicos/{id}	Deleta um tópico
Exemplo de JSON (POST /topicos)
{
  "titulo": "Dúvida sobre Spring Boot",
  "mensagem": "Como usar DTOs com JPA?",
  "status": "ABERTO",
  "autor": "Welisson",
  "curso": "Spring Boot"
}

Exemplo de JSON de resposta (TopicoResponse)
{
  "id": 1,
  "titulo": "Dúvida sobre Spring Boot",
  "mensagem": "Como usar DTOs com JPA?",
  "dataCriacao": "2025-08-19T10:35:22.123",
  "status": "ABERTO",
  "autor": "Welisson",
  "curso": "Spring Boot"
}

DTOs

TopicoRequest → entrada de dados (POST/PUT)

TopicoResponse → saída de dados (GET)

Lombok

O projeto utiliza Lombok para reduzir boilerplate:

@Getter, @Setter, @NoArgsConstructor, @AllArgsConstructor, @Builder

@RequiredArgsConstructor no Controller para injeção de dependência

Observações

O Spring Security está configurado com autenticação básica.

Endpoints de /topicos exigem login.

Para produção, é recomendado usar JWT ou outro mecanismo seguro em vez de Basic Auth.
