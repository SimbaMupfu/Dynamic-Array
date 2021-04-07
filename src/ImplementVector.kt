fun main(args: Array<String>){
    var vector = Vector<String>(3)
    vector.add("Sims")
    vector.add("Hustles")
    vector.add("Inc")
    for(i in vector.elements.indices){
        println(vector.get(i))
    }

    vector.remove(1)
    println("Updated last item is: ${vector.get(1)}")
    for(i in 0 until vector.elements.size - 1){
        println(vector.get(i))
    }

    vector.set(0, "Simba Mupfu")
    println("Updated first item is: ${vector.get(0)}")
    for(i in 0 until vector.elements.size - 1){
        println(vector.get(i))
    }
}