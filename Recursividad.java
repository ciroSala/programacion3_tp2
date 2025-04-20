package tp2;

public class Recursividad {
    public Recursividad(){
    }

    public String toString(int [] arr){
        String salida = "[";
        for(int i = 0; i<arr.length; i++){
            salida += arr[i] + ", ";
        }
        return salida + "]";
    }

    public void imprimir(int x){
        if(x>0){
            imprimir(x-1);
            System.out.println(x);
        }
    }

    /*
        Ejercicio 1
        Implemente un algoritmo recursivo que determine si
        un arreglo de tamaño N está ordenado y responda:
        1. ¿Qué complejidad O tiene? (La complejidad en el peor caso)
        2. ¿Trae algún problema hacerlo recursivo? ¿Cuál?
    */
    public boolean estaOrdenado(int []arr,int j, int fin){
        if(j<=fin-1){                               //Si todavia no llegamos al anteultimo seguir comparando
            System.out.println("entre mama");
            if(arr[j]<arr[j+1]){                    //Vemos si el elemento en j es menor al de su derecha,
                return estaOrdenado(arr,j+1,fin);       //si es menor pasamos a comparar el siguiente
            }else{
                return false;
            }
        }else{
            return true;
        }
    }

    /*
        Ejercicio 2
        Implemente un algoritmo recursivo para buscar un elemento en un arreglo ordenado
        ascendentemente.
     */
    public int buscarElemento(int [] arr, int inicio, int fin, int x){
        if(inicio<=fin){
            int medio = (inicio+fin)/2;
            if(x>arr[medio]){
                return buscarElemento(arr,medio+1,fin,x);
            } else if (x<arr[medio]) {
                return buscarElemento(arr,inicio,medio-1,x);
            }else{
                return medio;
            }
        }else {
            return -1;
        }
    }
    /*
    Ejercicio 3
    Implemente un algoritmo recursivo que convierta un número en notación decimal a su
    equivalente en notación binaria.
    */
    public String calcularBinario(int numero){
        String numeroBinario = "";
        if(numero>=2){
            numeroBinario += calcularBinario(numero/2);
            if(numero % 2 == 0) {
                return numeroBinario + ",0";
            }else{
                return numeroBinario + ",1";
            }
        }else{
            return "1";
        }
    }

    public void calcularFinobacci(int numeroAnterior, int resultado, int numeroSecuencia){
        if(numeroSecuencia>0) {
            System.out.println(numeroAnterior);
            calcularFinobacci(resultado, numeroAnterior + resultado, numeroSecuencia - 1);
        }
    }

    public int buscarValorIgualPos(int [] arr, int pos, int fin){
        if(pos<=fin){
            if(arr[pos]>pos){
                return -1;
            } else if (arr[pos]<pos) {
                return buscarValorIgualPos(arr,pos+1,fin);
            }
            return pos;
        }else{
            return-1;
        }
    }

    public void ordenamientoPorSeleccion(int [] arr) {
        // Recorremos el arreglo desde el primer elemento hasta el penúltimo
        for (int i = 0; i < arr.length-1; i++) {
            // En cada iteración 'i', asumimos que el elemento actual es el mínimo
            int peque = i;

            // Buscamos el elemento más pequeño en el resto del arreglo (desde i+1 hasta el final)
            for (int j = i + 1; j < arr.length; j++) {
                // Si encontramos un elemento más pequeño, actualizamos el índice del mínimo
                if (arr[j] < arr[peque]) {
                    peque = j;
                }
            }
            // Después de la búsqueda interna, si el índice del mínimo es diferente de 'i',
            // significa que encontramos un elemento más pequeño en el resto del arreglo.
            // Realizamos el intercambio (switch) para colocar el elemento más pequeño
            // en la posición correcta (la posición 'i' al inicio de la iteración).
            if (peque != i) {
                int temp = arr[i];
                arr[i] = arr[peque];
                arr[peque] = temp;
            }
        }
    }

}

