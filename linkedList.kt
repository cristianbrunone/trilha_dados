class Node<T>(var data: T, var next: Node<T>? = null)  // cria class node
class LinkedList<T> {
    private var head: Node<T>? = null //define o head como null

    /*d
    head -> a -> b -> c -> */

    // Inserir no início
    fun insertAtBeginning(value: T) {
        val newNode = Node(value) // d
        newNode.next = head // -> a
        head = newNode// head -> d
    } 
    
    //Inserir no final
    fun insertAtEnd(value: T) {
        val newNode = Node(value) // criamos um novo nó
        if(head == null) { //verificamos se a lista está vazia
            head = newNode // se estiver vazia, o novo nó se torna o primeiro
            return; 
        } 
            var current = head // criamos uma variavel temporaria para percorrer a lista
            while (current?.next != null) { // enquanto não chegarmos ao ultimo nó (aquele cujo next é null)
                current = current.next
            }
            current?.next = newNode // Quando `current` estiver no último nó, apontamos seu next para o novo nó
        
    }

    fun removeAtPosition(position: Int) : Boolean {
        if(position < 0 || head == null) { //verficar se a position é invalida
            prinln("Posição inválida")
            return false
        }

        // se for remover o primeiro nó
        if (position == 0) {
            head = head?.next
            return true
        }

        //head -> (a ->) (b ->) (c ->) (d ->) (e ->) (f ->) null
        //Percorre até o nó anterior ao que será removido
        var current = head // variavel temporal para head
        var currentPosition = 0 // variavel temporal para o position atual

        while(current != null && currentPosition < position -1) {
            current = current.next // valor que quero eliminar
            currentPosition++
        }

        if(current == null || current.next == null) {
            println("Posição inválida!")
            return 
        }

        current.next = current.next?.next // pular
        return true

    }

    fun search(value )


}