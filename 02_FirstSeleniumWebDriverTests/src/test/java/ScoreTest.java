import org.junit.Assert;
import org.junit.Test;
/*
    Всего ученик может заработать максимум 100 баллов, минимум 0.
    Его оценка за экзамен может принимать следующие значения: 2, 3, 4 или 5.

    Если ученик получил за экзамен:
    - от 0 баллов (включительно) до 35 (включительно), его оценка равна 2;
    - от 35 баллов (не включительно) до 56 (включительно), его оценка равна 3;
    - от 56 баллов (не включительно) до 71 (включительно), его оценка равна 4;
    - от 72 баллов (включительно) до 100 баллов (включительно), его оценка равна 5.
     */
    public class ScoreTest {
        @Test
        public void test1Result2() {
            var actualResult = getMarkResult ( 0 );
            Assert.assertEquals ( "2", actualResult );
        }

        @Test
        public void test2Result2() {
            var actualResult = getMarkResult ( 10 );
            Assert.assertEquals ( "2", actualResult );
        }

        @Test
        public void test3Result2() {
            var actualResult = getMarkResult ( 34 );
            Assert.assertEquals ( "2", actualResult );
        }

        @Test
        public void test4Result2() {
            var actualResult = getMarkResult ( 35 );
            Assert.assertEquals ( "2", actualResult );
        }

        @Test
        public void test5Result3() {
            var actualResult = getMarkResult ( 36 );
            Assert.assertEquals ( "3", actualResult );
        }

        @Test
        public void test6Result3() {
            var actualResult = getMarkResult ( 48 );
            Assert.assertEquals ( "3", actualResult );
        }

        @Test
        public void test7Result3() {
            var actualResult = getMarkResult ( 55 );
            Assert.assertEquals ( "3", actualResult );
        }

        @Test
        public void test8Result3() {
            var actualResult = getMarkResult ( 56 );
            Assert.assertEquals ( "3", actualResult );
        }

        @Test
        public void test9Result4() {
            var actualResult = getMarkResult ( 57 );
            Assert.assertEquals ( "4", actualResult );
        }

        @Test
        public void test10Result4() {
            var actualResult = getMarkResult ( 58 );
            Assert.assertEquals ( "4", actualResult );
        }

        @Test
        public void test11Result4() {
            var actualResult = getMarkResult ( 70 );
            Assert.assertEquals ( "4", actualResult );
        }

        @Test
        public void test12Result4() {
            var actualResult = getMarkResult ( 71 );
            Assert.assertEquals ( "4", actualResult );
        }

        @Test
        public void test13Result5() {
            var actualResult = getMarkResult ( 72 );
            Assert.assertEquals ( "5", actualResult );
        }

        @Test
        public void test14Result5() {
            var actualResult = getMarkResult ( 73 );
            Assert.assertEquals ( "5", actualResult );
        }

        @Test
        public void test15Result5() {
            var actualResult = getMarkResult ( 99 );
            Assert.assertEquals ( "5", actualResult );
        }



    private String getMarkResult(Integer mark)
    {
        if(mark>=0 && mark <=35) return "2";
        if(mark>35 && mark <=56) return "3";
        if(mark>56 && mark<71) return "4";
        if(mark>72 && mark<100) return "5";
        return "no mark result";
    }
}
