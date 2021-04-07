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
        var a = elements
        val s = size
        if(s == a.size){
            val newArray = arrayOfNulls<Any>(s + if(s < minCapacityIncrement /2){
                minCapacityIncrement
            }else{
                s shr 1
            })
            System.arraycopy(a, 0, newArray, 0, s)
        }
        a[s] = element
        size = s + 1
        return true
    }

    fun add(index: Int, element: E){
        var a = elements
        val s = size

        //check array size first, if operation invalid then throw exception
        if(index > s || index < 0){
            throwIndexOutOfBoundsException(index, s)
        }

        //if array has capacity, move every element from given index to its next index
        if(s < a.size){
            System.arraycopy(a, index, a, index + 1, s - index)
        }else{
            //if array is full, create a larger array and the existing elements in two phases
                //1. Copy elements from 0th index to the given index
                //2. Copy elements from the next index to the last index
            val newArray = arrayOfNulls<Any>(newCapacity(s))
            System.arraycopy(a, 0, newArray, 0, index)
            System.arraycopy(a, index, newArray, index + 1, s - index)
            a = newArray
            elements = a
            a[index] = element
            size = s + 1
        }
    }

    fun get(index: Int): E{
        if(index >= size)
            throwIndexOutOfBoundsException(index, size)
        return elements[index] as E
    }

    fun set(index: Int, element: E): E{
        if(index >= size)
            throwIndexOutOfBoundsException(index, size)
        val oldValue = elements[index] as E
        elements[index] = element
        return  oldValue
    }

    fun remove(index: Int): E{
        if(index >= size)
            throwIndexOutOfBoundsException(index, size)
        val oldValue = elements[index] as E
        val numMoved = size - index - 1
        if(numMoved > 0)
            System.arraycopy(elements, index + 1, elements, index, numMoved)
        elements[--size] = null // clear to leat the Garbage Collector do its work
        return oldValue
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