package com.mariabeatriz.wishlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

/**
 * Controlador REST responsável por gerenciar os itens da wishlist.
 * Define as rotas da API e coordena as operações com o banco de dados.
 */

@CrossOrigin(origins = "*")
// @RestController: define que esta classe é o 'Garçom' da API (Controlador REST).
// Ela recebe os pedidos (requisições) e devolve as respostas em formato JSON (texto padronizado).
@RestController

// @RequestMapping: define a URL base (o endereço) para acessar os recursos desta classe.
// Qualquer pedido que comece com "http://localhost:8080/itens" vai cair aqui.
@RequestMapping("/itens")
public class ItemController {

    // @Autowired: faz a injeção de dependência automática do Spring.
    // É como um interfone que conecta o 'Garçom' (Controller) diretamente ao 'Cozinheiro' (Repository).
    @Autowired
    private ItemRepository itemRepository;

    /**
     * Retorna todos os itens cadastrados na wishlist.
     * @return lista de itens em formato JSON
     */
    // @GetMapping: indica que este metodo responde a pedidos do tipo GET (buscar/listar dados).
    // Como está sem caminho extra, ele responde diretamente na URL base: /itens
    @GetMapping
    public List<Item> listarTodos() {
        // itemRepository.findAll(): o Garçom pede ao Cozinheiro para buscar todos os itens.
        // O Repository vai ao banco de dados 'H2', pega tudo o que encontrar e nos devolve.
        return itemRepository.findAll();
    }

    /**
     * Cadastra um novo item na wishlist.
     * @param item objeto Item recebido no corpo da requisição
     * @return item cadastrado com id gerado automaticamente
     */
    @PostMapping //diz que esse metodo responde a requisições POST no endereço /itens
    public Item salvar(@RequestBody Item item) { // pega o JSON que vai vir na requisição e transforma em um objeto Item
        return itemRepository.save(item); // salva o item no banco de dados e retorna ele com o id gerado
    }

    /**
     * Remove um item da wishlist pelo id.
     * @param id identificador do item a ser removido
     */
    @DeleteMapping("/{id}") //responde em /itens/1, /itens/2, etc.
    public void deletar(@PathVariable Long id) { //pega o número que vem na URL e usa como id
        itemRepository.deleteById(id); //apaga o item com aquele id do banco
    }

    /**
     * Atualiza os dados de um item existente.
     * @param id identificador do item a ser atualizado
     * @param itemAtualizado objeto com os novos dados
     * @return item atualizado
     */
    @PutMapping("/{id}") // responde em /itens/1, /itens/2, etc.
    public Item atualizar(@PathVariable Long id, @RequestBody Item itemAtualizado) { // pega o id da URL e o JSON com os novos dados
        Item item = itemRepository.findById(id).orElseThrow(); // busca o item no banco pelo id
        item.setNome(itemAtualizado.getNome());
        item.setPreco(itemAtualizado.getPreco());
        item.setLink(itemAtualizado.getLink());
        item.setPrioridade(itemAtualizado.getPrioridade());
        item.setImagem(itemAtualizado.getImagem()); // atualiza todos os campos
        return itemRepository.save(item); // salva as alterações e retorna o item atualizado
    }
}
