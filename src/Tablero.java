import java.util.Scanner;

public class Tablero {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Radio radio = new MiRadio();
        int opc =0;
        try{
            do {
                System.out.println( "**************************************************\n"
                        + "*                    Radio                        *\n"
                        + "**************************************************\n"
                        + "* 1.  encender radio                             *\n"
                        + "* 2.                                             *\n"
                        + "* 3.                                             *\n"
                        + "**************************************************\n");
                opc = Integer.parseInt(getNumber(in));

                switch(opc) {
                    case 1: //encender radio
                        radio.encender();
                        break;

                    case 2: //

                        break;

                    case 3: //salir
                        System.out.println("Gracias por su tiempo");
                        break;


                    default:
                        System.out.print("Esta opción no es válida por favor reintentar \n");
                        break;
                }

            }while(opc != 3);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    /**
     *
     * @param keyboard se ingresa el objeto que permite leer lo ingresado en la terminal
     * @return  un entero ingresado por el usuario
     */
    public static String getNumber(Scanner keyboard) {
        String number = keyboard.nextLine(); // Obtiene el input
        boolean isNumber = false;

        while (!isNumber) { // Vuelve a pedir input hasta que este sea un número
            try {
                int nm = Integer.parseInt(number); // Verifica que el input sea un número
                isNumber = true;
            } catch (NumberFormatException nft) {
                System.out.println("ERROR. Verifique que el valor ingresado sea numérico e intente de nuevo.");
                number = keyboard.nextLine();
            }
        }

        return number;
    }
}
