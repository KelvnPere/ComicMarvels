package com.example.comicmarvels.ui.comic

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.comicmarvels.MainActivity
import com.example.comicmarvels.R
import com.example.comicmarvels.ui.adapter.ComicsAdapter
import com.example.comicmarvels.ui.viewmodel.ComicViewModel
import com.example.comicmarvels.utils.Resource
import kotlinx.android.synthetic.main.fragment_comics.*

class ComicsFragment : Fragment() {

    private lateinit var viewModel: ComicViewModel
    private lateinit var comicsAdapter: ComicsAdapter


    val TAG = "ComicFrag"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



       viewModel = (activity as MainActivity).viewModel
        recyclerView()

        comicsAdapter.setOnItemClicklistener {
            val bundle = Bundle().apply {
                putSerializable("comic",it)
            }
            findNavController().navigate(
                R.id.action_comicsFragment_to_comicDetailFragment,
                bundle
            )
        }

        viewModel.comics.observe(viewLifecycleOwner, Observer { response ->
            when(response) {
                is Resource.Success ->{
                    hideProgressBar()
                    response.data?.let {  comicsResponse ->
                        comicsAdapter.differ.submitList(comicsResponse.data?.results)
                        comicsAdapter.notifyDataSetChanged()
                        Log.i(TAG, "Error is: $comicsResponse")

                    }
                }
                is Resource.Error ->{
                    hideProgressBar()
                    response.message?.let { message ->
                        Log.e(TAG, "Error is: $message")
                    }
                }
                is Resource.Loading ->{
                    showProgressBar()
                }
            }
        })
    }

    private fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    private fun recyclerView(){
        comicsAdapter = ComicsAdapter()
        rvComics.apply {
            adapter = comicsAdapter
            comicsAdapter.notifyDataSetChanged()
            layoutManager = GridLayoutManager(activity, 4, GridLayoutManager.HORIZONTAL,false)
        }
    }




}