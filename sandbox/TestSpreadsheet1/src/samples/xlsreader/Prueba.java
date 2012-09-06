package samples.xlsreader;

public class Prueba extends Thread {

	// 1. Subir el código a Github, con README.md razonable en inglés
	// 2. Siguientes modos de operación:
	// 2.1. XLSReader (totalmente desconectado de la DB), te devuelve un reader
	// de las rows, con las siguientes modalidades:
	// 2.1.1. Pasas un bean y se encarga de mapear las columnas a las
	// propiedades del bean (tenes que pasar un mapita o un properties que
	// asocie nro de columna a nombre de propiedad del bean).
	// 2.1.2. Devolver un array de object para cada fila. Digo Object para que
	// se pueda mapear el tipo que mejor matchee de Java con el tipo de columna.
	// Te tiene que dejar especificar cuantas filas saltear al ppio. O podés
	// leerlas e ignorarlas. Tiene que ser un Reader de Java
	// 2.1.3. Hacer que el Reader sea Iterable[T], permitiendo cosas como esta:
	// for(MiObjeto row : new XLSReader(xlsFile))
	
	//https://docs.google.com/spreadsheet/ccc?key=0Ap9dpq9vAeVtdEZZc0lyNV9fQk5kVlpyaFI3dXM4Mnc
	
	public static void main(String[] args) {

	}

}
