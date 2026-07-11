# 📡 Documentação da API — Wishlist

Base URL: `http://localhost:8080`

---

## 📋 Itens

### GET /itens

Retorna todos os itens cadastrados na wishlist.

**Resposta:**

```json
[
  {
    "id": 1,
    "nome": "Scarpin Louboutin",
    "preco": 500.0,
    "link": "https://www.farfetch.com",
    "imagem": "https://url-da-imagem.jpg",
    "prioridade": "Urgente"
  }
]
```

---

### POST /itens

Cadastra um novo item na wishlist.

**Corpo da requisição:**

```json
{
  "nome": "Scarpin Louboutin",
  "preco": 500.0,
  "link": "https://www.farfetch.com",
  "imagem": "https://url-da-imagem.jpg",
  "prioridade": "Urgente"
}
```

**Resposta:**

```json
{
  "id": 1,
  "nome": "Scarpin Louboutin",
  "preco": 500.0,
  "link": "https://www.farfetch.com",
  "imagem": "https://url-da-imagem.jpg",
  "prioridade": "Urgente"
}
```

---

### PUT /itens/{id}

Atualiza um item existente pelo id.

**Exemplo:** `PUT /itens/1`

**Corpo da requisição:**

```json
{
  "nome": "Scarpin Louboutin Verniz",
  "preco": 450.0,
  "link": "https://www.farfetch.com",
  "imagem": "https://url-da-imagem.jpg",
  "prioridade": "Média"
}
```

**Resposta:**

```json
{
  "id": 1,
  "nome": "Scarpin Louboutin Verniz",
  "preco": 450.0,
  "link": "https://www.farfetch.com",
  "imagem": "https://url-da-imagem.jpg",
  "prioridade": "Média"
}
```

---

### DELETE /itens/{id}

Remove um item pelo id.

**Exemplo:** `DELETE /itens/1`

**Resposta:** `200 OK` (sem corpo)

---

## 🎯 Prioridades aceitas

| Valor     | Descrição                   |
| --------- | --------------------------- |
| `Urgente` | Item de alta prioridade     |
| `Média`   | Item de média prioridade    |
| `Sonho`   | Item desejado a longo prazo |

---

## ⚠️ Observações

- O banco de dados H2 é em memória — os dados são perdidos ao reiniciar o servidor
- O campo `link` e `imagem` aceitam até 1000 caracteres
- O campo `id` é gerado automaticamente pelo banco
