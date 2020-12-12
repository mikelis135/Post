package com.maishameds.post.repository

import com.maishameds.post.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RemoteRepository @Inject constructor(
    private val apiService: ApiService
) {

    fun getPosts(
        onSuccess: (order: List<Post>) -> Unit,
        onError: (error: String) -> Unit
    ) {

        apiService.posts().enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                onError("Oops, that didn't work? Please retry")
            }

            override fun onResponse(
                call: Call<List<Post>>,
                response: Response<List<Post>>
            ) {
                response.body()?.let { onSuccess(it) }
            }

        })
    }

}

