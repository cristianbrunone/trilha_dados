
// classe generica para representar um fila
class FilaSimples(val maxSize: Int) {
    private val fila: Array<String?> = arrayOfNulls(maxSize)
    
    var tamanho = 0
        private set // so pode ser alterado na propria clase


    fun enqueue(elemento: String) {
        if(tamanho == maxSize) { // a fila esta cheia
            println("Fila cheia!")
            return 
        }
        fila[tamanho] = elemento //inserção
        tamanho++ // incrementar para indicar que agora a fila tem mais um elemento
    }

    fun dequeue(): String? {
        if(tamanho == 0) {
            println("Fila vazia")
            return null
        }
        val elemento = fila[0] // salva o primeiro elemento, pois será removido

        //desloca todos os elementos para esquerda
        for(i in 1 until tamanho) {
            fila[i-1] = fila[i] //move todos os elementos para izquerda
        }

        fila[tamanho - 1] = null //elimina o ultimo elemento
        tamanho-- // remove o null deixando a lista com 
        return elemento 

    }

    fun mostrar() {
        println("Estado da fila: ${fila.filterNotNull()}")
    }
    

   
}


fun main() {
    val fila = FilaSimples(4)
    fila.enqueue("cliente 1")
    fila.enqueue("Cliente 2")
    fila.mostrar()
    
    fila.dequeue()
    fila.mostrar()
}
