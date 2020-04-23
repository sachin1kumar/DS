package graph

import java.util.*
// not working because of multi dimensional array.
fun main() {

    val visited = BooleanArray(5)
    for (i in 0 until visited.size) {
        visited[i] = false
    }

    //created graph..
    var edges = createGraph()

    BFS(edges,0,5,visited)

}

fun BFS(edges: Array<Array<Int>>, sv: Int, noOfVertices: Int, visited: BooleanArray) {

    val queue = ArrayDeque<Int>()
    queue.add(sv)
    visited[sv] = true


    while (queue.size != 0){
        var currentVertex = queue.element()
        print("${currentVertex} ")
        //remove vertex.
        queue.poll()

        for (i in 0 until noOfVertices){
            if (i == currentVertex){
                continue;
            }
            if (edges[currentVertex][i] ==1 && !visited[i]) {
                queue.add(i)
                visited[i] = true
            }
        }

    }

}

fun createGraph(): Array<Array<Int>> {
    val noOfVertices = Scanner(System.`in`).nextInt()
    val noOfEdges = Scanner(System.`in`).nextInt()

    val edges = arrayOf<Array<Int>>()

    for (i in 0 until noOfVertices) {
        edges[i] = arrayOf<Int>()
        for (j in 0 until noOfVertices) {
            edges[i][j] = 0
        }
    }

    for (i in 0 until noOfEdges) {
        val f = Scanner(System.`in`).nextInt() // vertex name.
        val s = Scanner(System.`in`).nextInt() // vertex name.
        edges[f][s] = 1
        edges[s][f] = 1
    }
    return edges
}

