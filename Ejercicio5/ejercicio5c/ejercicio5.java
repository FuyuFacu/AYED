package ejercicio5;

public class ClaseArray {
	
	public static String sacarRangos() {
		String aux = "";
		int minimo = Integer.MAX_VALUE;
		int maximo = Integer.MIN_VALUE;
		int sumaTotal = 0;
		int[] arrayEnteros = {1, 2, 3, 4, 5, 6};
		int largoArrayEntero = arrayEnteros.length;
		
		double promedio;
		
		
		for (int i = 0; i < largoArrayEntero; i++) {
			if (arrayEnteros[i] < minimo) minimo = arrayEnteros[i];
			else if (arrayEnteros[i] > maximo) maximo = arrayEnteros[i];
			sumaTotal+= arrayEnteros[i];
		}
		
		promedio = sumaTotal / largoArrayEntero;
		
		aux = "Numero minimo del array: " 
			    + minimo 
			    + "\nNumero maximo del array: " 
			    + maximo 
			    + "\nPromedio de los numeros: "
				+ promedio;
		
		return aux;
		
		
	}
}
