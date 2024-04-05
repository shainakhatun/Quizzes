package com.example.quizzes

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var questionTextView: TextView
    private lateinit var option1Button: Button
    private lateinit var option2Button: Button
    private lateinit var option3Button: Button
    private lateinit var button: Button

    private val questions = arrayOf(
        "Question 1",
        "Question 2",
        "Question 3"
    )

    private val answers = arrayOf(
        "Answer 1",
        "Answer 2",
        "Answer 3"
    )

    private var currentQuestionIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionTextView = findViewById(R.id.questionTextView)
        option1Button = findViewById(R.id.option1Button)
        option2Button = findViewById(R.id.option2Button)
        option3Button = findViewById(R.id.option3Button)

        displayQuestion()

        option1Button.setOnClickListener { checkAnswer(option1Button.text.toString()) }
        option2Button.setOnClickListener { checkAnswer(option2Button.text.toString()) }
        option3Button.setOnClickListener { checkAnswer(option3Button.text.toString()) }
    }

    private fun displayQuestion() {
        questionTextView.text = questions[currentQuestionIndex]
        option1Button.text = answers[currentQuestionIndex]
        option2Button.text = answers[currentQuestionIndex + 1]
        option3Button.text = answers[currentQuestionIndex + 2]
    }

    private fun checkAnswer(selectedAnswer: String) {
        val correctAnswer = answers[currentQuestionIndex]
        if (selectedAnswer == correctAnswer) {
            // Increment score or perform any other action for correct answer
        }

        // Move to the next question
        currentQuestionIndex++
        if (currentQuestionIndex < questions.size) {
            displayQuestion()
        } else {
            // Quiz completed, display results or navigate to another screen
        }
    }
}