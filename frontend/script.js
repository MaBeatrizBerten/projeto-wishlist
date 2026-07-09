const API_URL = "http://localhost:8080/itens";

// Busca e exibe os itens da API
async function carregarItens() {
  try {
    const response = await fetch(API_URL);
    const itens = await response.json();

    atualizarStats(itens);
    renderizarCards(itens);
  } catch (erro) {
    console.error("Erro ao carregar itens:", erro);
  }
}

// Atualiza os números no topo
function atualizarStats(itens) {
  document.getElementById("total-itens").textContent = itens.length;

  const urgentes = itens.filter((i) => i.prioridade === "Urgente").length;
  document.getElementById("total-urgentes").textContent = urgentes;

  const total = itens.reduce((soma, i) => soma + i.preco, 0);
  document.getElementById("total-valor").textContent = total.toLocaleString(
    "pt-BR",
    { style: "currency", currency: "BRL" },
  );
}

// Cria os cards na tela
function renderizarCards(itens) {
  const lista = document.getElementById("lista-itens");
  lista.innerHTML = "";

  if (itens.length === 0) {
    lista.innerHTML =
      '<p style="color:#8b7a65; font-size:14px;">Nenhum desejo ainda. Adicione o primeiro! 🌿</p>';
    return;
  }

  itens.forEach((item) => {
    const card = document.createElement("article");
    card.className = "wish-card";
    card.innerHTML = `
      <div class="card-img-wrapper">
        <img
            src="${item.imagem || "img/soot-sprite.png"}"
            alt="${item.nome}"
            onerror="this.src='img/soot-sprite.png'"
        />
      </div>
      <div class="card-body">
        <h3 class="card-title">${item.nome}</h3>
        <p class="card-price">${item.preco.toLocaleString("pt-BR", { style: "currency", currency: "BRL" })}</p>
        <span class="card-badge ${getBadgeClass(item.prioridade)}">${item.prioridade || "Sem prioridade"}</span>
        ${item.link ? `<a href="${item.link}" target="_blank" class="card-link">🔗 Ver produto</a>` : ""}
        <div class="card-actions">
          <button class="btn-delete" onclick="deletarItem(${item.id})">🗑️</button>
        </div>
      </div>
    `;
    lista.appendChild(card);
  });
}

// Salva novo item
async function salvarItem() {
  const nome = document.getElementById("nome").value.trim();
  const preco = parseFloat(document.getElementById("preco").value);
  const link = document.getElementById("link").value.trim();
  const imagem = document.getElementById("imagem").value.trim();
  const prioridade = document.getElementById("prioridade").value.trim();

  if (!nome || isNaN(preco)) {
    alert("Preencha pelo menos o nome e o preço! 🌿");
    return;
  }

  const novoItem = { nome, preco, link, imagem, prioridade };

  try {
    await fetch(API_URL, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(novoItem),
    });

    // Limpa os campos
    document.getElementById("nome").value = "";
    document.getElementById("preco").value = "";
    document.getElementById("link").value = "";
    document.getElementById("imagem").value = "";
    document.getElementById("prioridade").value = "";

    carregarItens();
  } catch (erro) {
    console.error("Erro ao salvar:", erro);
  }
}

// Deleta item
async function deletarItem(id) {
  if (!confirm("Remover este desejo da floresta? 🍂")) return;

  try {
    await fetch(`${API_URL}/${id}`, { method: "DELETE" });
    carregarItens();
  } catch (erro) {
    console.error("Erro ao deletar:", erro);
  }
}

function getBadgeClass(prioridade) {
  if (!prioridade) return "badge-default";
  const p = prioridade.toLowerCase();
  if (p === "urgente") return "badge-urgente";
  if (p === "média" || p === "media") return "badge-media";
  if (p === "sonho") return "badge-sonho";
  return "badge-default";
}

// Carrega ao abrir a página
carregarItens();
