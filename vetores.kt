/* Crie um vetor que armazene 10 números inteiros e desenvolva uma função
para buscar um número específico no vetor.
○ Implemente uma função para remover um elemento do vetor em uma
posição específica */


fun buscarNumero(vetor: IntArray, numero: Int): Int {
    for (i in vetor.indices) {
        if (vetor[i] == numero) {
            return i
        }
    }
    return -1
}

fun removerElemento(vetor: IntArray, posicao: Int): IntArray {
    if (posicao < 0 || posicao >= vetor.size) {
        println("Posição inválida")
        return vetor  // Retorna o vetor original sem alterações
    }

    val listaTemp = vetor.toMutableList()
    listaTemp.removeAt(posicao)
    
    // Convertendo de volta para IntArray
    return listaTemp.toIntArray()  
}

fun main() {
    val vetor = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)  // Usando intArrayOf para criar um IntArray

    val numeroBuscado = 5
    val indice = buscarNumero(vetor, numeroBuscado)
    if (indice != -1) {
        println("Número $numeroBuscado encontrado na posição $indice")
    } else {
        println("Número $numeroBuscado não encontrado.")
    }

    val posicaoRemocao = 4
    val vetorAtualizado = removerElemento(vetor, posicaoRemocao)

    println("Vetor após remoção do elemento: ${vetorAtualizado.joinToString()}")
}