
import java.util.*


fun main() {

    val gst = 10
    val finalValue = 187

    print(solveEquation("2x+5=4x+9"))



    //x+x*${gst}/100=${finalValue}

   // print(solve("x+${gst}x=${finalValue}"))
}

private fun solveEquation(eqn: String) : String {
    var i = 0
    var j = 0
    var k = 0
    var ans = 0f
    var coeffSum = 0f
    var constSum = 0f
    val coeffx = FloatArray(100)
    val constant = FloatArray(100)
    while (i < eqn.length - 1) {
        if (eqn.get(i + 1) === 'x' && i < eqn.indexOf("=")) {
            if (i != 0 && eqn.get(i - 1) === '-') {
                val x = eqn.substring(i, i + 1)
                if (x !== "+" && x !== "-") {
                    val n = -Integer.parseInt(x, 10)
                    coeffx[j++] = n.toFloat()
                }
            } else {
                val x = eqn.substring(i, i + 1)
                if (x !== "+" && x !== "-") {
                    val n = Integer.parseInt(x, 10)
                    coeffx[j++] = n.toFloat()
                }
            }
            i += 3
        }
        if (eqn.get(i + 1) === 'x' && i > eqn.indexOf("=")) {
            if (i != 0 && eqn.get(i - 1) === '-') {
                val x = eqn.substring(i, i + 1)
                if (x !== "+" && x !== "-") {
                    val n = Integer.parseInt(x, 10)
                    coeffx[j++] = n.toFloat()
                }
            } else {
                val x = eqn.substring(i, i + 1)
                if (x !== "+" && x !== "-") {
                    val n = -Integer.parseInt(x, 10)
                    coeffx[j++] = n.toFloat()
                }
            }
            i += 3
        }
        if (eqn.get(i + 1) !== 'x' && i < eqn.indexOf("=")) {
            if (i != 0 && eqn.get(i - 1) === '-') {
                val x = eqn.substring(i, i + 1)
                if (x !== "+" && x !== "-") {
                    val n = -Integer.parseInt(x, 10)
                    constant[k++] = n.toFloat()
                }
            } else {
                val x = eqn.substring(i, i + 1)
                if (x !== "+" && x !== "-") {
                    val n = Integer.parseInt(x, 10)
                    constant[k++] = n.toFloat()
                }
            }
            i += 2
        }
        if (eqn.get(i + 1) !== 'x' && i > eqn.indexOf("=")) {
            if (i != 0 && eqn.get(i - 1) === '-') {
                val x = eqn.substring(i, i + 1)
                if (x !== "+" && x !== "-") {
                    val n = Integer.parseInt(x, 10)
                    constant[k++] = n.toFloat()
                }
            } else {
                val x = eqn.substring(i, i + 1)
                if (x !== "+" && x !== "-") {
                    val n = -Integer.parseInt(x, 10)
                    constant[k++] = n.toFloat()
                }
            }
            i += 2
        }

    }
    for (i in 0 until coeffx.size)
        coeffSum += coeffx[i]
    for (i in 0 until constant.size)
        constSum += constant[i]
    ans = constSum / coeffSum
    return ans.toString()
}

fun solve(eqn: String): String{
    val st = StringTokenizer(eqn, "+=")
    val aa = st.nextToken()
    val x = Character.getNumericValue(aa[0]) //char to int conversion.

    val y = st.nextToken().toInt()
    val z = st.nextToken().toInt()

    val res = (z - y) / x
    return res.toString()
}