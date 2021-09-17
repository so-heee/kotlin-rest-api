package com.example.kotlinrestapi.presentation.controller

import com.example.kotlinrestapi.application.repository.ArticleRepository
import com.example.kotlinrestapi.infrastructure.jpa.entity.Article
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class ArticleController(private val articleRepository: ArticleRepository) {

    @GetMapping("/articles")
    fun getAllArticles(): List<Article> =
        articleRepository.findAll()

    @PostMapping("/articles")
    fun createArticle(@Valid @RequestBody article: Article): Article =
        articleRepository.save(article)

    @GetMapping("/articles/{id}")
    fun getArticleById(@PathVariable(value = "id") id: Long): ResponseEntity<Article> {
        return articleRepository.findById(id).map { article ->
            ResponseEntity.ok(article)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/articles/{id}")
    fun updateArticle(
        @PathVariable(value = "id") id: Long,
        @Valid @RequestBody newArticle: Article
    ): ResponseEntity<Article> {

        return articleRepository.findById(id).map { existingArticle ->
            val updateArticle: Article = existingArticle
                .copy(title = newArticle.title, content = newArticle.content)
            ResponseEntity.ok().body(articleRepository.save(updateArticle))
        }.orElse(ResponseEntity.notFound().build())

    }

    @DeleteMapping("/articles/{id}")
    fun deleteArticle(@PathVariable(value = "id") id: Long): ResponseEntity<Void> {

        return articleRepository.findById(id).map { article ->
            articleRepository.delete(article)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}