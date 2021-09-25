package com.maktay.blog.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.maktay.blog.R
import com.maktay.blog.adapters.HomePageFragmentAdapter
import com.maktay.blog.model.Post
import com.maktay.blog.services.Client
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePageFragment : Fragment() {
    private lateinit var recyclerView : RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.postRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        getPosts()
    }

    private fun getPosts() {
        Client.getApiService().getPosts().enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
            }
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val posts: List<Post>? = response.body()
                recyclerView.adapter = posts?.let { HomePageFragmentAdapter(it, context!!) }
            }
        })
    }
}