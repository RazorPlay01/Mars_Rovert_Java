import java.util.*;

public class Rovert {
    Map<Character, Integer> yCords = new HashMap<>();
    Map<Integer, String> eyesMap = new HashMap<>();
    Integer X = 0;
    Integer Y = 0;
    String eyes;
    Random random = new Random();
    List<List<String>> robertMap = new ArrayList<>();

    public Rovert() {
        for (int i = 0; i < 10; i++) {
            List<String> fila = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                fila.add("0");
            }
            robertMap.add(fila);
        }

        yCords.put('A', 0);
        yCords.put('B', 1);
        yCords.put('C', 2);
        yCords.put('D', 3);
        yCords.put('E', 4);
        yCords.put('F', 5);
        yCords.put('G', 6);
        yCords.put('H', 7);
        yCords.put('I', 8);
        yCords.put('J', 9);

        eyesMap.put(0, "N");
        eyesMap.put(1, "S");
        eyesMap.put(2, "E");
        eyesMap.put(3, "W");

        setX(random.nextInt(10));
        setY(random.nextInt(10));

        setEyes(eyesMap.get(random.nextInt(4)));
    }

    public Rovert(Integer x, Integer y, String eyes) {
        X = x;
        Y = y;
        this.eyes = eyes;

        yCords.put('A', 0);
        yCords.put('B', 1);
        yCords.put('C', 2);
        yCords.put('D', 3);
        yCords.put('E', 4);
        yCords.put('F', 5);
        yCords.put('G', 6);
        yCords.put('H', 7);
        yCords.put('I', 8);
        yCords.put('J', 9);

        eyesMap.put(0, "N");
        eyesMap.put(1, "S");
        eyesMap.put(2, "E");
        eyesMap.put(3, "W");
    }

    public Integer getX() {
        return X;
    }

    public void setX(Integer x) {
        X = x;
    }

    public Integer getY() {
        return Y;
    }

    public void setY(Integer y) {
        Y = y;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public void showPosition() {
        System.out.println("El robert se encuentra en: X|" + getX() + ',' + " Y|" + getY() + ',' + " Eyes|" + getEyes());
        robertMap.get(getY()).set(getX(), "@");
        System.out.println("+------------------------------------------+");
        for (List<String> strings : robertMap) {
            for (String string : strings) {
                System.out.printf("%2s ", string);
            }
            System.out.println();
        }
        System.out.println("+------------------------------------------+");
    }

    public void move() {
        robertMap.get(getY()).set(getX(), "0");
        if (eyes.equalsIgnoreCase("N")) {
            if (getY() == 0) {
                setY(9);
            } else {
                setY(Y - 1);
            }
        } else if (eyes.equalsIgnoreCase("S")) {
            if (getY() == 9) {
                setY(0);
            } else {
                setY(Y + 1);
            }
        } else if (eyes.equalsIgnoreCase("E")) {
            if (getX() == 9) {
                setX(0);
            } else {
                setX(X + 1);
            }
        } else {
            if (getX() == 0) {
                setX(9);
            } else {
                setX(X - 1);
            }
        }
        robertMap.get(getY()).set(getX(), "@");
    }

    public void moveBack() {
        robertMap.get(getY()).set(getX(), "0");
        if (eyes.equalsIgnoreCase("N")) {
            if (getY() == 9) {
                setY(0);
            } else {
                setY(Y + 1);
            }
        } else if (eyes.equalsIgnoreCase("S")) {
            if (getY() == 0) {
                setY(9);
            } else {
                setY(Y - 1);
            }
        } else if (eyes.equalsIgnoreCase("E")) {
            if (getX() == 0) {
                setX(9);
            } else {
                setX(X - 1);
            }
        } else {
            if (getX() == 9) {
                setX(0);
            } else {
                setX(X + 1);
            }
        }
        robertMap.get(getY()).set(getX(), "@");
    }
}
