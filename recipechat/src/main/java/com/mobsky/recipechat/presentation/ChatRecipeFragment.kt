package com.mobsky.recipechat.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.mobsky.recipechat.presentation.view.ScreenRecipe
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChatRecipeFragment : Fragment() {

    private val viewModel: ChatRecipeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                ScreenRecipe("teste")
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservables()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       lifecycle.addObserver(viewModel)
    }

    private fun setUpObservables() {
//        with(viewModel) {
//
//        }
    }

    private fun showSnackBar(message: String) {
//        Snackbar.make(binding.llContainer, message, Snackbar.LENGTH_LONG)
//            .setAction("CLOSE") { }
//            .setActionTextColor(resources.getColor(R.color.holo_red_light))
//            .show()
    }
}