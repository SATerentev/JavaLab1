import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FirstPartTests {
    // region FIRST TASK EXPRESSIONS TESTS

    @Test
    void testsFirstExpressionInt(){
        assertEquals(1, FirstPart.firstExpression(5, 3)); // Обычный случай. m = 5, n = 3, результат должен быть 5 - (3 + 1) = 1
        assertEquals(-1, FirstPart.firstExpression(7, 7)); // Случай m = n. m = n = 7, результат должен быть 7 - (7 + 1) = -1
        assertEquals(6, FirstPart.firstExpression(10, 3)); // Случай m > n. m = 10, n = 3, результат должен быть 10 - (3 + 1) = 6
        assertEquals(-4, FirstPart.firstExpression(2, 5)); // Случай m < n. m = 2, n = 5, результат должен быть 2 - (5 + 1) = -4
        assertEquals(-1, FirstPart.firstExpression(Integer.MAX_VALUE, Integer.MAX_VALUE)); // Пограничные значения, m = 2147483647, n = 2147483647, результат должен быть -1
        /*
         Стоит написать, что в верхнем тесте есть одна проблема. Т.к. Integer имеет свои ограничения, когда происходит ++Integer.MAX_VALUE, то это
         число принимает значение Integer.MIN_VALUE, но при вычитании из Integer.MAX_VALUE этого числа, мы получаем Integer.MAX_VALUE + (Integer.MAX_VALUE + 1),
         таким образом и приходим к -1.
         Суть в том, что здесь произошла сначала одна ошибка, но потом вторая ошибка все исправила. Подобное встречалось в первой лаб.работе по ТОИ.
        */
        assertEquals(-1, FirstPart.firstExpression(Integer.MIN_VALUE, Integer.MIN_VALUE)); // Пограничные значения, m = -2147483648, n = -2147483648, результат должен быть -1
        assertEquals(2147483647, FirstPart.firstExpression(Integer.MIN_VALUE, 0)); // Крайний случай, выход за пределы значений Integer
        assertEquals(-3, FirstPart.firstExpression(-5, -3)); // Случай с отрицательными числами, m = -5, n = -3, результат -5 - (-3 + 1) = -3
    }

    @Test
    void testsFirstExpressionDouble() {
        assertEquals(0, FirstPart.firstExpression(1.4, 0.4)); // Обычный случай, m = 1.4, n = 0.4, результат 0.0
        assertEquals(3.7, FirstPart.firstExpression(7.9, 3.2)); // Обычный случай, m = 7.9, n = 3.2, результат 3.7
        assertEquals(-1, FirstPart.firstExpression(7.1, 7.1)); // Случай m = n. m = n = 7.3, результат -1
        assertEquals(6.2, FirstPart.firstExpression(10.9, 3.7)); // Случай m > n. m = 10.7, n = 3.5, результат 6.2
        assertEquals(-6.1, FirstPart.firstExpression(2.6, 7.7)); // Случай m < n. m = 2.6, n = 7.7, результат -6.1
        assertEquals(-3.2, FirstPart.firstExpression(-5.5, -3.3)); // Случай с отрицательными числами, m = -5.5, n = -3.3, результат -3.2
        assertEquals(-1, FirstPart.firstExpression(0.0, 0.0)); // Случай с нулями, m = 0.0, n = 0.0, результат -1.0
        assertEquals(0.0, FirstPart.firstExpression(0.0, -1.0)); // Случай с нулями, m = 0.0, n = -1.0, результат 0.0
    }

    /*
    @Test
    void failTestsFirstExpressionDouble(){
        // Это будут специальные тесты, которые должны выдавать ошибку
        // Эти тесты покажут, что даже при правильных подсчетах, в работе с вещественными числами IEEE 754 могут быть ошибки при округлениях
        assertEquals(1.4, FirstPart.firstExpression(5.5, 3.1)); // expected: 1.4 | actual: 1.4000000000000004
        assertEquals(1.3, FirstPart.firstExpression(5.5, 3.2)); // expected: 1.3 | actual: 1.2999999999999998
        assertEquals(0.0, FirstPart.firstExpression(Double.MAX_VALUE, Double.MAX_VALUE)); // expected: -1.0 | actual 0.0
    }
    */

    @Test
    void testsSecondExpression(){
        assertTrue(FirstPart.secondExpression(5, 3));  // 5 > 2 True
        assertFalse(FirstPart.secondExpression(2, 4)); // 2 > 3 False
        assertTrue(FirstPart.secondExpression(7, 7)); // 7 > 6 True
        assertTrue(FirstPart.secondExpression(Integer.MAX_VALUE, Integer.MAX_VALUE)); // MAX_VALUE > (MAX_VALUE - 1) True
        assertFalse(FirstPart.secondExpression(Integer.MIN_VALUE, Integer.MIN_VALUE)); // MIN_VALUE > (MIN_VALUE - 1) по математике True, для джавы будет False
        assertFalse(FirstPart.secondExpression(Integer.MAX_VALUE, Integer.MIN_VALUE)); // MAX_VALUE > (MIN_VALUE - 1) по математике True, для джавы будет False (они будут равны)
        assertFalse(FirstPart.secondExpression(-5, -3)); // -5 > -4 False
        assertFalse(FirstPart.secondExpression(-7, -4)); // -7 > -5 False
        assertTrue(FirstPart.secondExpression(0, 0)); // 0 > -1 True
    }

    @Test
    void testsThirdExpression(){
        assertFalse(FirstPart.thirdExpression(5, 3));  // 5 < 4 False
        assertTrue(FirstPart.thirdExpression(2, 4)); // 2 < 4 True
        assertTrue(FirstPart.thirdExpression(7, 7)); // 7 < 8 True
        assertFalse(FirstPart.thirdExpression(Integer.MAX_VALUE, Integer.MAX_VALUE)); // MAX_VALUE < (MAX_VALUE + 1) По математике True, для джавы будет False
        assertTrue(FirstPart.thirdExpression(Integer.MIN_VALUE, Integer.MIN_VALUE)); // MIN_VALUE < (MIN_VALUE + 1) True
        assertFalse(FirstPart.thirdExpression(Integer.MAX_VALUE, Integer.MIN_VALUE)); // MAX_VALUE < (MIN_VALUE + 1) False
        assertTrue(FirstPart.thirdExpression(-5, -3)); // -5 < -2 True
        assertTrue(FirstPart.thirdExpression(-7, -4)); // -7 < -3 True
        assertTrue(FirstPart.thirdExpression(0, 0)); // 0 < 1 True
    }

    @Test
    void testsFourthExpression() {
        assertEquals(Math.asin(1), FirstPart.fourthExpression(0), 1e-9); // 0 + 1 = 1, пограничное значение для asin
        assertEquals(Math.asin(0.5), FirstPart.fourthExpression(-0.5), 1e-9); // -0.5 + 1 = 0.5
        assertEquals(Math.asin(0), FirstPart.fourthExpression(-1), 1e-9); // -1 + 1 = 0
        assertEquals(Math.asin(1), FirstPart.fourthExpression(-2), 1e-9); // -2 + 1 = -1, пограничное значение для asin
        assertTrue(Math.abs(FirstPart.fourthExpression(-0.8) - Math.asin(0.2)) < 1e-9); // -0.8 + 1 = 0.2
        assertTrue(Math.abs(FirstPart.fourthExpression(-0.3) - Math.asin(0.7)) < 1e-9); // -0.3 + 1 = 0.7
        assertTrue(Math.abs(FirstPart.fourthExpression(-0.9999) - Math.asin(0.0001)) < 1e-9); // -0.9999 + 1 = 0.0001
        assertTrue(Math.abs(FirstPart.fourthExpression(-0.6) - Math.asin(0.4)) < 1e-9); // -0.6 + 1 = 0.4
    }
    // endregion
}
