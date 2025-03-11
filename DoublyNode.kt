
// null <- [10] <-> [20] -> null

data class DoublyNode(val value: Int, var next: DoublyNode? = null, var prev: DoublyNode? = null)


class DoublyLinkedList(  
    //head -> null, tail -> null
    private var head: DoublyNode? = null // primeiro nodo
    private var tail: DoublyNode? = null // ultimo nodo

    fun insertBeginning(value: Int) {
        val newNode = DoublyNode(value)

        if(head == null) {
            head = newNode
            tail = newNode
        } else {
            newNode.next = head // nuevo nodo apunta com o next para o actual head
            head?.prev = newNode // el actual head apunta con prev al nuevo nodo
            head = newNode // atualiza el head para que apunte al novo no
        }
        /*
        null <- [30] <-> [20] <-> [10] -> null
        head → 30
        tail → 10
        
        insertar el 5

        null <- [5]  [10] <-> [20] <-> [30] -> null
        ↑
        next

        null <- [5] <-> [10] <-> [20] <-> [30] -> null
        ↑
        prev

        */

    }

    fun RemoveEnd() {
     if(tail == null) {
        println("Lista Vazia")
        return 
     }

     if(tail == head) {
        head = null
        tail = null
     } else {
        tail = tail?.prev
        tail?.next = null
     }






    }


)