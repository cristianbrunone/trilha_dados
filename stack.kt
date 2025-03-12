class Stack(private val capacity: Int) {
    private val items = IntArray(capacity) // Usamos IntArray para armazenar apenas inteiros
    private var top = -1 // Indica que a pilha está vazia

    // Verifica se a pilha está vazia
    fun isEmpty(): Boolean = top == -1

    // Verifica se a pilha está cheia
    fun isFull(): Boolean = top == capacity - 1

    // Adiciona um item à pilha
    fun push(item: Int) {
        if (isFull()) {
            throw IllegalStateException("Pilha cheia!")
        }
        top++
        items[top] = item // Adiciona o item no topo da pilha
    }

    // Remove e retorna o elemento do topo da pilha
    fun pop(): Int {
        if (isEmpty()) {
            throw IllegalStateException("Pilha vazia!")
        }
        val item = items[top] // Salva o item do topo
        top-- // Decrementa o topo da pilha
        return item // Retorna o item removido
    }

    // Retorna o item do topo sem removê-lo
    fun peek(): Int? {
        if (isEmpty()) return null
        return items[top] // Retorna o item sem remover
    }
}

fun main() {
    // Criando uma pilha para armazenar inteiros com capacidade de 3
    val stack = Stack(3)

    // Inserindo elementos na pilha
    stack.push(10)
    stack.push(20)
    stack.push(30)

    // Tentando inserir um elemento em uma pilha cheia
    try {
        stack.push(40)
    } catch (e: IllegalStateException) {
        println(e.message) // Imprime "Pilha cheia!"
    }

    // Mostra o topo da pilha
    println("Topo da pilha: ${stack.peek()}") // Deve imprimir 30

    // Remove e mostra o elemento do topo
    println("Elemento removido: ${stack.pop()}") // Deve remover 30
    println("Elemento removido: ${stack.pop()}") // Deve remover 20

    // Mostra o novo topo da pilha
    println("Topo da pilha: ${stack.peek()}") // Deve imprimir 10
}
