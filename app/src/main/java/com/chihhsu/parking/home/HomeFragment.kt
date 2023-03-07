package com.chihhsu.parking.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.chihhsu.parking.data.repository.DefaultRepository
import com.chihhsu.parking.data.repository.remote.RemoteDataSource
import com.chihhsu.parking.databinding.FragmentHomeBinding
import com.chihhsu.parking.ext.collectFlowWithLifeCycle
import com.chihhsu.parking.factory.ViewModelFactory
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
//    private val viewModel: HomeViewModel by viewModels {
//        ViewModelFactory(
//            DefaultRepository(
//                RemoteDataSource()
//            )
//        )
//    }
    private val viewModel by viewModel<HomeViewModel>()
    private lateinit var adapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        adapter = HomeAdapter()
        binding.recyclerviewHome.adapter = adapter

        collectFlowWithLifeCycle(viewModel.parkingList) {
            adapter.submitList(it)
        }

        collectFlowWithLifeCycle(viewModel.isLoading) { isLoading ->
            if (isLoading) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }

        return binding.root
    }
}

