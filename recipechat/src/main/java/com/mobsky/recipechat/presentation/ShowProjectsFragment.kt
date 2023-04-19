package com.mobsky.recipechat.presentation

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.estudos.githubshowprojects.databinding.FragmentShowProjectsBinding
import com.estudos.githubshowprojects.presentation.adapter.ShowProjectsAdapter
import com.mobsky.recipechat.presentation.util.OnEndlessScrollListener
import com.mobsky.recipechat.presentation.util.ViewerUiState
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShowProjectsFragment : Fragment() {

    private val viewModel: ShowProjectsViewModel by viewModel()
    private lateinit var binding: FragmentShowProjectsBinding
    private val showProjectsAdapter by lazy { ShowProjectsAdapter() }
    private val onEndlessScrollListener = OnEndlessScrollListener(
        loadListener = {
            showProjectsAdapter.stateLoad(true)
            viewModel.getProjects()
        }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentShowProjectsBinding.inflate(inflater, container, false).apply {
            binding = this
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvListProjects.adapter = showProjectsAdapter
        binding.rvListProjects.layoutManager = LinearLayoutManager(activity)
        binding.rvListProjects.addOnScrollListener(onEndlessScrollListener)
        showProjectsAdapter.startLoadShimmer()
        setUpObservables()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(viewModel)
    }

    private fun setUpObservables() {
        with(viewModel) {
            vrListProjectInfo.observe(viewLifecycleOwner) {
                when (it) {
                    is ViewerUiState.Loading -> Unit
                    is ViewerUiState.Success -> {
                        onEndlessScrollListener.listCount = it.value.size
                        showProjectsAdapter.submitList(it.value.toMutableList())
                    }
                    is ViewerUiState.Error -> {
                        showSnackBar(it.cause.message.orEmpty())
                        showProjectsAdapter.stateLoad(false)
                    }
                }
            }
        }
    }

    private fun showSnackBar(message: String) {
        Snackbar.make(binding.llContainer, message, Snackbar.LENGTH_LONG)
            .setAction("CLOSE") { }
            .setActionTextColor(resources.getColor(R.color.holo_red_light))
            .show()
    }
}