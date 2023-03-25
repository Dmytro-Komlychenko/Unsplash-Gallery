package com.example.presentation.screens.imagelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.presentation.models.Post
import com.example.unsplash_gallery.R
import com.example.unsplash_gallery.databinding.ImageListItemBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel

class PostItemAdapter(
    private val posts: List<Post>
) : RecyclerView.Adapter<PostItemAdapter.ViewHolder>() {

    private lateinit var holder: ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        holder = ViewHolder(
            ImageListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]
        holder.bind(post)
    }

    override fun getItemCount(): Int = posts.size

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        holder.dateTimeScope.cancel()
    }

    inner class ViewHolder(private val binding: ImageListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val dateTimeScope = CoroutineScope(Dispatchers.Default)

        fun bind(post: Post) = with(binding) {
            tvAuthor.text = post.authorName
            tvName.text = post.description
            Glide.with(binding.root).load(post.image_url).into(imageView)
            bindNavigationToNoteFragment(post)
        }

        private fun bindNavigationToNoteFragment(post: Post) {
            binding.imageView.setOnClickListener {
                it.findNavController().navigate(
                    R.id.action_imageListFragment_to_imageFragment,
                    bundleOf(IMAGE_ACTION to post.image_url)
                )
            }
        }
    }

    companion object {
        const val IMAGE_ACTION = "IMAGE_ACTION"
    }
}