import java.util.*;

public class FirstPart {
    // region FIRST TASK EXPRESSIONS
    public static void firstTask(){
        Scanner scanner = new Scanner(System.in);
        int n;
        int m;
        double x;
        System.out.println("Программа вычисляет значения выражений при заданных параметрах:\n1)m - ++n\n2)m++ > --n\n3)m-- < ++n\n4)arcsin(|x + 1|)");
        System.out.println("Пожалуйста, введите значения (n, m - целые числа | x - вещественное число):");
        System.out.print("n = ");
        n = scanner.nextInt();
        System.out.print("\nm = ");
        m = scanner.nextInt();
        System.out.print("\nx = ");
        x = scanner.nextDouble();
        System.out.println("Результаты выражений:");
        System.out.println("m - ++n: " + firstExpression(m, n));
        System.out.println("m++ > --n: " + secondExpression(m, n));
        System.out.println("m-- < ++n: " + thirdExpression(m, n));
        System.out.println("arcsin(|x+1|): " + fourthExpression(x));
    }

    public static int firstExpression(int m, int n){
        int result = m - ++n; // записываем результат вычисления в переменную result
        return result; // возвращаем полученное значение
    }

    public static double firstExpression(double m, double n){ // перегружаем метод для другого типа данных
        double result = m - ++n;
        return result;
    }

    public static boolean secondExpression(int m, int n){
        boolean result = m++ > --n; // сравниваем значения, записываем результат сравнения в переменную
        return result;
    }

    public static boolean thirdExpression(int m, int n){
        boolean result = m-- < ++n;
        return result;
    }

    public static double fourthExpression(double x){
        double result = Math.asin(Math.abs(x + 1)); // asin - метод для нахождения арксинуса, abs - метод для нахождения модуля

        if (Double.isNaN(result)){
            System.out.println("Неверный ввод: arcsin принимает значения от -1 до 1");
        }

        return result;
    }
    // endregion

    // region SECOND TASK EXPRESSION

    // константы для вершин треугольника
    private static final double TRIANGLE_VERTEX_A_X = 0;
    private static final double TRIANGLE_VERTEX_A_Y = 5;
    private static final double TRIANGLE_VERTEX_B_X = 0;
    private static final double TRIANGLE_VERTEX_B_Y = -5;
    private static final double TRIANGLE_VERTEX_C_X = 5;
    private static final double TRIANGLE_VERTEX_C_Y = 0;
    private static final double TRIANGLE_AREA = 25;

    // константы для центра окружности и радиуса
    private static final double CIRCLE_CENTER_X = 5;
    private static final double CIRCLE_CENTER_Y = 0;
    private static final double CIRCLE_RADIUS = 5;

    public static boolean secondTaskExpression(int a, int b){
        return (isPointInCircleleArea(a, b) && isPointInTriangleArea(a, b));
    }

    private static boolean isPointInCircleleArea(int x, int y){
        // Тут все просто, если расстояние от центра окружности до точки меньше, чем радиус, то точка внутри круга
        // Вычисляем по формуле sqrt(x^2 + y^2), уберем корень, чтобы не нагружать компьютер, просто сравним с радиусом в квадрате
        double distanceBeetwen = (x - CIRCLE_CENTER_X) * (x - CIRCLE_CENTER_X) + y * y;
        return distanceBeetwen <= CIRCLE_RADIUS * CIRCLE_RADIUS;
    }

    private static boolean isPointInTriangleArea(int x, int y){
        // Решим методом площадей. Если площадь треугольника равно площади трех треугольников, образующихся от точки и двух других точек
        // то точка находится внутри треугольникa

        // TODO: сделать метод
        return false;
    }

    // endregion
}
