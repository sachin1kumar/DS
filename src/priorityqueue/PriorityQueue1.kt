package priorityqueue

fun main() {
    //Here, we have the following input having elements with priority like:
    // A B C D E
    // 2 1 1 3 2
    //Smaller the number, higher the priority..
    val elements: HashMap<Char, Int> =  initCollection()
    //In this problem taking total priority equals to 3..
    val totalPriority = 3
    //Here, we are going to create 3 Queues as we have total 3 priorities defined and hence, here ArrayLists represents Queues which
    //are mapped with int priorities.
    val mapWithQueues: HashMap<Int, ArrayList<Char>?> = createHashMapWithQueues(totalPriority)
    //Now, we are going to add the elements based on their priorities in the specific queue based on its priority.
    val modifiedMap: HashMap<Int, ArrayList<Char>?> = insertion(mapWithQueues, elements)
    //print priority queue...
    printMapContainingQueue(modifiedMap)
    //The output will be like:
    //Q1: B C
    //Q2: A E
    //Q3: D
}

private fun initCollection(): HashMap<Char, Int> {
    val map = HashMap<Char, Int>()
    map['A'] = 2
    map['B'] = 1
    map['C'] = 1
    map['D'] = 3
    map['E'] = 2
    return map
}

private fun createHashMapWithQueues(totalPriority: Int): HashMap<Int, ArrayList<Char>?> {
    val map = HashMap<Int, ArrayList<Char>?>()
    for (index in 1..totalPriority) {
        val arrayList = ArrayList<Char>()
        map[index] = arrayList
    }
    return map
}

private fun insertion(mapWithQueues: HashMap<Int, ArrayList<Char>?>, elements: HashMap<Char, Int>): HashMap<Int, ArrayList<Char>?> {
    //iterate elements HashMap...
    for (element in elements.entries) {
        val priority = element.value
        val key = element.key
        when (priority) {
            1 -> {
                val list =  mapWithQueues[priority]
                list?.add(key)
                mapWithQueues[priority] = list
            }
            2 -> {
                val list =  mapWithQueues[priority]
                list?.add(key)
                mapWithQueues[priority] = list
            }
            3 -> {
                val list =  mapWithQueues[priority]
                list?.add(key)
                mapWithQueues[priority] = list
            }
        }
    }
    return mapWithQueues
}

private fun printMapContainingQueue(modifiedMap: HashMap<Int, ArrayList<Char>?>) {
    for (element in modifiedMap.entries) {
        val priority = element.key
        val queueData = element.value
        print("Q$priority: ")
        for (index in 0 until queueData!!.size) {
            print("${queueData[index]} ")
        }
        println()
    }
}
