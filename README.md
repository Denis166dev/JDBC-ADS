# JDBC (Java Database Connectivity)

JDBC é uma API Java que serve como ponte de comunicação entre aplicações Java e bancos de dados relacionais. Essa interface padronizada permite que desenvolvedores interajam com diversos SGBDs (Sistemas Gerenciadores de Bancos de Dados) utilizando uma linguagem comum.

## Por que usar JDBC?

- **Padronização**: Oferece uma interface uniforme para diferentes bancos de dados, facilitando a portabilidade de aplicações.
- **Facilidade de uso**: Simplifica tarefas como conexão, consulta e manipulação de dados.
- **Flexibilidade**: Permite executar consultas simples e complexas.

## Como funciona o JDBC?

1. **Carregamento do Driver**: Carrega o driver específico do banco de dados para estabelecer a conexão.
2. **Conexão**: Cria uma conexão com o banco de dados, fornecendo informações como URL, usuário e senha.
3. **Statements**: Cria objetos para representar comandos SQL a serem executados.
4. **Execução de Consultas**: Executa consultas SQL usando os statements e obtém resultados.
5. **ResultSet**: Armazena os resultados da consulta, permitindo navegação e acesso aos dados.
6. **Fechamento**: Fecha a conexão e libera os recursos.

## Tipos de Drivers JDBC

1. **JDBC-ODBC Bridge**  
2. **Nativo-JDBC**  
3. **Protocolo de rede**  
4. **Thin Driver**  

## Benefícios do JDBC

- **Portabilidade**
- **Performance**
- **Segurança**
