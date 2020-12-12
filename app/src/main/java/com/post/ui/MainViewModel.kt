package com.maishameds.post.ui

import android.net.ConnectivityManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maishameds.post.model.Post
import com.maishameds.post.repository.RemoteRepository
import kotlinx.coroutines.launch
import java.lang.Boolean.FALSE
import java.lang.Boolean.TRUE
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val connectivityManager: ConnectivityManager
) :
    ViewModel() {

    var errorLiveData = MutableLiveData<Boolean>()
    var postLiveData = MutableLiveData<List<Post>>()

    init {
        getPosts()
    }

    fun getPosts() {

        when (connectivityManager.activeNetworkInfo?.isConnectedOrConnecting == TRUE) {
            TRUE -> viewModelScope.launch {
                remoteRepository.getPosts({

                    postLiveData.value = it

                }, {

                })
            }
            FALSE -> errorLiveData.value = false
        }

    }

}