package com.example.api.application.service.impl

import com.example.api.application.service.TweetApplicationService
import com.example.api.domain.model.entity.Tweet
import com.example.api.domain.repository.TweetRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class TweetApplicationServiceImpl : TweetApplicationService {

    @Autowired
    lateinit var tweetRepository: TweetRepository

    override fun getTweets(): List<Tweet> {
        return tweetRepository.findAll()
    }

    override fun getTweet(id: Long): ResponseEntity<Tweet> {
        return tweetRepository.findById(id).map { article ->
            ResponseEntity.ok(article)
        }.orElse(ResponseEntity.notFound().build())
    }

    override fun register(tweet: Tweet): Tweet {
        return tweetRepository.save(tweet)
    }

    override fun update(id: Long, newTweet: Tweet): ResponseEntity<Tweet> {
        return tweetRepository.findById(id).map { existingArticle ->
            val updateTweet: Tweet = existingArticle
                .copy(text = newTweet.text)
            ResponseEntity.ok().body(tweetRepository.save(updateTweet))
        }.orElse(ResponseEntity.notFound().build())
    }

    override fun delete(id: Long): ResponseEntity<Void> {
        return tweetRepository.findById(id).map { article ->
            tweetRepository.delete(article)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}