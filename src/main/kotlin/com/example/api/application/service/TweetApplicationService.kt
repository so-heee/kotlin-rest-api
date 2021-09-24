package com.example.api.application.service

import com.example.api.domain.model.entity.Tweet
import org.springframework.http.ResponseEntity


interface TweetApplicationService {

    /**
     * 一覧取得
     * @return List<Tweet>
     */
    fun getTweets(): List<Tweet>

    /**
     * 取得
     * @param id
     * @return ResponseEntity<Tweet>
     */
    fun getTweet(id: Long): ResponseEntity<Tweet>

    /**
     * 登録
     * @param tweet
     * @return Tweet
     */
    fun register(tweet: Tweet): Tweet

    /**
     * 更新
     * @param id
     * @param newTweet
     * @return ResponseEntity<Tweet>
     */
    fun update(id: Long, newTweet: Tweet): ResponseEntity<Tweet>

    /**
     * 削除
     * @param id
     * @return ResponseEntity<Void>
     */
    fun delete(id: Long): ResponseEntity<Void>
}