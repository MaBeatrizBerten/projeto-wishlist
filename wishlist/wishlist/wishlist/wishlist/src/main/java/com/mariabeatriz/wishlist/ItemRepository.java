package com.mariabeatriz.wishlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório responsável pela comunicação com o banco de dados.
 * Herda os métodos básicos do JpaRepository como findAll, save, deleteById, etc.
 * O Spring cria a implementação automaticamente — não precisamos escrever SQL.
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
