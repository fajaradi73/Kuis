package com.project.fajar.kuis

class QuestionBank {

    private val textQuestions = arrayOf(
        "1. Apa warna bendera indonesia?",
        "2. siapa presiden pertama indonesia?",
        "3. siapa prseiden indonesia sekarang?",
        "4. tahun berapa indonesia merdeka",
        "5. Tahun berapa sekarang ?")

    // array of multiple choices for each question
    private val multipleChoice = arrayOf(
        arrayOf("Merah - Putih", "putih merah", "kuning", "hijau"),
        arrayOf("Soeharto", "Jokowi", "SBY", "Ir Soekarno"),
        arrayOf("Megawati", "Prabowo", "Bj Habibi", "Jokowi"),
        arrayOf("1999", "2018", "1945", "2000"),
        arrayOf("1999", "2000", "2010", "2018"))

    private val mCorrectAnswers = arrayOf("Merah - Putih", "Ir Soekarno", "Jokowi", "1945", "2018")

    val length: Int
        get() = textQuestions.size

    fun getQuestion(a: Int): String {
        return textQuestions[a]
    }

    fun getChoice(index: Int, num: Int): String {
        return multipleChoice[index][num - 1]
    }

    fun getCorrectAnswer(a: Int): String {
        return mCorrectAnswers[a]
    }
}