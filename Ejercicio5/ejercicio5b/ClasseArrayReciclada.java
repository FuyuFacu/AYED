package ejercicio5;

class ListaNumeros {
	private int num1, num2, num3, num4, num5, num6; // Supongo que esto es lo que pide el enunciado, no estoy muy seguro

	public ListaNumeros(int num1, int num2, int num3, int num4, int num5, int num6) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.num4 = num4;
		this.num5 = num5;
		this.num6 = num6;
	}
	
	
	public int[] getNumeros() {
		int[] arrayConNumeros = new int[] {num1, num2, num3, num4, num5, num6};
		// O en podes hacer esto que me parece rre loco
		// int[] arrayConNumeros = {num1, num2, num3, num4, num5, num6};
		return arrayConNumeros;
	}


}

public class ClaseArray {
	
	public static String sacarRangos(ListaNumeros L) {
		String aux = "";
		int minimo = 999999;
		int maximo = 0;
		int sumaTotal = 0;
		int[] arrayEnteros = L.getNumeros();
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
