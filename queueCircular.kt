class FilaCircular(val maxSize: Int) {
    private val fila: Array<String?> = arrayOfNulls(maxSize)
    private var frente  = 
    private var traseira = -1 
    var tamanho = 0
        private set


   fun enqueue(elemento: String) {
    if(tamanho == maxSize) {
        println("Fila cheia!")
        return
    }
    traseira = (traseira + 1) % maxSize 
    fila[traseira] = elemento
    tamanho++
   }
   
   fun dequeue(): String? {
    if(tamanho == 0) {
        println("Fila vazia!")
        return 
    }
    val elemento = fila[frente]
    fila[frente] = null //limpa o espaço
    frente = (frente + 1) % maxSize

   }
   
   

}
    