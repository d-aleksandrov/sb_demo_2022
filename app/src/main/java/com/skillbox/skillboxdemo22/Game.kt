package com.skillbox.skillboxdemo22

object Game {
    val title = "День сурка"
    val startQuestion = 1
    val finish = -1
    val questions: List<Question> = listOf(
        Question(
            id = 1,
            title = "Я проснулся. Чувствую себя разбитым, и совсем ничего не помню...",
            hint = "Если в течение дня заниматься безделием, ничего не изменится",
            answers = listOf(
                Answer(
                    title = "Встать с кровати и умыться",
                    questionId = 2,
                    description = "Надо попытаться вспомнить, что же произошло",
                ),
                Answer(
                    title = "Попытаться заснуть снова",
                    questionId = null,
                    description = "Сон - это хорошо",
                ),
                Answer(
                    title = "Пролежать весь день с телефоном",
                    questionId = null,
                    description = "Плохая идея, глазки выпадут",
                ),
            ),
        ),
        Question(
            id = 2,
            title = "Чем заняться чтобы взбодриться и вспонить что я делал вчера?",
            hint = "",
            answers = listOf(
                Answer(
                    title = "Кофе",
                    questionId = null,
                    description = "Я бодр, но вспомнить ничего не могу",
                ),
                Answer(
                    title = "Газета",
                    questionId = -1,
                    description = "ОГО! Да это же я на главной странице!",
                ),
                Answer(
                    title = "Red Bull",
                    questionId = null,
                    description = "Я бодр, но вспомнить ничего не могу",
                ),
            ),
        )
    )
}