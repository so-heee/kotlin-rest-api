package com.example.api.application.service

import com.example.api.domain.model.entity.Article
import org.springframework.http.ResponseEntity


interface ArticleApplicationService {

    /**
     * 記事の一覧取得
     * @return List<Article>
     */
    fun getArticles(): List<Article>

    /**
     * 記事の取得
     * @param id
     * @return ResponseEntity<Article>
     */
    fun getArticle(id: Long): ResponseEntity<Article>

    /**
     * 記事の登録
     * @param article
     * @return Article
     */
    fun register(article: Article): Article

    /**
     * 記事の更新
     * @param id
     * @param newArticle
     * @return ResponseEntity<Article>
     */
    fun update(id: Long, newArticle: Article): ResponseEntity<Article>

    /**
     * 記事の削除
     * @param id
     * @return ResponseEntity<Void>
     */
    fun delete(id: Long): ResponseEntity<Void>
}