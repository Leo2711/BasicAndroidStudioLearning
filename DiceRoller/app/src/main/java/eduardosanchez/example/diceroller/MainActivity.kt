package eduardosanchez.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

/**
 * This activity is a simulation of the roll of a dice.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        val dice1: ImageView = findViewById(R.id.imageView)
        val dice2: ImageView = findViewById(R.id.imageView2)
        rollButton.setOnClickListener {
            rollDice(dice1)
            rollDice(dice2)
        }
        // when the app stars we make a roll so it doesn't look empty
        rollDice(dice1)
        rollDice(dice2)
    }

    /**
     * Roll the dice and update the screen
     */
    private fun rollDice(diceImage: ImageView) {
        // We make te dice and get the roll randomly
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // Depending on the result we change the image of the dice
        //Find the image in the layout

        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
    }
}
class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
