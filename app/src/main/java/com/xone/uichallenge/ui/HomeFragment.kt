package com.xone.uichallenge.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xone.uichallenge.databinding.FragmentHomeBinding
import com.xone.uichallenge.models.ModelClass
import com.xone.uichallenge.ui.adapter.PhotoAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        homeViewModel.photoObservable.observe(viewLifecycleOwner) {
            setupImdbRecyclerView(it, binding.recyclerView)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.getPhotos()
    }

    private fun setupImdbRecyclerView(
        photos: List<List<ModelClass.ModelClassItem>>,
        recyclerView: RecyclerView,
    ) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//            val manager = SpannedGridLayoutManager(object : SpannedGridLayoutManager.GridSpanLookup{
//                override fun getSpanInfo(position: Int): SpannedGridLayoutManager.SpanInfo {
//                    // Conditions for 2x2 items
//                    return if (position % 12 == 0 || position % 12 == 7) {
//                        SpannedGridLayoutManager.SpanInfo(2, 2)
//                    } else {
//                        SpannedGridLayoutManager.SpanInfo(1, 1)
//                    }
//                }
//
//            },3/*column*/,1f/*how big is default item*/)
//            layoutManager = layoutManager1
//            layoutManager = StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)
            adapter = PhotoAdapter(photos)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}