import kotlin.random.Random

const val EASY_LEVEL_CHANCES = 7
const val MEDIUM_LEVEL_CHANCES = 5
const val HARD_LEVEL_CHANCES = 3

fun main(args: Array<String>) {
    println("Hi! Select a level. 1- Easy, 2- Medium, 3- Hard.")
    selectLevel()
}

private fun selectLevel() {
    val level = readLine()?.toIntOrNull()
    val randomNumber = Random.nextInt(100)
    when (level) {
        1 -> {
            startGame(randomNumber, EASY_LEVEL_CHANCES)
        }
        2 -> {
            startGame(randomNumber, MEDIUM_LEVEL_CHANCES)
        }
        3 -> {
            startGame(randomNumber, HARD_LEVEL_CHANCES)
        }
        else -> {
            println("Please enter a correct level: 1, 2 or 3.")
            selectLevel()
        }
    }
}

private fun startGame(randomNumber: Int, chancesCount: Int) {
    println("You have $chancesCount chances. Enter a number between 0 and 100")
    var chances = 0
    loop@ while (chances < chancesCount) {
        val inputNumber = readLine()?.toIntOrNull()
        if (inputNumber != null && inputNumber in 0..100) {
            when {
                inputNumber == randomNumber -> {
                    println("You won!")
                    break@loop
                }
                inputNumber < randomNumber -> {
                    println("Take higher")
                    chances++
                }
                else -> {
                    println("Take lower")
                    chances++
                }
            }
            if (chances == chancesCount) {
                println("\nGAME OVER. The number is $randomNumber. " +
                        "\n\nRESTART\n" +
                        "Select a level. 1- Easy, 2- Medium, 3- Hard.")
                selectLevel()
            }
        } else println("Please enter correct number between 0 and 100")
    }
}
