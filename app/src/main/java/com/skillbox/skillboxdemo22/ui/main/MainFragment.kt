package com.skillbox.skillboxdemo22.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.skillbox.skillboxdemo22.Game
import com.skillbox.skillboxdemo22.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView = requireView().findViewById<TextView>(R.id.message)
        textView.text = Game.title

        val button = requireView().findViewById<Button>(R.id.button)
        button.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.container, QuestionFragment.newInstance())
                .commit()
        }
    }
}