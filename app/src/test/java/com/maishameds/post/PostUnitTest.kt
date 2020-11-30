package com.maishameds.post

import com.maishameds.post.model.Post
import org.junit.Assert.assertEquals
//import org.junit.Assert.assertNotEquals
import org.junit.Test

class PostUnitTest {

    @Test
    fun task_withCorrectInput() {

        val taskBody = "the body"

        val post = Post(0, 12, "title", "the body")

        assertEquals(post.id, 12)
        assertEquals(post.body, taskBody)
    }

    @Test
    fun task_withInCorrectInput() {

        val postId = 123

        val post = Post(0, 123, "title", "body")

        //change the post id to another id, and of Post id in the Post class to 'var' and use assertNotEquals to test this
//        post.id = 123

        assertEquals(post.id, postId)

//        assertNotEquals(post.id, postId)
    }

}