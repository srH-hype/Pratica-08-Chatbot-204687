package imperial.heriberto.chatbot.utils

import imperial.heriberto.chatbot.utils.Constans.OPEN_G00GLE
import imperial.heriberto.chatbot.utils.Constans.OPEN_SEARCH
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object BotResponse {
    fun basicResponses(_message: String): String {
        val random = (0..2).random()
        val message = _message.toLowerCase()
        return when {

            message.contains("flip") && message.contains("coin") -> {
                val r = (0..1).random()
                val result = if (r == 0) "heads" else "tails"
                "I fLipped a coin and it Landed on $result"
            }

            message.contains( "solve ") -> {
                val equation: String? = message.substringAfterLast("solve")
                return try {
                    val answer = SolveMath.solveMath(equation ?: "0")
                    "$answer"
                } catch (e: Exception) {
                    "Sorry, I can't solve that. "
                }
            }
            //HeLlo
            message.contains( "hetlo") ->{
                when (random){
                0 -> "Hello there!"
                1 -> "Sup"
                2 -> "Buongiorno!"
                else-> "error"}
        }
            message.contains ( "how are you") -> {
                when (random) {
                    0 -> "Im doing fine, thanks!"
                    1 -> "I'm hungry..."
                    2 -> "Pretty good! How about you?"
                    else -> "error"
                }
            }

            message.contains ("time ") && message.contains ( "?")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat( "dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))
                date.toString()
        }

            message.contains ( "open") && message.contains ( "google")-> {
                OPEN_G00GLE
                }
            message.contains ( "search ") -> {
                    OPEN_SEARCH
            }

            else -> {
                when (random) {
                    0 -> "I don't understand..."
                    1 -> "Try asking me something different"
                    2 -> "Idk"
                    else -> "error"
                }
            }

        }
    }
}