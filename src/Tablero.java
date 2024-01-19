import java.util.Scanner;

public class Tablero {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Radio radio = new MiRadio();
        int opc =0;
        try{
            do {
                String banda = "AM";
                if (radio.getBanda()==0){
                    banda = "AM";
                }
                else {
                    banda = "FM";
                }
                System.out.println( "**************************************************\n"
                        + "*                    Radio Encendido             *\n"
                        + "**************************************************\n"
                        + "* 1.  Volumen                               " + banda + " *\n"
                        + "* 2.  Banda                               " + radio.getBanda() + " *\n"
                        + "* 3.  Emisora                            " + radio.getEmisora() + " *\n"
                        + "**************************************************\n");

                System.out.println( "**************************************************\n"
                        + "*                    Radio Opciones               *\n"
                        + "**************************************************\n"
                        + "* 1.  encender radio                             *\n"
                        + "* 2.  apagar radio                               *\n"
                        + "* 3.  set Volumen                                *\n"
                        + "* 4.  cambiar banda                              *\n"
                        + "* 5.  subir emisora                              *\n"
                        + "* 6.  bajar emisora                              *\n"
                        + "* 7.  guardar emisora                            *\n"
                        + "* 5.  seleccionar emisora guardada (1-12)        *\n"
                        + "**************************************************\n");
                opc = Integer.parseInt(getNumber(in));

                switch(opc) {
                    case 1: //encender radio
                        radio.encender();
                        System.out.println("Radio encendida");
                        break;

                    case 2: //Apaga la radio, saca del tablero
                        radio.apagar();
                        System.out.println("Ha apagado la radio");
                        break;

                    case 3: //elegir volumen
                        System.out.println("Ingrese el volumen deseado de 1 a 100");
                        int vol = Integer.parseInt(getNumber(in));
                        radio.setVolume(vol);
                        System.out.println("Volumen en " + radio.getVolumen());
                        break;

                    case 4: //cambiar banda
                        System.out.println("Elija una banda AM=0, FM=1");
                        int banda2 = Integer.parseInt(getNumber(in));
                        radio.cambiarBanda(banda2);
                        if (banda2==1){
                            System.out.println("Estás escuchando FM");
                        }
                        else {
                            System.out.println("Estás escuchando AM");
                        }
                        break;

                    case 5: //Subir emisora
                        radio.subirEmisora();
                        System.out.println("Estas escuchando" + radio.getEmisora());
                        break;

                    case 6: //Bajar emisora
                        radio.bajarEmisora();
                        System.out.println("Estas escuchando" + radio.getEmisora());
                        break;

                    case 7: //Guardar emisora
                        System.out.println("Escriba el slot en el que quiere guardar la emisora (1-12)");
                        int id = Integer.parseInt(getNumber(in));
                        System.out.println("Ingrese la emisora que desea guardar");
                        float emi = Float.parseFloat(getNumber(in));
                        radio.guardarEmisora(id, emi);
                        break;

                    case 8: //Elegir emisora guardada
                        System.out.println("Escriba el slot en el que quiere guardar la emisora (1-12)");
                        int id2 = Integer.parseInt(getNumber(in));
                        radio.seleccionarEmisora(id2);
                        System.out.println("Emisora en " + radio.getEmisora());
                        break;

                    case 9: //salir

                        break;

                    default:
                        System.out.print("Esta opción no es válida por favor reintentar \n");
                        break;
                }

            }while(opc != 2);
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
