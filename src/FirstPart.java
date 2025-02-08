public class FirstPart {
    // region FIRST TASK EXPRESSIONS
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



    // endregion
}
