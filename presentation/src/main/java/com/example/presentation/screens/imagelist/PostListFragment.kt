package com.example.presentation.screens.imagelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.presentation.app.App
import com.example.presentation.models.Post
import com.example.unsplash_gallery.databinding.FragmentImageListBinding
import javax.inject.Inject


class PostListFragment : Fragment() {

    private var _binding: FragmentImageListBinding? = null
    private val binding get() = _binding!!

    private var adapter: PostItemAdapter? = null

    private lateinit var viewModel: PostListViewModel

    @Inject
    lateinit var postListViewModelFactory: PostListViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImageListBinding.inflate(layoutInflater)

        (activity?.applicationContext as App).appComponent.inject(this)
        viewModel = ViewModelProvider(this, postListViewModelFactory)[PostListViewModel::class.java]

        viewModel.posts.observe(viewLifecycleOwner) {
            initAdapter()
        }

        return binding.root
    }

    private fun initAdapter() {
        viewModel.posts.value!!.data.let {
            if (viewModel.posts.value!!.data.isNotEmpty()) {
                adapter = PostItemAdapter(viewModel.posts.value!!.data!! as List<Post>)
                binding.recyclerView.layoutManager = GridLayoutManager(context, COLUMNS)
                binding.recyclerView.adapter = adapter

            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val COLUMNS = 2
    }
}