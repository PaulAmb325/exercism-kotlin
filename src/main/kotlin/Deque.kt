class Deque<T> (
    private var last:Node<T>? = null,
    private var first:Node<T>? = null
){
    fun push(value: T) {
        val newNode: Node<T> = Node(value)
        newNode.setPrev(last)
        last?.setNext(newNode)
        if(first == null){
            first = newNode
        }
        last = newNode
    }

    fun pop(): T? {
        val value: T? = last?.value
        val newLast: Node<T>? = last?.prev()
        last = newLast
        return value
    }

    fun unshift(value: T) {
        val newNode: Node<T> = Node(value)
        newNode.setNext(first)
        first?.setPrev(newNode)
        if(last == null){
            last = newNode
        }
        first = newNode
    }

    fun shift(): T? {
        val value: T? = first?.value
        val newFirst: Node<T>? = first?.next()
        first = newFirst
        return value
    }
}

class Node<T>(
    val value: T,
    private var prev: Node<T>? = null,
    private var next: Node<T>? = null,
) {
    fun setPrev(prev: Node<T>?) {
        this.prev = prev
    }

    fun prev() : Node<T>? {
        return prev
    }

    fun setNext(next: Node<T>?) {
        this.next = next
    }

    fun next() : Node<T>? {
        return next
    }

}
