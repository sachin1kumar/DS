package array

fun main() {

    val arr = intArrayOf(-2, -3, 4, -1, -2, 1, 5, -3)

    var maxSoFar = arr[0]
    var maxEndingHere = arr[0]

    for (index in 1 until arr.size) {
        maxEndingHere = Math.max(maxEndingHere + arr[index], arr[index]);

        // Did we beat the 'maxSoFar' with the 'maxEndingHere'?
        maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }

    print(maxSoFar)
}