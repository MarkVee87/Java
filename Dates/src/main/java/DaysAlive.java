import java.time.LocalDateTime;

class DaysAlive {

    private int dayOfBirth, monthOfBirth, yearOfBirth;
    private int currentDay, currentMonth, currentYear;
    private int sumOfDays;

    DaysAlive(int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        LocalDateTime currentDateTime = LocalDateTime.now();
        this.currentDay = currentDateTime.getDayOfMonth();
        this.currentMonth = currentDateTime.getMonthValue();
        this.currentYear = currentDateTime.getYear();
    }

    public void run() {
        System.out.println("Date of birth (day/month/year): " + dayOfBirth + "/" + monthOfBirth + "/" + yearOfBirth);
        System.out.println("Current date (day/month/year): " + currentDay + "/" + currentMonth + "/" + currentYear);
        checkYearsUpToPresent();
        minusDaysBeforeBirth();
        minusDaysRemainingInCurrentYear();
        System.out.println("Total days alive: " + sumOfDays);
    }

    private void minusDaysRemainingInCurrentYear() {
        int count = 0;
        for (int i = currentMonth; i <= 12; i++) {
            if (i != currentMonth) {
                count += numOfDaysInMonth(currentMonth, currentYear);
            } else {
                count += numOfDaysInMonth(currentMonth, currentYear) - currentDay;
            }
        }
        sumOfDays -= count;
    }

    private void minusDaysBeforeBirth() {
        int count = 0;
        for (int i = 1; i <= monthOfBirth; i++) {
            if (i != monthOfBirth) {
                count += numOfDaysInMonth(i, yearOfBirth);
            } else {
                count += dayOfBirth;
            }
        }
        sumOfDays -= count;
    }

    private int numOfDaysInMonth(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
        }
        return 0;
    }


    private void checkYearsUpToPresent() {
        int year = yearOfBirth;
        int daysInYear;
        while (year <= currentYear) {
            daysInYear = numOfDaysInYear(year);
            sumOfDays += daysInYear;
            year++;
        }
    }

    private int numOfDaysInYear(int year) {
        if (isLeapYear(year)) {
            return 366;
        } else {
            return 365;
        }
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0) || ((year % 100 == 0) && (year % 400 == 0));
    }
}