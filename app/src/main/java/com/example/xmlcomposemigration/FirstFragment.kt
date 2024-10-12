package com.example.xmlcomposemigration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.xmlcomposemigration.composable.FirstScreen
import com.example.xmlcomposemigration.composable.FirstViewModel

class FirstFragment : Fragment() {

    private lateinit var _composeView : ComposeView
    private val viewModel : FirstViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).also {
            _composeView = it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _composeView.setContent {
            val state by viewModel.state.collectAsState()
            FirstScreen(
                firstState = state,
                onAction = {
                    findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
                }
            )
        }
    }
}