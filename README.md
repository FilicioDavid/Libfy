# 📚 Sistema de Gerenciamento de Biblioteca — Java

Este projeto está sendo desenvolvido com o objetivo de *aprimorar as habilidades em desenvolvimento Java*, através da criação de um sistema para gerenciamento de biblioteca.

---

## 🎯 Objetivo

Desenvolver um sistema em Java com as seguintes funcionalidades:

- Cadastro de livros e usuários (restrito a administradores).
- Empréstimos e devoluções de livros.
- Consulta ao acervo.
- Controle de empréstimos com status.

---

## ✅ Requisitos da Atividade

### 👥 Cadastro de Usuários

- Informações necessárias:
  - Nome
  - E-mail
  - Senha
  - Tipo de usuário (ADMIN ou COMUM)
- Somente *usuários do tipo ADMIN* podem cadastrar novos usuários.

### 📚 Cadastro de Livros

- Informações necessárias:
  - Título
  - Autor
  - Status de disponibilidade
- Somente *usuários do tipo ADMIN* podem cadastrar novos livros.

### 🔄 Empréstimos de Livros

- Apenas *usuários COMUNS* podem realizar empréstimos.
- Cada empréstimo deve conter:
  - ID do livro
  - ID do usuário
  - Data de devolução
- Após o empréstimo, o livro é marcado como *indisponível*.

### ✅ Devoluções de Livros

- Permite a devolução de livros emprestados.
- Após a devolução, o livro é marcado como *disponível* novamente.

### 🔍 Consulta de Acervo

- Disponível para todos os usuários (ADMIN e COMUM).
- Exibe livros *disponíveis* e *emprestados*.

### 📊 Controle de Empréstimos

- Registro de todos os empréstimos realizados.
- Exibição do *status de devolução*:
  - Dentro do prazo
  - Em atraso

---

## 📋 Menus

### Usuário Comum

- Consultar acervo de livros
- Emprestar livros
- Devolver livros
- Visualizar seus empréstimos

### Administrador

- Consultar acervo completo
- Cadastrar livros
- Cadastrar usuários
- Listar todos os usuários
