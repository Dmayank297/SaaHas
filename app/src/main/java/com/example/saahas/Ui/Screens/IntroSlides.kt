package com.example.saahas.Ui.Screens

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.TranslateAnimation
import android.widget.Button
import androidx.cardview.widget.CardView
import com.example.saahas.MainActivity
import com.example.saahas.R

private lateinit var cards: List<CardView>
    private var currentIndex = -1
    private val edgePadding = 50f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nextButton: Button = findViewById(R.id.nextButton)

        // Initialize card views
        val card1: CardView = findViewById(R.id.card1)
        val card2: CardView = findViewById(R.id.card2)
        val card3: CardView = findViewById(R.id.card3)
        val card4: CardView = findViewById(R.id.card4)

        cards = listOf(card1, card2, card3, card4)


        nextButton.setOnClickListener {
            if (currentIndex < cards.size - 1) {
                showNextCard()
            } else {

                openNextActivity()
            }
        }
    }

    private fun showNextCard() {
        if (currentIndex < cards.size - 1) {
            currentIndex++

            val currentCard = cards[currentIndex]
            val direction = if (currentIndex % 2 == 0) -1 else 1

            slideIn(currentCard, direction)
        }
    }

    private fun slideIn(card: View, direction: Int) {
        card.visibility = View.VISIBLE

        val startX = direction * (card.width.toFloat() + edgePadding)
        val endX = direction * edgePadding

        val animation = TranslateAnimation(
            startX,
            endX,
            0f,
            0f
        ).apply {
            duration = 500
            fillAfter = true
        }
        card.startAnimation(animation)
    }

    private fun openNextActivity() {
        val intent = Intent(this, )
    }
}