package entrega_03.src.gestion_accesos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionAcceso {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        menu();
    }

    public static void menu(){
        int opcion = 0;
        do {
            try {
                System.out.println("Menu principal");
                System.out.println("1. Validar identificador de acceso");
                System.out.println("2. Validar clave de seguridad");
                System.out.println("3. Salir");
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        validacionID();
                        break;
                    case 2:
                        validacionPass();
                        break;
                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("La opcion tiene que ser numerica\n");
                sc.nextLine();
            } catch (InvalidPasswordException | InvalidUsernameException e) {
                System.out.println(e.getMessage());
            }
        } while (opcion!=3);
    }

    public static void validacionID() throws InvalidUsernameException {
        System.out.println("Introduce el id de acceso");
        String nombre = sc.nextLine();
        if (nombre.length()>=3 && nombre.matches("[A-Za-z0-9]+")) {
            System.out.println("Validacion correcta");
            return;
        }
        throw new InvalidUsernameException("El nombre del usuario no es valido\n");
    }

    public static void validacionPass() throws InvalidPasswordException {
        System.out.println("Introduce una clave de minimo 6 caracteres, con al menos un numero y una mayuscula");
        String password = sc.nextLine();
        //6 o mas caracteres, una mayuscula y un numero
        if (password.length()>=6 && password.matches(".*[0-9].*") && password.matches(".*[A-Z].*")) {
            System.out.println("Validacion correcta");
            return;
        }
        throw new InvalidPasswordException("La contraseña debe tener al menos 1 numero, 1 mayuscula y minimo 6 caracteres\n");
    }
}
