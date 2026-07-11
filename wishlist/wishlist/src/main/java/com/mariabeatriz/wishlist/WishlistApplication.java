package com.mariabeatriz.wishlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal da aplicação Wishlist.
 * Responsável por inicializar o Spring Boot e subir o servidor.
 */
@SpringBootApplication
public class WishlistApplication {

	/**
	 * Ponto de entrada da aplicação.
	 * @param args argumentos de linha de comando
	 */
	public static void main(String[] args) {
		SpringApplication.run(WishlistApplication.class, args);


	}
}
