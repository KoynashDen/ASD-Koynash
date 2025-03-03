package Lab_3;

public class ITINERARY {
    private String FIRST;
    private String FINAL;
    private int NUM;
    private double DISTANCE;

    public ITINERARY(String FIRST, String FINAL, int NUM, double DISTANCE) {
        this.FIRST = FIRST;
        this.FINAL = FINAL;
        this.NUM = NUM;
        this.DISTANCE = DISTANCE;
    }

    public String getFIRST() {
        return FIRST;
    }

    public String getFINAL() {
        return FINAL;
    }

    public int getNUM() {
        return NUM;
    }

    public double getDISTANCE() {
        return DISTANCE;
    }


    public void display() {
        System.out.println("Маршрут №" + NUM);
        System.out.println("  Початковий пункт: " + FIRST);
        System.out.println("  Кінцевий пункт: " + FINAL);
        System.out.println("  Відстань: " + DISTANCE + " км");
    }
}
