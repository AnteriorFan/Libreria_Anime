package com.gabo.libreriaAnime;

import com.gabo.libreriaAnime.main.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibreriaAnimeApplication implements CommandLineRunner {

	private final Principal principal;
	@Autowired
	public LibreriaAnimeApplication(Principal principal) {
        this.principal = principal;
    }

	public static void main(String[] args) {

		SpringApplication.run(LibreriaAnimeApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		principal.menu();
	}

}
