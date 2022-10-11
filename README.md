# Realizando Deploy na Nuvem de um conjunto de API’s desenvolvida em Spring Boot 
Desafio de projeto na plataforma de cursos online <a href="https://dio.me/"><strong> Digital Innovation One</strong></a>.<br>
Especialista: Sandro Giacomozzi

## 🎯 Objetivo do Projeto
<p>Construir uma <strong>API</strong> para controle de um estacionamento de veículos. Esta <strong>API</strong> deverá controlar entrada e saída de veículos. 
Os dados deverão ser cadastrados em um banco de dados relacional.
Está <strong>API</strong> será exposta na nuvem, porém com controle de acesso. 
Desenvolvida...</p>


## 🛠 Tecnologias Utilizadas


- VS Code
- Java 11
- Maven
- Spring Web
- Spring Data JPA
- PostgreSQL Driver
- Spring Security 
- Lombok
- Heroku


### Modificações 


	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId> 
		<version>2.5.2</version>
	</parent>

  <!-- https://mvnrepository.com/artifact/io.springfox/springfox-boot-starter  para fazer o swagger funcionar -->
		 <dependency>
				<groupId>io.springfox</groupId>
				<artifactId>springfox-boot-starter</artifactId>
				<version>3.0.0</version>
		</dependency> 


## 🔗 Links Úteis
[Acesso ao Swagger](http://localhost:8080/swagger-ui/index.html)





