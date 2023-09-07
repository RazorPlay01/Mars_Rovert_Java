import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        controlRovert();
    }

    private static void controlRovert() {
        //Rovert rovert = new Rovert(0,2,"W");
        Rovert rovert = new Rovert();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Sistema de pilotaje del Robert:");
            rovert.showMap();
            System.out.println("1: Avanzar " +
                    "2: Retroceder " +
                    "3: Rotar " +
                    "4: Listar Comandos " +
                    "0: Salir");
            option = scanner.nextInt();

            switch (option) {
                case 1 -> rovert.move();
                case 2 -> rovert.moveBack();
                case 3 -> {
                    System.out.println("Seleccione hacia donde debe rotar. [N,S,E,W]");
                    Scanner rInput = new Scanner(System.in);
                    String input = rInput.nextLine();
                    rovert.setEyes(input);
                    rovert.showMap();
                }
                case 4 -> {
                    Scanner rInput = new Scanner(System.in);
                    System.out.println("Especifique los comandos a seguir. [1,1,S,1,2,E]");
                    String commands = rInput.nextLine();
                    String[] commandSplit = commands.split(",");
                    for (String command : commandSplit) {
                        switch (command) {
                            case "1" -> rovert.move();
                            case "2" -> rovert.moveBack();
                            case "N", "S", "W", "E" -> rovert.setEyes(command);
                            default -> System.out.println("El comando [" + command + "], no es valido.");
                        }
                    }
                    rovert.showMap();
                }
                default -> {
                }
            }
        } while (option != 0);
    }
}
