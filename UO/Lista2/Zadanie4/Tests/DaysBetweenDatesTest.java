import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DaysBetweenDatesTest {

    @Test
    void testCheckDate_Case1() {
        // given
        int day1 = 1;
        int month1 = 1;
        int year1 = 2000;

        int day2 = 1;
        int month2 = 1;
        int year2 = 2002;

        // when
        int daysBetween = DaysBetweenDates.daysBetweenDates(day1, month1, year1, day2, month2, year2);

        // then
        assertEquals(731, daysBetween);
    }

    @Test
    void testCheckDate_Case2() {
        // given
        int day1 = 1;
        int month1 = 3;
        int year1 = 2000;

        int day2 = 1;
        int month2 = 3;
        int year2 = 2002;

        // when
        int daysBetween = DaysBetweenDates.daysBetweenDates(day1, month1, year1, day2, month2, year2);

        // then
        assertEquals(730, daysBetween);
    }

    @Test
    void testCheckDate_Case3() {
        // given
        int day1 = 1;
        int month1 = 1;
        int year1 = 2002;

        int day2 = 1;
        int month2 = 1;
        int year2 = 2004;

        // when
        int daysBetween = DaysBetweenDates.daysBetweenDates(day1, month1, year1, day2, month2, year2);

        // then
        assertEquals(730, daysBetween);
    }

    @Test
    void testCheckDate_Case4() {
        // given
        int day1 = 1;
        int month1 = 3;
        int year1 = 2002;

        int day2 = 1;
        int month2 = 3;
        int year2 = 2004;

        // when
        int daysBetween = DaysBetweenDates.daysBetweenDates(day1, month1, year1, day2, month2, year2);

        // then
        assertEquals(731, daysBetween);
    }

    @Test
    void testCheckDate_Case5() {
        // given
        int day1 = 1;
        int month1 = 1;
        int year1 = 2003;

        int day2 = 1;
        int month2 = 1;
        int year2 = 2005;

        // when
        int daysBetween = DaysBetweenDates.daysBetweenDates(day1, month1, year1, day2, month2, year2);

        // then
        assertEquals(731, daysBetween);
    }

    @Test
    void testCheckDate_Case6() {
        // given
        int day1 = 1;
        int month1 = 1;
        int year1 = 2005;

        int day2 = 1;
        int month2 = 1;
        int year2 = 2007;

        // when
        int daysBetween = DaysBetweenDates.daysBetweenDates(day1, month1, year1, day2, month2, year2);

        // then
        assertEquals(730, daysBetween);
    }
}