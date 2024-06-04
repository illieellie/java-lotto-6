package lotto;

public enum LottoGrade {

    GRADE_1(1, 7, 2000000000),
    GRADE_2(2, 6, 30000000),
    GRADE_3(3, 5, 1500000),
    GRADE_4(4, 4, 50000),
    GRADE_5(5, 3, 5000),
    GRADE_N(0, 0, 0);

    private int grade;
    private int score;
    private int money;

    LottoGrade(int gradeNumber, int score, int money) {
        this.grade = gradeNumber;
        this.score = score;
        this.money  = money;
    }

    public int getGrade(){
        return grade;
    }

    public int getMoney(){
        return money;
    }

    public int getScore(){
        return score;
    }

    public static int getGradeFromScore(int score) {
        for (LottoGrade lottoScore : LottoGrade.values()) {
            if (lottoScore.getScore()== score) {
                return lottoScore.getGrade();
            }
        }
        return GRADE_N.getGrade();
    }


}
