package array

fun main() {
    val arr = intArrayOf(11, 15, 6, 8 , 9, 10)

    //check if there is a pair with a given sum...
    val sum = 16

    //store elements in hashmap.Time will take O(n)..
    val hashMap = HashMap<Int, Int>()
    for (index in arr.indices) {
        hashMap[index] = arr[index]
    }

    //iterate array to check pair..
    print(isPairContains(arr, hashMap, sum))
}

fun isPairContains(arr: IntArray, hashMap: java.util.HashMap<Int, Int>, sum: Int): Boolean {
    var isContain = false
    for (index in arr.indices) {
        val diff = sum - arr[index]
        if (hashMap.containsKey(diff)) {
            isContain = true
            break;
        }
    }
    return isContain
}
