using System;

namespace CSharp
{
    internal class Program
    {
        public static string[][] ImprimirCuadro(String[][] Cuadro)
        {
            Console.WriteLine("\n   0   1   2");
            Console.WriteLine(" ┌───┬───┬───┐");
            for (int i = 0; i < Cuadro.Length; i++)
            {
                Console.WriteLine(
                    i + "│ " +
                    Cuadro[i][0] + " │ " +
                    Cuadro[i][1] + " │ " +
                    Cuadro[i][2] + " │");
                
                if (i < Cuadro.Length - 1)
                    Console.WriteLine(" ├───┼───┼───┤");
            }

            Console.WriteLine(" └───┴───┴───┘");
            return Cuadro;
        }

        public static int Check(int x, char V)
        {
            while (x < 0 || x > 2)
            {
                Console.WriteLine("Coordenada invalida. Elija de nuevo\n-" + V + ": ");
                x = Convert.ToInt32(Console.ReadLine());
            }
            return x;
        }

        public static void RevisarHorizontal(String[] L1, String[] L2, String[] L3)
        {
            string x = "Tres en raya.";
            if (L1[0] == L1[1] && L1[1] == L1[2])
            {
                Console.Write(x);
                Environment.Exit(0);
            }
            else if (L2[0] == L2[1] && L2[1] == L2[2])
            {
                Console.Write(x);
                Environment.Exit(0);
            }
            else if (L3[0] == L3[1] && L3[1] == L3[2])
            {
                Console.Write(x);
                Environment.Exit(0);
            }
        }

        public static void RevisarVertical(String[] L1, String[] L2, String[] L3)
        {
            string x = "Tres en raya.";
            if  (L1[0] == L2[0] && L2[0] == L3[0])
            {
                Console.Write(x);
                Environment.Exit(0);
            }
            else if (L1[1] == L2[1] && L2[1] == L3[1])
            {
                Console.Write(x);
                Environment.Exit(0);
            }
            else if (L1[2] == L2[2] && L2[2] == L3[2])
            {
                Console.Write(x);
                Environment.Exit(0);
            }
        }

        public static void RevisarDiagonal(String[] L1, String[] L2, String[] L3)
        {
            string x = "Tres en raya.";
            if (L1[0] == L2[1] && L2[1] == L3[2])
            {
                Console.Write(x);
                Environment.Exit(0);
            }
            else if (L1[2] == L2[1] && L2[1] == L3[0])
            {
                Console.Write(x);
                Environment.Exit(0);
            }
        }

        public static void Revision(String[] L1, String[] L2, String[] L3)
        {
            RevisarDiagonal(L1, L2, L3);
            RevisarVertical(L1, L2, L3);
            RevisarHorizontal(L1, L2, L3);
        }
        
        public static void Main(string[] args)
        {
            char X = 'X';
            char Y = 'Y';
            string[] Linea1 = { "}", ";", "{" };
            string[] Linea2 = { ";", "-", ";" };
            string[] Linea3 = { "}", ";", "{" };
            string[][] Cuadro = { Linea1, Linea2, Linea3 };
            int Contador = 0;
            int Juego;
            
            Console.WriteLine("1.- Contra un amigo");
            Console.WriteLine("2.- Contra la maquina");
            Juego = Convert.ToInt32(Console.ReadLine());

            switch (Juego)
            {
                case 1:
                    while (Contador < 9)
                    {
                        Console.Write("\nCoordenadas en las que quieres jugar (O)");
                        Console.WriteLine("-X: \n");
                        int x = Convert.ToInt32(Console.ReadLine());
                        x = Check(x, X);
                        Console.Write("-Y:\n");
                        int y = Convert.ToInt32(Console.ReadLine());
                        y = Check(y, Y);

                        while (Cuadro[y][x] == "X" || Cuadro[y][x] == "O")
                        {
                            Console.WriteLine("Casilla invalida");
                            Console.Write("-X: ");
                            x = Convert.ToInt32(Console.ReadLine());
                            x = Check(x, X);
                            Console.Write("-Y: ");
                            y = Convert.ToInt32(Console.ReadLine());
                            y = Check(y, Y);
                        }

                        Cuadro[y][x] = "O";

                        Console.Clear();

                        ImprimirCuadro(Cuadro);

                        Revision(Linea1, Linea2, Linea3);


                        Contador += 1;

                        Console.Write("\nCoordenadas en las que quieres jugar (x)");
                        Console.WriteLine("\n-X: ");
                        int z = Convert.ToInt32(Console.ReadLine());
                        z = Check(z, X);
                        Console.Write("-Y:\n");
                        int k = Convert.ToInt32(Console.ReadLine());
                        k = Check(k, Y);

                        while (Cuadro[k][z] == "X" || Cuadro[k][z] == "O")
                        {
                            Console.WriteLine("Casilla invalida");
                            Console.Write("-X: ");
                            z = Convert.ToInt32(Console.ReadLine());
                            z = Check(z, X);
                            Console.Write("-Y: ");
                            k = Convert.ToInt32(Console.ReadLine());
                            k = Check(k, Y);
                        }

                        Cuadro[k][z] = "X";

                        Console.Clear();

                        ImprimirCuadro(Cuadro);

                        Contador += 1;

                        Revision(Linea1, Linea2, Linea3);

                        if (Contador == 9)
                        {
                            Console.WriteLine("No quedan turnos posibles");
                            Environment.Exit(0);
                        }
                    } 
                    break;
                
                case 2:
                    while (Contador < 9)
                    {
                        Console.Write("\nCoordenadas en las que quieres jugar (O)");
                        Console.WriteLine("\n-X: \n");
                        int x = Convert.ToInt32(Console.ReadLine());
                        x = Check(x, X);
                        Console.Write("-Y:\n");
                        int y = Convert.ToInt32(Console.ReadLine());
                        y = Check(y, Y);

                        while (Cuadro[y][x] == "X" || Cuadro[y][x] == "O")
                        {
                            Console.WriteLine("Casilla invalida");
                            Console.Write("-X: ");
                            x = Convert.ToInt32(Console.ReadLine());
                            x = Check(x, X);
                            Console.Write("-Y: ");
                            y = Convert.ToInt32(Console.ReadLine());
                            y = Check(y, Y);
                        }

                        Cuadro[y][x] = "O";

                        Console.Clear();

                        ImprimirCuadro(Cuadro);

                        Revision(Linea1, Linea2, Linea3);


                        Contador += 1;

                        var AI = new Random();
                        int Fila = AI.Next(0, 2);
                        int Columna = AI.Next(0, 2);
                        
                        while (Cuadro[Fila][Columna] == "X" || Cuadro[Fila][Columna] == "O")
                        {
                            Fila = AI.Next(0, 2);
                            Columna = AI.Next(0, 2);
                        }
                        
                        Cuadro[Fila][Columna] = "X";

                        Console.Clear();

                        ImprimirCuadro(Cuadro);

                        Contador += 1;

                        Revision(Linea1, Linea2, Linea3);

                        if (Contador == 9)
                        {
                            Console.WriteLine("No quedan turnos posibles");
                            Environment.Exit(0);
                        }
                    } 
                    break;
                
                default:
                    Console.Write("Opcion Invalida");
                    break;
            }   

        }
    }
}