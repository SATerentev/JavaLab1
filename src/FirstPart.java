import java.math.BigDecimal;
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

    // TODO: сделать метод, который запрашивает у пользователя в консоли данные для проверки точки

    // константы для вершин треугольника
    private static final double TRIANGLE_VERTEX_A_X = 0;
    private static final double TRIANGLE_VERTEX_A_Y = 5;
    private static final double TRIANGLE_VERTEX_B_X = 0;
    private static final double TRIANGLE_VERTEX_B_Y = -5;
    private static final double TRIANGLE_VERTEX_C_X = 10;
    private static final double TRIANGLE_VERTEX_C_Y = 0;

    // константы для центра окружности и радиуса
    private static final double CIRCLE_CENTER_X = 5;
    private static final double CIRCLE_CENTER_Y = 0;
    private static final double CIRCLE_RADIUS = 5;

    // константа погрешности вычислений
    private static final double EPSILON = 1e-8;

    public static boolean secondTaskExpression(double a, double b){
        return (isPointInCircleArea(a, b) || isPointInTriangleArea(a, b));
    }

    private static boolean isPointInCircleArea(double x, double y){
        // Тут все просто, если расстояние от центра окружности до точки меньше, чем радиус, то точка внутри круга
        // Вычисляем по формуле sqrt(x^2 + y^2), уберем корень, чтобы не нагружать компьютер, просто сравним с радиусом в квадрате
        double distanceBeetwen = (x - CIRCLE_CENTER_X) * (x - CIRCLE_CENTER_X) + (y - CIRCLE_CENTER_Y) * (y - CIRCLE_CENTER_Y);
        return distanceBeetwen <= CIRCLE_RADIUS * CIRCLE_RADIUS;
    }

    private static boolean isPointInTriangleArea(double x, double y){
        // Решим методом площадей. Если площадь треугольника равно площади трех треугольников, образующихся от точки и двух других точек
        // значит точка находится внутри треугольникa
        double triangleArea = getTriangleArea(TRIANGLE_VERTEX_A_X, TRIANGLE_VERTEX_A_Y, TRIANGLE_VERTEX_B_X, TRIANGLE_VERTEX_B_Y, TRIANGLE_VERTEX_C_X, TRIANGLE_VERTEX_C_Y);
        double firstArea = getTriangleArea(x, y, TRIANGLE_VERTEX_B_X, TRIANGLE_VERTEX_B_Y, TRIANGLE_VERTEX_C_X, TRIANGLE_VERTEX_C_Y);
        double secondArea = getTriangleArea(TRIANGLE_VERTEX_A_X, TRIANGLE_VERTEX_A_Y, x, y, TRIANGLE_VERTEX_C_X, TRIANGLE_VERTEX_C_Y);
        double thirdArea = getTriangleArea(TRIANGLE_VERTEX_A_X, TRIANGLE_VERTEX_A_Y, TRIANGLE_VERTEX_B_X, TRIANGLE_VERTEX_B_Y, x, y);
        double totalArea = firstArea + secondArea + thirdArea;
        return totalArea - triangleArea < EPSILON;
        // Сравниваем разность двух площадей и EPSILON для избежания ошибок, связанных с работой вещественных чисел IEEE 754
    }

    private static double getTriangleArea(double x1, double y1, double x2, double y2, double x3, double y3){
        return Math.abs((x1 - x3) * (y2 -y3) - (x2 - x3) * (y1 - y3)) / 2.0; // Находим площадь треугольника по формуле
    }

    // endregion

    // region THIRD TASK EXPRESSION

    public static float thirdTask(float a, float b){
        float firstExpression = (a - b) * (a - b) * (a - b) - (a * a * a + 3 * a * b * b);
        float secondExpression = -3 * a * a * b - b * b * b;
        return firstExpression / secondExpression;
    }

    public static double thirdTask(double a, double b){
        double firstExpression = (a - b) * (a - b) * (a - b) - (a * a * a + 3 * a * b * b);
        double secondExpression = -3 * a * a * b - b * b * b;
        return firstExpression / secondExpression;
    }

    public static BigDecimal thirdTaskBigDecimal(BigDecimal a, BigDecimal b){
        // Оставлю за собой право сократить условие задачи
        // ФСУ - куб разности - (a-b)^3 = a^3 - 3a^2b + 3ab^2 - b^3
        // Дополнительно вычитаем a^3 и 3ab^2, остается -3a^2b - b^3
        // С BigDecimal все придется делать поочередно.
        // 1 - a^2 | 2 - a^2 * b | 3 - -3 * a^2b | 4 - b * b | 5 - b^2 * b | 6 - -3a^2b - b^3
        BigDecimal firstExpression = BigDecimal.ZERO; // создаем переменную firstExpression = 0
        firstExpression.add(a.multiply(a)); // добавляем к firstExpression а в квадрате
        firstExpression.multiply(b); // умножаем firstExpression на b
        firstExpression.multiply(new BigDecimal("-3")); // умножаем firstExpression на -3
        BigDecimal bCube = b; // помещаем в новую переменную bCube параметр b
        bCube.multiply(b); // умножаем b на b
        bCube.multiply(b); // умножаем b^2 на b | Получили b в кубе
        firstExpression.subtract(bCube); // Вычитаем из firstExpression b в кубе
        // TODO: нашли firstExpression, найти второе и вернуть результат деления, закончить метод
    }

    // endregion
}
