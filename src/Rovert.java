import java.util.*;

public class Rovert {
    private final List<Rock> rocks = new ArrayList<>();
    private final Map<Character, Integer> yCords = new HashMap<>();
    private Map<Integer, Character> yCords_ = new HashMap<>();
    private final Map<Integer, String> eyesMap = new HashMap<>();
    private Integer X = 0;
    private Integer Y = 0;
    private String eyes;
    private final List<List<String>> robertMap = new ArrayList<>();

    public Rovert() {
        generateRandomRocks(3);
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

        setRandomSpawn(true);

        for (Map.Entry<Character, Integer> entry : yCords.entrySet()) {
            yCords_.put(entry.getValue(), entry.getKey());
        }
    }

    public void setRandomSpawn(boolean setElles) {
        Random random = new Random();
        int randomX = random.nextInt(10);
        int randomY = random.nextInt(10);
        if (!isClogged(randomX, randomY, rocks)) {
            setX(randomX);
            setY(randomY);
        }
        if (setElles) {
            setEyes(eyesMap.get(random.nextInt(4)));
        }
    }

    public Rovert(Integer x, Integer y, String eyes) {
        //generateRandomRocks(2);
        rocks.add(new Rock(0, 0));
        rocks.add(new Rock(9, 9));
        for (int i = 0; i < 10; i++) {
            List<String> fila = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                fila.add("0");
            }
            robertMap.add(fila);
        }
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

    public void showMap() {
        System.out.println("El robert se encuentra en: X|" + getX() + ',' + " Y|" + getY() + ',' + " Eyes|" + getEyes());
        robertMap.get(getY()).set(getX(), "@");
        rocks.forEach(rock -> robertMap.get(rock.getY()).set(rock.getX(), "#"));
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
                if (!isClogged(X, Y + 9, rocks)) {
                    setY(9);
                }
            } else {
                if (!isClogged(X, Y - 1, rocks)) {
                    setY(Y - 1);
                }
            }
        } else if (eyes.equalsIgnoreCase("S")) {
            if (getY() == 9) {
                if (!isClogged(X, Y - 9, rocks)) {
                    setY(0);
                }
            } else {
                if (!isClogged(X, Y + 1, rocks)) {
                    setY(Y + 1);
                }
            }
        } else if (eyes.equalsIgnoreCase("E")) {
            if (getX() == 9) {
                if (!isClogged(X - 9, Y, rocks)) {
                    setX(0);
                }
            } else {
                if (!isClogged(X + 1, Y, rocks)) {
                    setX(X + 1);
                }
            }
        } else {
            if (getX() == 0) {
                if (!isClogged(X + 9, Y, rocks)) {
                    setX(9);
                }
            } else {
                if (!isClogged(X - 1, Y, rocks)) {
                    setX(X - 1);
                }
            }
        }
        robertMap.get(getY()).set(getX(), "@");
    }

    public void moveBack() {
        robertMap.get(getY()).set(getX(), "0");
        if (eyes.equalsIgnoreCase("N")) {
            if (getY() == 9) {
                if (!isClogged(X, Y - 9, rocks)) {
                    setY(0);
                }
            } else {
                if (!isClogged(X, Y + 1, rocks)) {
                    setY(Y + 1);
                }
            }
        } else if (eyes.equalsIgnoreCase("S")) {
            if (getY() == 0) {
                if (!isClogged(X, Y + 9, rocks)) {
                    setY(9);
                }
            } else {
                if (!isClogged(X, Y - 1, rocks)) {
                    setY(Y - 1);
                }
            }
        } else if (eyes.equalsIgnoreCase("E")) {
            if (getX() == 0) {
                if (!isClogged(X + 9, Y, rocks)) {
                    setX(9);
                }
            } else {
                if (!isClogged(X - 1, Y, rocks)) {
                    setX(X - 1);
                }
            }
        } else {
            if (getX() == 9) {
                if (!isClogged(X - 9, Y, rocks)) {
                    setX(0);
                }
            } else {
                if (!isClogged(X + 1, Y, rocks)) {
                    setX(X + 1);
                }
            }
        }
        robertMap.get(getY()).set(getX(), "@");
    }

    public boolean isClogged(int x, int y, List<Rock> rocks) {
        for (Rock rock : rocks) {
            if (rock.getY() == y && rock.getX() == x) {
                System.out.println("El camino se encuentra obstruido por una roca!");
                return true;
            }
        }
        return false;
    }

    public void generateRandomRocks(int cantidad) {
        Random random = new Random();
        for (int i = 0; i <= (cantidad - 1); i++) {
            rocks.add(new Rock(random.nextInt(10), random.nextInt(10)));
        }
    }
}
