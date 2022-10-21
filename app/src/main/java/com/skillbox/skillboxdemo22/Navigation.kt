package com.skillbox.skillboxdemo22

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.skillbox.skillboxdemo22.ui.main.AnswerDescriptionFragment
import com.skillbox.skillboxdemo22.ui.main.EndFragment
import com.skillbox.skillboxdemo22.ui.main.MainFragment
import com.skillbox.skillboxdemo22.ui.main.QuestionFragment

object Navigation {
    fun main(fragmentManager: FragmentManager) = replace(
        fragmentManager = fragmentManager,
        fragmentClass = MainFragment::class.java,
    )

    fun end(fragmentManager: FragmentManager) = replace(
        fragmentManager = fragmentManager,
        fragmentClass = EndFragment::class.java,
    )

    fun question(fragmentManager: FragmentManager, questionId: Int) = replace(
        fragmentManager = fragmentManager,
        fragmentClass = QuestionFragment::class.java,
        args = QuestionFragment.bundle(questionId = questionId),
    )

    fun answer(
        fragmentManager: FragmentManager,
        questionId: Int,
        answer: String,
    ) = replace(
        fragmentManager,
        AnswerDescriptionFragment::class.java,
        AnswerDescriptionFragment.bundle(
            questionId = questionId,
            answer = answer,
        )
    )

    private fun replace(
        fragmentManager: FragmentManager,
        fragmentClass: Class<out Fragment?>,
        args: Bundle? = null,
    ) {
        fragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.slide_in, R.anim.fade_out)
            .replace(R.id.container, fragmentClass, args)
            .commit()
    }
}