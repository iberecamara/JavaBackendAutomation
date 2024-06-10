package br.dev.ibere.automation.backend.database.config;

import br.dev.ibere.automation.backend.model.library.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface BookRepository extends JpaRepository<Book, Long> {

    Book save(Book product);

    Optional<Book> findById(Long id);

    Book findByTitle(String title);

    Book findByAuthor(String author);

    List<Book> findByCategory(String category);

}
