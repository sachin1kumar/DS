/*
package array

import java.security.KeyStore
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap

fun main() {

    //Sorting Elements of an Array by Frequency..
    val arr = intArrayOf(5, 5, 4, 6, 4)
    val hashMap = storeFrequencyOfElementsInMap(arr)
    for (entry in hashMap.entries) {
        println("${entry.key} : ${entry.value}")
    }

    //Sort the hashmap w.r.t values in descending order..
    val entries = hashMap.entries
    val arrayList = ArrayList(entries)

    arrayList.sortWith(Comparator { o1, o2 -> o2.value.compareTo(o1.value) })

    //insert in linkedHashMap..
    val linkedHashMap = LinkedHashMap<Int, Int>()

    val entry = java.util.Map.Entry<Int, Int>

    for (entry: Map.Entry<Int, Int> in arrayList.indices)

}

fun storeFrequencyOfElementsInMap(array: IntArray) : HashMap<Int, Int> {
    val hashMap = HashMap<Int, Int>()
    for (index in array.indices) {
        if (hashMap.containsKey(array[index])) {
            val value = hashMap[array[index]]
            value?.plus(1)?.let { hashMap.put(array[index], it) }
        } else {
            hashMap[array[index]] = 1
        }
    }
    return hashMap
}*/
