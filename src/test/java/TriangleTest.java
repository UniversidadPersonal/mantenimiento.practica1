import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

        private Triangle triangulo;
        @BeforeEach
        public void setup(){
            triangulo = new Triangle();
        }

        @AfterEach
        public void finish(){
            triangulo = null;
        }

        @Test
        public void testComputeReturnExceptionWhenOneSideIsNegative(){
            assertThrows(RuntimeException.class, () -> triangulo.getType(-1, 2, 3));
        }

        @Test
        public void testComputeReturnExceptionWhenOneSideIsZero(){
            assertThrows(RuntimeException.class, () -> triangulo.getType(0, 2, 3));
        }

        @Test
        public void testComputeReturnExceptionWhenOneSideIsZero2() {
            assertThrows(RuntimeException.class, () -> triangulo.getType(2, 0, 3));
        }

        @Test
        public void testComputeReturnExceptionWhenOneSideIsZero3() {
            assertThrows(RuntimeException.class, () -> triangulo.getType(2, 3, 0));
        }

        @Test
        public void testComputeReturnExceptionWhenAllSidesAreZero() {
            assertThrows(RuntimeException.class, () -> triangulo.getType(0, 0, 0));
        }

        @Test
        public void testComputeReturnExceptionWhenTriangleIsNotValid(){
            assertThrows(RuntimeException.class, () -> triangulo.getType(2, 3, 5));
        }

        @Test
        public void testComputeReturnEquilateralWhenTriangleHasAllSidesEqual(){
            assertEquals(Triangle.TriangleType.EQUILATERAL, triangulo.getType(2, 2, 2));
        }

        @Test
        public void testComputeReturnIsoscelesWhenTriangleHasTwoSidesEquals(){
            assertEquals(Triangle.TriangleType.ISOSCELES, triangulo.getType(2, 2, 1));
        }

        @Test
        public void testComputeReturnIsoscelesWhenTriangleHasTwoSidesEqualsNumbersPermutation(){
            assertEquals(Triangle.TriangleType.ISOSCELES, triangulo.getType(1, 2, 2));
        }

        @Test
        public void testComputeReturnIsoscelesWhenTriangleHasTwoSidesEqualsNumbersPermutation2(){
            assertEquals(Triangle.TriangleType.ISOSCELES, triangulo.getType(2, 1, 2));
        }
        @Test
        public void testComputeReturnScaleneWhenTriangleHasAllSidesDifferent(){
            assertEquals(Triangle.TriangleType.SCALENE, triangulo.getType(4, 2, 3));
        }

        @Test
        public void testComputeReturnNotEquilateralWhenTriangleIsNotEquilateral(){
            assertNotEquals(Triangle.TriangleType.EQUILATERAL, triangulo.getType(2, 3, 4));
        }
        @Test
        public void testComputeReturnNotIsoscelesWhenTriangleIsNotIsosceles(){
            assertNotEquals(Triangle.TriangleType.ISOSCELES, triangulo.getType(3, 3, 3));
        }

        @Test
        public void testComputeReturnNotScaleneWhenTriangleIsNotIsosceles(){
            assertNotEquals(Triangle.TriangleType.SCALENE, triangulo.getType(2.4, 3, 3));
        }


    @Test
        public void testComputeReturnEquilateralWhenTriangleHasSidesWithDoubleValues(){
            assertEquals(Triangle.TriangleType.EQUILATERAL, triangulo.getType(1.2,1.2,1.2));
        }

        @Test
        public void testComputeReturnIsoscelesWhenTriangleHasSidesWithDoubleValues(){
            assertEquals(Triangle.TriangleType.ISOSCELES, triangulo.getType(1.2,2.4,2.4));
        }

        @Test
        public void testComputeReturnScaleneWhenTriangleHasSidesWithDoubleValues(){
            assertEquals(Triangle.TriangleType.SCALENE, triangulo.getType(1.2,2.4,3.2));
        }

        @Test
        public void testComputeReturnTriangleWhenValuesAreIntegerAndDouble(){
            assertEquals(Triangle.TriangleType.ISOSCELES, triangulo.getType(2, 3.4, 3.4));
        }


}