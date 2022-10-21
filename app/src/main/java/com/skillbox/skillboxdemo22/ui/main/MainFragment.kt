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
            val bundle = QuestionFragment.bundle(questionId = Game.startQuestion)

            parentFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.slide_in, R.anim.fade_out)
                .replace(R.id.container, QuestionFragment::class.java, bundle)
                .commit()
        }
    }
}