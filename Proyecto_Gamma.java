import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Proyecto_Gamma {
	
	//Imprimir las listas encapsulado
	public static void Imprimir (String[][] Lista) 
	{		
		
		for (int i = 0; i < Lista[0].length; i++) {
	        System.out.println(Lista[0][i] + " | " + Lista[1][i]);
	    }
		
	}
	
	//Agregar a la lista encapsulado
	public static String[] Agregar (String[] Array, String Nuevo) 
	{
		
		String [] NArray = new String[Array.length + 1];
		
		for(int i=0; i < Array.length; i++) {
			NArray[i] = Array[i];
		}
		
		NArray[Array.length] = Nuevo;
		
		return NArray;
		
	}

	//Modificar la lista encapsulado
	public static void Modificar (String[] Nombres, String[] Notas, String Tag, Scanner S) 
	{
		
		System.out.println("\nQue/Quien quieres modificar? ");
		System.out.print(">");
		int Elecc = S.nextInt();
		S.nextLine();
		
    		if (Elecc <= Nombres.length) {

        		System.out.println("\nPrimer dato: ");
        		System.out.print(">");
        		
        		Nombres [Elecc] = "\n-" + S.nextLine();
        		
        		System.out.println("\nDato complementario: ");
        		System.out.print(">");
       		
        		Notas [Elecc] = Tag +  S.nextLine();
        		        		
    		} else {
    			System.out.println("\nERROR. Eliga una opcion existente");
    		}
	}
	
	public static int InputCorrecto(Scanner S) 
	{
		
		while(true) {
			
			try {
				
				System.out.print("\n>");
				return S.nextInt();
				
			} catch (Exception e) {
				
				System.out.println("\nOpción no válida");
				S.nextLine();
				
			}
			
		}
		
	}
	
	//Introducción ID
	public static void Inicio () 
	{
		
		//Entrar al programa con tu "usuario".
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
			System.out.print("ID de Admin: ");
				String ID = S.nextLine();
				//Loop que comprueba que hay algo escrito en la casilla de ID.
				while (ID.isEmpty()) {
					System.out.print("\nPorfavor escriba el ID. \n");
					System.out.print("\nID de Admin: ");
						ID = S.nextLine();
				}
						
	}		
		
	//Comprobacion Hash
	public static void Contraseña () 
	{
		
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		
		boolean ContraseñaOK = true;

			while (ContraseñaOK) {
				System.out.print("\nContraseña: ");
					String InputContraseña = S.nextLine();
					//Mismo loop para la contraseña
					if (InputContraseña.isEmpty()) {
						System.out.print("\nPorfavor escriba la contraseña.\n");
						System.out.print("\nContraseña: ");
						InputContraseña = S.nextLine();
				}
					
			//Convertir la contraseña previamente establecida en HASH y comprobar que concuerda con la introducida por el user
			try {
	            String Contraseña = "1";
	
	            MessageDigest MD = MessageDigest.getInstance("SHA-256");
	            byte[] hashBytes = MD.digest(Contraseña.getBytes());
	            
	            String HashedContraseña = bytesToHex(hashBytes);			          
	
	            byte[] inputHashBytes = MD.digest(InputContraseña.getBytes());
	            String HashedInput = bytesToHex(inputHashBytes);
	
	            if (HashedContraseña.equals(HashedInput)) {
	                ContraseñaOK = false;
	            } else {
	                System.out.print("\nContraseña incorrecta\n");
	            }
	
				} catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
				}
			}
			
	}	
	private static String bytesToHex(byte[] bytes) 
	{
        StringBuilder SB = new StringBuilder();
        for (byte b : bytes) {
            SB.append(String.format("%02x", b));
        }
        return SB.toString();
	}	
		
	//Iniciar sesión
	public static void Entrada () 
	{
		System.out.println("====================");
		System.out.println("Bienvenido a PRO2FP");
		System.out.println("====================\n");
		
		//Entrar al programa con tu "usuario".
		Inicio();
		
		//Comprobar contraseña
		Contraseña();
	}		
		
	//Encapsulamiento de menu principal
	public static void Menu () 
	{
		
		System.out.println("\n=================================");
		System.out.println("Alumnos - 1");
		System.out.println("\nProfesorado - 2");
		System.out.println("\nCiclos Formativos - 3");
		System.out.println("\nMódulos y Aulas - 4");
		System.out.println("\nSalir - 5");
		System.out.println("=================================");

	}	
		
	//Encapsulamiento de opciones disponibles
	public static void Elecciones () 
	{
		
		Scanner S = new Scanner(System.in);
		
		int Elegir = 0;
		int AluM = 0;
		int ProfM = 0;
		int CicM = 0;
		int AulM = 0;
		boolean Close = true;
		boolean Close2 = true;
		
		
		//Listas
		String [] Alum = {"\n-Santi", "\n-Alex"};
		String [] Nota = {"Nota media: 9,2", " Nota media: 6"};
		String [][] AlumNota = {Alum, Nota};
		
		String [] Prof = {"\n-Pablo", "\n-Javier"};
		String [] Espec = {" Especialidad: Programación", " Especialidad: Sistemas informáticos"};
		String [][] ProfEspec = {Prof, Espec};
			
		String [] Ciclos = {"\n-DAM", "\n-ASIR",};
		String [] Hora = {" Hora comienzo: 8:30", "Hora comienzo: 15:30"};
		String [][] CiclosHora = {Ciclos, Hora};
			
		String [] Aulas = {"\n-1-A", "\n-1-B"};
		String [] Nom = {" Nombre: Nueva York", " Nombre: Tokyo"};
		String [][] AulasNom = {Aulas, Nom};
				
		//Loop
		while (Close == true) {
		Close2 = true;
		
		//Menu Principal
		Menu();			
		
			System.out.println("\nQue quieres hacer? ");
			Elegir = InputCorrecto(S);
			
			switch(Elegir) {
			
				//Posibles respuestas.
				case 1:
							
					while(Close2 == true) {
						System.out.println("\n====================");
				    	System.out.println("\n1. Mostrar lista");	        
				    	System.out.println("2. Añadir alumno");
				    	System.out.println("3. Modificar alumnos");
				    	System.out.println("4. Menu Principal\n");
				    	System.out.println("====================");
						System.out.println("\n¿Qué deseas hacer?");
				            
				    	AluM = InputCorrecto(S);
				    	S.nextLine();
				       
				        switch (AluM) {
				            	
				        //Imprimir lista
				        case 1: 
				            Imprimir(AlumNota);
				            break;
				            		
				        //Añadir Alumno
				        case 2:
				        	System.out.print("\nNombre del alumno:\n>");
				           	Alum = Agregar(Alum, "\n-" + S.nextLine());				           	
				           	
				           	System.out.print("\nNota del alumno:\n>");
				           	Nota = Agregar(Nota, "Nota media: " + S.nextLine());
				           	
				           	AlumNota = new String[][]{Alum, Nota};				           	
				           	break;
				            		
				        //Modificar Alumno
				        case 3:
				            Modificar(Alum, Nota, "Nota media: ", S);
				            break;
				            		
				        //Cerrar programa
				        case 4:
				            Close2 = false;
				            break;
				            	
				        //Detector de invalidez
				        default:
				        	System.out.println("Opción no válida.");
				            		
				        }
					}
				break;
				         				
				case 2:
							
					while (Close2 == true) {
						System.out.println("\n====================");
						System.out.println("\n1. Mostrar lista");
				    	System.out.println("2. Añadir Profesor");
				    	System.out.println("3. Modidicar Profesores");
				    	System.out.println("4. Menu Principal\n");
						System.out.println("====================");
						System.out.println("\n¿Qué deseas hacer?");
							
				    	ProfM = InputCorrecto(S);
				    	S.nextLine();
			            
				        switch (ProfM) {
				            	
				        //Imprimir lista
				        case 1: 
				            Imprimir(ProfEspec);
				            break;
			            		
					    //Agregar Profe
				        case 2:
				            System.out.print("\nNombre del profesor:\n>");
				            Prof = Agregar(Prof, "\n-" + S.nextLine());
				            
				            System.out.print("\nEspecialidad del profesor:\n>");
				            Espec = Agregar(Espec, "Especialidad: " + S.nextLine());
				            ProfEspec = new String[][]{Prof, Espec};
				            break;
				            
			            //Modificar lista
				        case 3:
				            Modificar(Prof, Espec, "Especialidad: ", S);
				            break;
					            
				        //Cerrar programa
				        case 4:
				            Close2 = false;
				            break;
				            		
					    //Detector de invalidez
				        default:
				            System.out.println("Opción no válida.");
				        }	
					}
				break;
					
				case 3:
							
					while(Close2 == true) {
						System.out.println("\n====================");
				    	System.out.println("\n1. Mostrar lista");
				    	System.out.println("2. Añadir Ciclo");
				    	System.out.println("3. Modidicar Ciclos");
				    	System.out.println("4. Menu Principal\n");
						System.out.println("====================");
						System.out.println("\n¿Qué deseas hacer?");

				    	CicM = InputCorrecto(S);
				    	S.nextLine();
			            
			            switch (CicM) {
			            		
				        //Imprimir lista
			            case 1: 
			            	Imprimir(CiclosHora);
			            	break;
			            		
					    //Añadir Ciclo
			            case 2:
			            	System.out.print("\nNombre del ciclo:\n>");
			            	Ciclos = Agregar(Ciclos, "\n-" + S.nextLine());
			            	
			            	System.out.print("\nHora de comienzo del ciclo:\n>");
			            	Hora = Agregar(Hora, "Hora comienzo: " + S.nextLine());
			            	
			            	CiclosHora = new String[][]{Ciclos, Hora};
			            	break;
			            			
					    //Modificar Ciclo
			            case 3:
			            	System.out.print("\n" + Ciclos + "\n");
			            	break;
			            	
			            //Cerrar programa
			            case 4:
				            Close2 = false;
			            	break;

			            //Detector de invalidez
			            default:
			            	System.out.println("Opción no válida.");
			            		
			            }
					}
				break;
						
				case 4:
							
					while (Close2 == true) {
						System.out.println("\n====================");
						System.out.println("\n1. Mostrar lista");
						System.out.println("2. Añadir Aula");
				    	System.out.println("3. Modidicar Aulas");
				    	System.out.println("4. Menu Principal\n");
						System.out.println("====================");
						System.out.println("\n¿Qué deseas hacer?");
							
						AulM = InputCorrecto(S);
						S.nextLine();
			            
						switch (AulM) {
			            		
				        //Añadir a la lista
			            case 1: 
			            	Imprimir(AulasNom);
			            	break;
			            			
					    //Eliminar de la lista
			            case 2:
			            	System.out.print("\nClasificacion del aula:\n");
			            	Aulas = Agregar(Aulas, "\n-" + S.nextLine());
			            	
			            	System.out.print("\nNombre del aula:\n");
			            	Nom = Agregar(Nom, "Nombre: " + S.nextLine());
			            	
			            	AulasNom = new String[][]{Aulas, Nom};
			            	break;
			            			
					    //Mostrar lista
			            case 3:
			            	Modificar(Aulas, Nom, "Nombre", S);
			            	break;
			            	
			            //Cerrar programa
			            case 4:
				            Close2 = false;
			            	break;
					            	
			            //Detector de invalidez
			            default:
			            	System.out.println("Opción no válida.");
			            		
			        	}
					}
				break;
										
				case 5:
					
					System.out.println("\nFinalizando programa...");
			        Close = false;
			        
				break;
					
				default:
					
					System.out.println("Opción no válida");
					
				break;
					
				}
																
			}
		
	S.close();
	
	}		


	public static void main (String[] args) 
	{
		
	//Iniciar Sesión
	Entrada();
				
	//Elecciones
	Elecciones();
	

	}
	
}