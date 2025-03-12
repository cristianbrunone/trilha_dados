// Representação gráfica inicial: null <- [10] <-> [20] -> null

// Classe que representa um nó da lista duplamente encadeada
data class DoublyNode(val value: Int, var next: DoublyNode? = null, var prev: DoublyNode? = null)

class DoublyLinkedList {  
    private var head: DoublyNode? = null // Primeiro nó da lista
    private var tail: DoublyNode? = null // Último nó da lista

    // Inserir um novo nó no início da lista
    fun insertBeginning(value: Int) {
        val newNode = DoublyNode(value)

        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            newNode.next = head // O novo nó aponta para o antigo head
            head?.prev = newNode // O antigo head aponta para o novo nó
            head = newNode // Atualiza o head para o novo nó
        }
        
        /*
        Exemplo:
        null <- [30] <-> [20] <-> [10] -> null
        head → 30
        tail → 10

        Inserindo 5:
        null <- [5]  [10] <-> [20] <-> [30] -> null
        ↑
        next

        null <- [5] <-> [10] <-> [20] <-> [30] -> null
        ↑
        prev
        */
    }

    // Remover o último nó da lista
    fun removeEnd() {
        if (tail == null) {
            println("Lista vazia") // Corrigido erro de digitação
            return
        }

        if (head == tail) {
            head = null
            tail = null
        } else {
            tail = tail?.prev // Atualiza o tail para apontar para o nó anterior
            tail?.next = null // Remove a referência do último nó (eliminação)
        }
    }

    // Percorrer a lista do início para o fim 
    fun printForward() {
        var current = head
        while (current != null) {
            print("${current.value} -> ") 
            current = current.next
        }
        println("null")
    }

    // Percorrer a lista do fim para o início
    fun printBackward() {
        var current = tail
        while (current != null) { 
            print("${current.value} <- ") 
            current = current.prev
        }
        println("null")
    }
}

// Função main para testar a lista duplamente encadeada
fun main() {
    val list = DoublyLinkedList() 

    println("📌 Inserindo no início:")
    list.insertBeginning(30)
    list.insertBeginning(20)
    list.insertBeginning(10)
    list.printForward() // Esperado: 10 -> 20 -> 30 -> null

    println("\n📌 Removendo do final:")
    list.removeEnd()
    list.printForward() // Esperado: 10 -> 20 -> null

    println("\n📌 Percorrendo a lista do início para o fim:")
    list.printForward() // Esperado: 10 -> 20 -> null

    println("\n📌 Percorrendo a lista do fim para o início:")
    list.printBackward() // Esperado: 20 <- 10 <- null
}
