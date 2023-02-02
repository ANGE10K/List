public class Robot {
    final private String name;
    final private String version;
    private int x;
    private int y;
    private int countSteps;
    private int steps = 1;
    private direction direct;
    private int x1;
    private int y1;
    private int countSteps1 = 0;
    private int countSteps2;
    private int countStepsToCheckpoint;

    public static void main(String[] args) {
        Robot R1 = new Robot("R1", "A1", 0, 0);
        R1.changeDirection(direction.LEFT);
        R1.move();
        R1.changeSteps(5);
        R1.changeDirection(direction.UP);
        R1.move();
        R1.checkPoint();
        R1.changeDirection(direction.RIGHT);
        R1.move();
        R1.changeDirection(direction.LEFT);
        R1.move();
        R1.countStepsLastDirection();
        R1.changeDirection(direction.UP);
        R1.move();
        R1.returnCheckpoint();
        R1.info();

    }

    Robot(String name, String version, int x, int y) {
        this.name = name;
        this.version = version;
        this.x = x;
        this.y = y;
        direct = direction.RIGHT;
    }

    public enum direction {
        RIGHT,
        LEFT,
        DOWN,
        UP
    }

    public void move() {
        if (direct.equals(direction.LEFT)) {
            x -= steps;
        }
        if (direct.equals(direction.RIGHT)) {
            x += steps;
        }
        if (direct.equals(direction.DOWN)) {
            y -= steps;
        }
        if (direct.equals(direction.UP)) {
            y += steps;
        }
        countSteps += steps;
    }

    public void changeDirection(direction dir) {
        direct = dir;
        countSteps1 = countSteps;
    }
    public int countStepsLastDirection() {
        return countSteps - countSteps1;
    }

    public void changeSteps(int steps) {
        this.steps = steps;
    }

    public void checkPoint() {
        x1 = x;
        y1 = y;
        countSteps2 = countSteps;
    }

    public void returnCheckpoint() {
        changeSteps(1);
        countStepsToCheckpoint = countSteps - countSteps1;
        for (int i = 0; i < countSteps - countSteps2; i++) {
            if (x - x1 > 0) {
                changeDirection(direction.LEFT);
                for (int k = 0; k <= x - x1; k++) {
                    move();
                    countStepsToCheckpoint--;
                }
            }
            if (y - y1 > 0) {
                changeDirection(direction.DOWN);
                for (int k = 0; k <= y - y1; k++) {
                    move();
                    countStepsToCheckpoint--;
                }
            }
            if (x - x1 < 0) {
                changeDirection(direction.RIGHT);
                for (int k = 0; k >= x - x1; k--) {
                    move();
                    countStepsToCheckpoint--;
                }
            }
            if (y - y1 < 0) {
                changeDirection(direction.UP);
                for (int k = 0; k >= y - y1; k--) {
                    move();
                    countStepsToCheckpoint--;
                }
            }
        }
    }

    public void info() {
        System.out.println("Имя робота: " + name);
        System.out.println("Версия: " + version);
        System.out.println("Место нахождения робота: x = " + x + " " + "y = " + y);
        System.out.println("Количество шагов за раз: " + steps);
        System.out.println("Шагов пройдено: " + countSteps);
        System.out.println("Направление движения: " + direct);
        System.out.println("Последний checkpoint: x = " + x1 + " " + "y = " + y1 + "");
        System.out.println("Шагов до checkpoint: " + countStepsToCheckpoint);
    }
}