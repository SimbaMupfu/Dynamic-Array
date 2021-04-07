import java.lang.IllegalArgumentException
import java.lang.IndexOutOfBoundsException

class Vector<E> {
    private val minCapacityIncrement = 12
    var elements: Array<Any?>
    private var size = 0

    constructor(){
        this.elements = arrayOf()
    }

    constructor(initialCapacity: Int){
        if(initialCapacity > 0){
            this.elements = Array(initialCapacity){i -> null }
        }else if(initialCapacity == 0){
            this.elements = emptyArray()
        }else{
            throw IllegalArgumentException("Illegal Capacity: $initialCapacity")
        }
    }

    fun add(element: E): Boolean{

    }

    fun add(index: Int, element: E){

    }

    fun get(index: Int): E{

    }

    fun set(index: Int, element: E): E{

    }

    fun remove(index: Int): E{

    }

    fun remove(element: E): Boolean{

    }

    private fun newCapacity(currentCapacity: Int): Int{
        val increment = if(currentCapacity < minCapacityIncrement / 2){
            minCapacityIncrement
        }else{
            currentCapacity shr 1
        }
        return  currentCapacity + increment
    }

    private fun throwIndexOutOfBoundsException(index: Int, size: Int): IndexOutOfBoundsException{
        throw IndexOutOfBoundsException("Invalid index $index, size is $size")
    }
}