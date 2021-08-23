package cl.cutiko.fragmentlistener

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult

class ExampleDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return TextView(requireContext()).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            text = "EXAMPLE DIALOG FRAGMENT"
            gravity = Gravity.CENTER
            setTextColor(
                ContextCompat.getColor(this.context, android.R.color.holo_blue_dark)
            )
            setBackgroundResource(android.R.color.white)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setOnClickListener {
            setFragmentResult(KEY, bundleOf(KEY to true))
            dismiss()
        }
    }

    companion object {
        const val KEY = "SUPER_COOL_KEY"
    }

}