package cl.cutiko.fragmentlistener

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import cl.cutiko.fragmentlistener.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFragmentResultListener(ExampleDialogFragment.KEY) { key, bundle ->
            findNavController().navigate(R.id.action_FirstFragment_to_secondFragment)
        }
        binding.buttonFirst.setOnClickListener {
            ExampleDialogFragment().show(parentFragmentManager, ExampleDialogFragment.KEY)
        }
        binding.buttonFirst.setOnLongClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_dialog_nav_graph)
            true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}