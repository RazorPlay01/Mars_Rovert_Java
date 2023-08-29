import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        controlRovert();
    }

    private static void controlRovert() {
        Rovert rovert = new Rovert();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Sistema de pilotaje del Robert:");
            rovert.showPosition();
            System.out.println("1: Avanzar " +
                    "2: Retroceder " +
                    "3: Rotar " +
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
                    rovert.showPosition();
                }
                default -> {
                }
            }
        } while (option != 0);
    }
}
