import kotlin.random.Random

const val EASY_LEVEL_CHANCES = 7
const val MEDIUM_LEVEL_CHANCES = 5
const val HARD_LEVEL_CHANCES = 3
var randomNumber = Random.nextInt(100)

fun main(args: Array<String>) {
    println("Hi! Select a level. 1- Easy, 2- Medium, 3- Hard.")
    selectLevel()
}

fun selectLevel() {
    val level = readLine()?.toIntOrNull()
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

fun startGame(randomNumber: Int, chancesCount: Int) {
    println("You have $chancesCount chances. Enter a number between 0 and 100")
    var chances = 0
    loop@ while (chances < chancesCount) {
        val inputNumber = readLine()?.toIntOrNull()
        if (inputNumber != null && inputNumber > 0 && inputNumber < 100) {
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
                println("\nGAME OVER. The number is $randomNumber. \n\nRESTART\n")
                restartGame()
            }
        } else println("Please enter correct number between 0 and 100")
    }
}

fun restartGame() {
    println("Select a level. 1- Easy, 2- Medium, 3- Hard.")
    randomNumber = Random.nextInt(100)
    selectLevel()
}
