package com.example.api.presentation.controller

import com.example.api.application.service.ArticleApplicationService
import com.example.api.domain.model.entity.Article
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class ArticleController() {

    @Autowired
    lateinit var articleApplicationService: ArticleApplicationService

    @GetMapping("/articles")
    fun getArticles(): List<Article> {
        return articleApplicationService.getArticles()
    }

    @GetMapping("/articles/{id}")
    fun getArticleById(@PathVariable(value = "id") id: Long): ResponseEntity<Article> {
        return articleApplicationService.getArticle(id)
    }

    @PostMapping("/articles")
    fun createArticle(@Valid @RequestBody article: Article): Article {
        return articleApplicationService.register(article)
    }

    @PutMapping("/articles/{id}")
    fun updateArticle(
        @PathVariable(value = "id") id: Long,
        @Valid @RequestBody newArticle: Article
    ): ResponseEntity<Article> {
        return articleApplicationService.update(id, newArticle)
    }

    @DeleteMapping("/articles/{id}")
    fun deleteArticle(@PathVariable(value = "id") id: Long): ResponseEntity<Void> {
        return articleApplicationService.delete(id)
    }
}