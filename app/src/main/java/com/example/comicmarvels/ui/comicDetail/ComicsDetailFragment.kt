package com.example.comicmarvels.ui.comicDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.comicmarvels.MainActivity
import com.example.comicmarvels.R
import com.example.comicmarvels.data.model.Comic
import com.example.comicmarvels.databinding.FragmentComicsDetailBinding
import com.example.comicmarvels.ui.viewmodel.ComicViewModel
import com.example.comicmarvels.utils.autoCleared


class ComicsDetailFragment : Fragment() {

    private var binding: FragmentComicsDetailBinding by autoCleared()
    private lateinit var viewModel: ComicViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentComicsDetailBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = (activity as MainActivity).viewModel
        val comics = arguments?.getSerializable("comic")
        setup(comics as Comic)

    }

    private fun setup(comic: Comic) {
        binding.detailTitle.text = comic.title
        binding.detailExplanation.text = comic.description
        activity?.let {
            val requestOptions = RequestOptions()
            requestOptions.placeholder(R.drawable.images)
            requestOptions.error(R.drawable.images)
            Glide.with(this)
                .load("${comic.thumbnail?.path}.${comic.thumbnail?.extension}")
                .apply(requestOptions)
                .placeholder(R.drawable.images)
                .into(binding.detailImage)
        }
    }
}