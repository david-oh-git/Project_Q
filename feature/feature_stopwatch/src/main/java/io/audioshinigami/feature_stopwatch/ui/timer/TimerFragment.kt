package io.audioshinigami.feature_stopwatch.ui.timer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import io.audioshinigami.feature_stopwatch.R
import io.audioshinigami.feature_stopwatch.databinding.FragmentTimerBinding


/**
 * Timer [Fragment] .
 *
 */
class TimerFragment : Fragment() {

    private val viewModel by viewModels<TimerViewModel> {
        TimerViewModelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentTimerBinding.inflate(inflater, container, false)
            .apply {
                lifecycleOwner = viewLifecycleOwner
                vm = viewModel
            }
        return binding.root
    }

}