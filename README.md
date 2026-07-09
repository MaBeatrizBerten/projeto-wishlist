# 🌿 Wishlist da Maria Beatriz

> Uma lista de desejos cuidadosamente escolhidos, desenvolvida com Java, Python e HTML/CSS/JS, com tema inspirado no Studio Ghibli.

---

## ✨ Sobre o Projeto

Este projeto é uma aplicação web de wishlist pessoal onde é possível cadastrar, visualizar, editar e remover itens desejados — com nome, preço, link, imagem e prioridade.

Foi desenvolvido como projeto de estudo, cobrindo desde o backend até o frontend e scripts de automação. 

---

## 🛠️ Tecnologias Utilizadas

**Backend:**
- Java 21
- Spring Boot 4
- Spring Data JPA
- Banco de dados H2 (em memória)
- Maven

**Frontend:**
- HTML5
- CSS3
- JavaScript (Vanilla)
- Fontes: Fraunces + Nunito (Google Fonts)

**Scripts:**
- Python 3.14
- Biblioteca requests

---

## 📁 Estrutura do Projeto
wishlist/
├── frontend/          # Interface web (HTML, CSS, JS)
│   ├── index.html
│   ├── style.css
│   ├── script.js
│   └── img/           # Imagens do tema Totoro
├── scripts/           # Scripts Python
│   ├── exportar.py    # Exporta a lista para CSV
│   └── relatorio.py   # Gera relatório no terminal
└── wishlist/          # Backend Java (Spring Boot)
└── src/
└── main/java/com/mariabeatriz/wishlist/
├── Item.java
├── ItemRepository.java
├── ItemController.java
└── WishlistApplication.java

---

## 🚀 Como Rodar o Projeto

### Pré-requisitos
- Java 21+
- Python 3.11+
- Maven
- VS Code com extensão Live Server

### 1. Rodando o Backend

```bash
cd wishlist
./mvnw spring-boot:run
```

O servidor vai iniciar em `http://localhost:8080`

### 2. Rodando o Frontend

Abre o arquivo `frontend/index.html` com o **Live Server** do VS Code.

Acesse em `http://127.0.0.1:5500`

### 3. Rodando os Scripts Python

```bash
cd scripts
pip install requests
python exportar.py   # exporta para CSV
python relatorio.py  # gera relatório no terminal
```

---

## 📡 Rotas da API

| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/itens` | Lista todos os itens |
| POST | `/itens` | Cadastra novo item |
| PUT | `/itens/{id}` | Atualiza item existente |
| DELETE | `/itens/{id}` | Remove item |

### Exemplo de corpo para POST/PUT:

```json
{
  "nome": "Scarpin Louboutin",
  "preco": 500.00,
  "link": "https://www.farfetch.com",
  "imagem": "https://url-da-imagem.jpg",
  "prioridade": "Urgente"
}
```

---

## 📝 O que aprendi

- Criar uma API REST completa com Spring Boot
- Conectar frontend com backend usando fetch()
- Manipular dados com scripts Python
- Organizar um projeto fullstack do zero
- Versionamento com Git e GitHub

---

## 👩‍💻 Autora

**Maria Beatriz Berten**
- GitHub: [@MaBeatrizBerten](https://github.com/MaBeatrizBerten)

---

*Feito com 🌿 e muito carinho*
