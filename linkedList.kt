// Criar uma data class chamada Node
data class Node(val value: Int, var next: Node? = null)

class LinkedList {
    private var head: Node? = null

    // Inserir no início da lista
    fun insertBeginning(value: Int) {
        // Criamos um novo nó
        val newNode = Node(value)

        // O novo nó aponta para o nó que era a cabeça da lista
        newNode.next = head 

        // Atualizamos para que head aponte para o novo nó
        head = newNode
    }

    // Inserir no final da lista
    fun insertAtEnd(value: Int) {
        val newNode = Node(value)

        // Se a lista estiver vazia, o novo nó se torna a cabeça
        if (head == null) {
            head = newNode
            return
        }

        var current = head
        while (current?.next != null) { // Percorrer a lista até o último nó
            current = current.next
        }

        // O último nó agora aponta para o novo nó
        current?.next = newNode
    }

    // Remover um nó da lista
    fun remove(value: Int) {
        if (head == null) return

        // Se o primeiro nó for o que queremos remover
        if (head?.value == value) {
            head = head?.next
            return
        }

        var current = head
        while (current?.next != null) {
            if (current.next?.value == value) {
                // Pulamos o nó que queremos remover
                current.next = current.next?.next
                return
            }
            current = current.next
        }
    }

    // Buscar um valor na lista
    fun search(value: Int): Node? {
        var current = head
        while (current != null) {
            if (current.value == value) return current
            current = current.next
        }
        return null
    }

    // Imprimir a lista
    fun printList() {
        var current = head
        while (current != null) {
            print("${current.value} -> ")
            current = current.next
        }
        println("null")
    }
}

// Testando a lista encadeada
fun main() {
    val list = LinkedList()

    println("📌 Inserindo no início da lista:")
    list.insertBeginning(30)
    list.insertBeginning(20)
    list.insertBeginning(10)
    list.printList()  // 10 -> 20 -> 30 -> null

    println("\n📌 Inserindo no final da lista:")
    list.insertAtEnd(40)
    list.insertAtEnd(50)
    list.printList()  // 10 -> 20 -> 30 -> 40 -> 50 -> null

    println("\n📌 Removendo um elemento da lista:")
    list.remove(30)
    list.printList()  // 10 -> 20 -> 40 -> 50 -> null

    println("\n📌 Buscando elementos na lista:")
    println("Procurando 20: ${list.search(20)?.value ?: "Não encontrado"}")  // 20
    println("Procurando 100: ${list.search(100)?.value ?: "Não encontrado"}")  // Não encontrado
}
