package com.maishameds.post.ui

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.maishameds.post.R
import com.maishameds.post.app.App
import com.maishameds.post.helper.CustomItemClickListener
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        (application as App).appComponent.inject(this)

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        postAdapter = setUpRecyclerView()

        findViewById<RecyclerView>(R.id.postRecycler).apply {
            setItemViewCacheSize(100)
            setHasFixedSize(true)
        }

        findViewById<RecyclerView>(R.id.postRecycler).adapter = postAdapter

        findViewById<SwipeRefreshLayout>(R.id.postRefresh).setOnRefreshListener {
            viewModel.getPosts()
        }

        viewModel.postLiveData.observe(this, Observer {

            findViewById<SwipeRefreshLayout>(R.id.postRefresh).isRefreshing = false

            if (it.isEmpty()) {
                findViewById<TextView>(R.id.errorTxt).animate().alpha(1.0f)
            } else {
                findViewById<TextView>(R.id.errorTxt).animate().alpha(0.0f)
            }

            postAdapter.setPosts(it)

            findViewById<RecyclerView>(R.id.postRecycler).adapter = postAdapter

        })

        viewModel.errorLiveData.observe(this, Observer {

            findViewById<SwipeRefreshLayout>(R.id.postRefresh).isRefreshing = false

            it?.let {
                if (it) {
                    findViewById<TextView>(R.id.errorTxt).animate().alpha(1.0f)
                } else {
                    findViewById<TextView>(R.id.errorTxt).animate().alpha(0.0f)
                }
            }

        })
    }

    private fun setUpRecyclerView(): PostAdapter {

        return PostAdapter(object : CustomItemClickListener {

            override fun <T> onItemClick(item: T, position: Int) {
                val summary = item as String
                Toast.makeText(baseContext, summary, Toast.LENGTH_LONG).show()
            }

            override fun onItemLongClick(v: View, position: Int) {
            }
        })

    }
}