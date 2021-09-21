package com.example.api.application.service.impl

import com.example.api.application.service.ArticleApplicationService
import com.example.api.domain.model.entity.Article
import com.example.api.domain.repository.ArticleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class ArticleApplicationServiceImpl : ArticleApplicationService {

    @Autowired
    lateinit var articleRepository: ArticleRepository

    override fun getArticles(): List<Article> {
        return articleRepository.findAll()
    }

    override fun getArticle(id: Long): ResponseEntity<Article> {
        return articleRepository.findById(id).map { article ->
            ResponseEntity.ok(article)
        }.orElse(ResponseEntity.notFound().build())
    }

    override fun register(article: Article): Article {
        return articleRepository.save(article)
    }

    override fun update(id: Long, newArticle: Article): ResponseEntity<Article> {
        return articleRepository.findById(id).map { existingArticle ->
            val updateArticle: Article = existingArticle
                .copy(title = newArticle.title, content = newArticle.content)
            ResponseEntity.ok().body(articleRepository.save(updateArticle))
        }.orElse(ResponseEntity.notFound().build())
    }

    override fun delete(id: Long): ResponseEntity<Void> {
        return articleRepository.findById(id).map { article ->
            articleRepository.delete(article)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}