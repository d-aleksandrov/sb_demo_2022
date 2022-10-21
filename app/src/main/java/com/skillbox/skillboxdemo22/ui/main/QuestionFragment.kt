package com.skillbox.skillboxdemo22.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.skillbox.skillboxdemo22.Answer
import com.skillbox.skillboxdemo22.Game
import com.skillbox.skillboxdemo22.Navigation
import com.skillbox.skillboxdemo22.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {
    lateinit var binding: FragmentQuestionBinding
    var questionId: Int = 0

    companion object {
        fun bundle(questionId: Int): Bundle {
            val bundle = Bundle()
            bundle.putInt("QUESTION_ID", questionId)
            return bundle
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuestionBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        questionId = requireArguments().getInt("QUESTION_ID")
        val question = Game.questions.first { quest -> quest.id == questionId }

        binding.textView.text = question.title

        binding.hint.setOnClickListener {
            Snackbar.make(
                binding.root,
                question.hint,
                Snackbar.LENGTH_LONG,
            ).show()
        }

        listOf(
            binding.answer1,
            binding.answer2,
            binding.answer3,
        ).forEachIndexed { index, button ->
            initButton(button, answer = question.answers[index])
        }
    }

    private fun initButton(button: Button, answer: Answer) {
        button.text = answer.title
        button.setOnClickListener {
            Navigation.answer(
                fragmentManager = parentFragmentManager,
                questionId = questionId,
                answer = answer.title,
            )
        }
    }
}