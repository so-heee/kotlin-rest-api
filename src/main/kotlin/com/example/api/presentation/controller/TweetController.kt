package com.example.api.presentation.controller

import com.example.api.application.service.TweetApplicationService
import com.example.api.domain.model.entity.Tweet
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class TweetController() {

    @Autowired
    lateinit var tweetApplicationService: TweetApplicationService

    @GetMapping("/tweets")
    fun getTweets(): List<Tweet> {
        return tweetApplicationService.getTweets()
    }

    @GetMapping("/tweets/{id}")
    fun getTweetsById(@PathVariable(value = "id") id: Long): ResponseEntity<Tweet> {
        return tweetApplicationService.getTweet(id)
    }

    @PostMapping("/tweets")
    fun createTweet(@Valid @RequestBody tweet: Tweet): Tweet {
        return tweetApplicationService.register(tweet)
    }

    @PutMapping("/tweets/{id}")
    fun updateTweet(
        @PathVariable(value = "id") id: Long,
        @Valid @RequestBody newTweet: Tweet
    ): ResponseEntity<Tweet> {
        return tweetApplicationService.update(id, newTweet)
    }

    @DeleteMapping("/tweets/{id}")
    fun deleteTweet(@PathVariable(value = "id") id: Long): ResponseEntity<Void> {
        return tweetApplicationService.delete(id)
    }
}