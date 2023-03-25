package com.example.presentation.screens.image

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.presentation.screens.imagelist.PostItemAdapter
import com.example.unsplash_gallery.databinding.FragmentImageBinding

class ImageFragment : Fragment() {

    private var _binding: FragmentImageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImageBinding.inflate(layoutInflater)

        Glide.with(binding.root).load(arguments?.getString(PostItemAdapter.IMAGE_ACTION))
            .into(binding.imageView)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}