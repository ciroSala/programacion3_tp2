package tp2;

public class Main {
    public static void main(String[] args) {
        int [] arr = new int[7];
        arr[0] = 5;
        arr[1] = 4;
        arr[2] = 8;
        arr[3] = 2;
        arr[4] = 4;
        arr[5] = 1;
        arr[6] = 3;
        Recursividad recursividad = new Recursividad();
        System.out.println(recursividad.toString(arr));
        recursividad.ordenamientoPorSeleccion(arr);
        System.out.println(recursividad.toString(arr));
    }
}
