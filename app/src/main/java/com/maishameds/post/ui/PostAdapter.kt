package com.maishameds.post.ui

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.maishameds.post.R
import com.maishameds.post.helper.CustomItemClickListener
import com.maishameds.post.model.Post

class PostAdapter(
    private val customItemClickListener: CustomItemClickListener
) : RecyclerView.Adapter<PostAdapter.MyViewHolder>() {

    private val asyncListDiffer = AsyncListDiffer(this, PostDiffCallback())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val pvh: MyViewHolder

        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        pvh = MyViewHolder(itemView)

        itemView.setOnLongClickListener { v ->
            customItemClickListener.onItemLongClick(v, pvh.adapterPosition)
            false
        }

        return pvh
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val post = asyncListDiffer.currentList[position]

        holder.title.text = post.title
        holder.user.text = "${post.userId}"
        holder.summary.text = Html.fromHtml("${post.body}")

        try {
            holder.postLayout.setOnClickListener {
                customItemClickListener.onItemClick(
                    holder.summary.text.toString(),
                    position
                )
            }
        } catch (ignore: Exception) {

        }

    }

    override fun getItemCount(): Int {
        return asyncListDiffer.currentList.size
    }

    fun setPosts(postList: List<Post>) {
        asyncListDiffer.submitList(postList)
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
        val summary: TextView = view.findViewById(R.id.summary)
        val user: TextView = view.findViewById(R.id.userId)
        val postLayout: ConstraintLayout = view.findViewById(R.id.postLayout)

    }
}
