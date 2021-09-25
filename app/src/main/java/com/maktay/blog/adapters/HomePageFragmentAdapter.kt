package com.maktay.blog.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.maktay.blog.R
import com.maktay.blog.model.Post

class HomePageFragmentAdapter(private val posts: List<Post>, val context: Context) :
    RecyclerView.Adapter<HomePageFragmentAdapter.ModelViewHolder>() {
    class ModelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = view.findViewById(R.id.tv_title)
        private val content: TextView = view.findViewById(R.id.tv_content)
        private val author: TextView = view.findViewById(R.id.tv_author)
        private val date: TextView = view.findViewById(R.id.tv_date)

        fun bindItems(post: Post) {
            title.text = post.title
            content.text = post.body
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ModelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return ModelViewHolder(view)
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        holder.bindItems(posts[position])
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}