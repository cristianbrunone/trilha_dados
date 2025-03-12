class Stack(private val capacity: Int) {
    private val items = CharArray(capacity) // Usamos CharArray para armazenar os parênteses
    private var top = -1 // Indica que a pilha está vazia

    // Verifica se a pilha está vazia
    fun isEmpty(): Boolean = top == -1

    // Adiciona um item à pilha
    fun push(item: Char) {
        if (top == capacity - 1) {
            throw IllegalStateException("Pilha cheia!")
        }
        top++
        items[top] = item
    }

    // Remove e retorna o elemento do topo da pilha
    fun pop(): Char {
        if (isEmpty()) {
            throw IllegalStateException("Pilha vazia!")
        }
        val item = items[top] // Salva o item do topo
        top-- // Decrementa o topo da pilha
        return item // Retorna o item removido
    }
}

fun isBalanced(expression: String): Boolean {
    val stack = Stack(expression.length) // A pilha deve ser grande o suficiente para armazenar os parênteses

    // Itera sobre cada caractere da expressão
    for (char in expression) {
        when (char) {
            '(' -> stack.push(char) // Empilha o parêntese de abertura
            ')' -> {
                if (stack.isEmpty()) {
                    return false // Não há parêntese de abertura correspondente
                }
                stack.pop() // Desempilha o parêntese de abertura correspondente
            }
        }
    }

    // No final, se a pilha estiver vazia, significa que todos os parênteses foram fechados corretamente
    return stack.isEmpty()
}

fun main() {
    val expression1 = "((1+2) * (3/4))"
    val expression2 = "((1+2) * (3/4)"
    val expression3 = "(1+2) * 3/4)"

    println("Expressão 1 balanceada: ${isBalanced(expression1)}") // Deve retornar true
    println("Expressão 2 balanceada: ${isBalanced(expression2)}") // Deve retornar false
    println("Expressão 3 balanceada: ${isBalanced(expression3)}") // Deve retornar false
}
