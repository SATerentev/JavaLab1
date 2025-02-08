class Main {
    public static void main(String[] args){
        double x1 = 0;
        double y1 = 5;
        double x2 = 0;
        double y2 = 0;
        double x3 = 10;
        double y3 = 0;
        System.out.println(Math.abs((x1 - x3) * (y2 -y3) - (x2 - x3) * (y1 - y3)) / 2.0);
    }
}