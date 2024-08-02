<h1 align="center" style="font-weight: 900; font-size: 40px; letter-spacing: 2px; color: cadetblue;">Jikan API Client en Spring Boot (Java) con Maven</h1>
<p align="center" style="font-weight: 900; font-size: 59px; letter-spacing: 2px; aling-text:center;" >El proyecto <a href="http://jikan.moe" target="_blank">Jikan API Client</a> en Spring Boot (Java) con Maven nos permite realizar búsquedas detalladas de series de anime y mangas. 
  Incluye funcionalidades como la búsqueda por género, sinopsis, y más, facilitando el acceso a la información de forma eficiente</p>

  
<p>Nota: Este proyecto está en desarrollo y se actualizará con nuevas características.</p>

<h2 style="font-weight: 900;">📖 Características 📖</h2>
  <p> -> Próximamente <- </p>

<h2 style="font-weight: 900;">⚙️ Requisitos ⚙️</h2>
<ul style="font-weight: 500; font-family: system-ui;">
    <li>Java 11 o superior</li>
    <li>Maven 3.6.3 o superior</li>
    <li>Spring Boot 2.5.4 o superior</li>
    <li>MySQL 8.0 o superior</li>
    <li>pgAdmin 4 (opcional para PostgreSQL)</li>
  <li>JWT (JSON Web Tokens) para autenticación</li>
</ul>

<h2 style="font-weight: 900;">⚙️ Dependencias Usadas ⚙️</h2>
<p>Para usar este proyecto, necesitarás las siguientes dependencias en tu archivo `pom.xml`:</p>
<pre>
<code>
&lt;dependency&gt;
    &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
    &lt;artifactId&gt;spring-boot-starter-data-jpa&lt;/artifactId&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
    &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
    &lt;artifactId&gt;spring-boot-starter-web&lt;/artifactId&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
    &lt;groupId&gt;org.postgresql&lt;/groupId&gt;
    &lt;artifactId&gt;postgresql&lt;/artifactId&gt;
    &lt;scope&gt;runtime&lt;/scope&gt;
&lt;/dependency&gt;

&lt;!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind --&gt;
&lt;dependency&gt;
      &lt;groupId&gt;com.fasterxml.jackson.core&lt;/groupId&gt;
      &lt;artifactId&gt;jackson-databind&lt;/artifactId&gt;
      &lt;version&gt;2.16.1&lt;/version&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
      &lt;groupId&gt;com.fasterxml.jackson.datatype&lt;/groupId&gt;
      &lt;artifactId&gt;jackson-datatype-jdk8&lt;/artifactId&gt;
      &lt;version&gt;2.12.3&lt;/version&gt; &lt;!-- Asegúrate de usar la versión correcta --&gt;
&lt;/dependency&gt;
</code>
</pre>

<h1 align="center" style="font-weight: 900; font-size: 40px; letter-spacing: 2px; color: cadetblue;">Y el Resto Próximamente</h1>
