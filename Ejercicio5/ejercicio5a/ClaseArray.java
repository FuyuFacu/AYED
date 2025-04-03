package ejercicio5;

public class ClaseArray {


	public static String sacarRangos(int[] arrayEnteros) {
		String aux = "";
		int minimo = 999999;
		int maximo = 0;
		int sumaTotal = 0;
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
