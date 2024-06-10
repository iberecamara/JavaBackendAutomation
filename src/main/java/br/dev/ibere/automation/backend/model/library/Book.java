package br.dev.ibere.automation.backend.model.library;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Data
@Entity
@Builder
@Table(name = "book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String author;

    private String category;

}
