package baekjoon.platinum.p5.빙고;

public class 빙고 {

    static final int A = 1;
    static final int B = 2;
    static final int C = 3;
    static final int D = 4;
    static final int E = 5;

    static boolean[][] bingo = new boolean[6][6];
    static int answerCount = 0;

    public static void main(String[] args) {
        solve(0);
        System.out.println("정답의 개수: " + answerCount);
    }

    static void solve(int idx) {
        if (idx == 25) {
            if (!a1()) return;
            if (!a2()) return;
            if (!a3()) return;
            if (!a4()) return;
            if (!a5()) return;
            if (!b1()) return;
            if (!b2()) return;
            if (!b3()) return;
            if (!b4()) return;
            if (!b5()) return;
            if (!c1()) return;
            if (!c2()) return;
            if (!c3()) return;
            if (!c4()) return;
            if (!c5()) return;
            if (!d1()) return;
            if (!d2()) return;
            if (!d3()) return;
            if (!d4()) return;
            if (!d5()) return;
            if (!e1()) return;
            if (!e2()) return;
            if (!e3()) return;
            if (!e4()) return;
            if (!e5()) return;

            answerCount += 1;

            for (int i = 1; i <= 5; i++) {
                for (int j = 1; j <= 5; j++) {
                    System.out.print(bingo[j][i] ? "#" : ".");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        int row = idx / 5 + 1;
        int col = idx % 5 + 1;

        bingo[row][col] = true;
        solve(idx + 1);
        bingo[row][col] = false;
        solve(idx + 1);
    }

    static boolean isBingoLine(int row, int col) {
        if ((row == 1 && col == 1 || row == 2 && col == 2 || row == 3 && col == 3 || row == 4 && col == 4 || row == 5 && col == 5)
                && isA1ToE5Exist()) return true;

        if ((row == 1 && col == 5 || row == 2 && col == 4 || row == 3 && col == 3 || row == 4 && col == 2 || row == 5 && col == 1)
                && isA5ToE1Exist()) return true;

        if (bingo[row][1] && bingo[row][2] && bingo[row][3] && bingo[row][4] && bingo[row][5]) return true;
        if (bingo[1][col] && bingo[2][col] && bingo[3][col] && bingo[4][col] && bingo[5][col]) return true;

        return false;
    }

    // A1 -> E5 대각선 빙고가 존재하는지 확인
    static boolean isA1ToE5Exist() {
        return bingo[A][1] && bingo[B][2] && bingo[C][3] && bingo[D][4] && bingo[E][5];
    }

    // A5 -> E1 대각선 빙고가 존재하는지 확인
    static boolean isA5ToE1Exist() {
        return bingo[A][5] && bingo[B][4] && bingo[C][3] && bingo[D][2] && bingo[E][1];
    }

    static boolean a1() {
        // A5에서 E1로 가는 대각선 줄은 빙고 줄이 아니다
        boolean flag = !(isA5ToE1Exist());
        return flag == bingo[A][1];
    }

    static boolean a2() {
        // A4는 색칠이 안 되어 있다
        boolean flag = !bingo[A][4];
        return flag == bingo[A][2];
    }

    static boolean a3() {
        // 이 칸(A3)은 빙고줄의 일부이다
        boolean flag = isBingoLine(A, 3);
        return flag == bingo[A][3];
    }

    static boolean a4() {
        // A2는 색칠이 안 되어 있다
        boolean flag = !bingo[A][2];
        return flag == bingo[A][4];
    }

    static boolean a5() {
        // E5는 색칠 되어 있다
        boolean flag = bingo[E][5];
        return flag == bingo[A][5];
    }

    static boolean b1() {
        // 이 칸은 빙고줄의 일부가 아니다
        boolean flag = !isBingoLine(B, 1);
        return flag == bingo[B][1];
    }

    static boolean b2() {
        // 모든 방향의 빙고줄이 존재한다 (가로, 세로, 대각선)
        boolean vertical = false;
        boolean horizontal = false;
        boolean diagonal = false;

        for (int i = 1; i <= 5; i++) {
            if (bingo[i][1] && bingo[i][2] && bingo[i][3] && bingo[i][4] && bingo[i][5]) {
                horizontal = true;
                break;
            }
        }

        for (int i = 1; i <= 5; i++) {
            if (bingo[1][i] && bingo[2][i] && bingo[3][i] && bingo[4][i] && bingo[5][i]) {
                vertical = true;
                break;
            }
        }

        if (isA1ToE5Exist() || isA5ToE1Exist()) diagonal = true;

        boolean flag = vertical && horizontal && diagonal;
        return flag == bingo[B][2];
    }

    static boolean b3() {
        // 색칠되어 있으나 빙고줄의 일부가 아닌 칸은 5개 이상이다
        int count = 0;

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                if (bingo[i][j] && !isBingoLine(i, j)) count++;
            }
        }

        boolean flag = count >= 5;
        return flag == bingo[B][3];
    }

    static boolean b4() {
        // 제 2행과 D열중 적어도 하나는 빙고 줄이다
        boolean flag = (bingo[A][2] && bingo[B][2] && bingo[C][2] && bingo[D][2] && bingo[E][2]) ||
                (bingo[D][1] && bingo[D][2] && bingo[D][3] && bingo[D][4] && bingo[D][5]);
        return flag == bingo[B][4];
    }

    static boolean b5() {
        // 이 문제의 정답은 한 개이다
        boolean flag = false;
        return flag == bingo[B][5];
    }

    static boolean c1() {
        // A1에서 E5로 가는 대각선 줄은 빙고 줄이다
        boolean flag = isA1ToE5Exist();
        return flag == bingo[C][1];
    }

    static boolean c2() {
        // 이 문장은 참이다
        boolean flag = true;
        return flag == bingo[C][2];
    }

    static boolean c3() {
        // 이 칸은 색칠되지 않았거나 빙고 줄의 일부이다
        boolean flag = !bingo[C][3] || isBingoLine(C, 3);
        return flag == bingo[C][3];
    }

    static boolean c4() {
        // C열에는 색칠된 칸이 3개 이하이다
        int count = 0;
        for (int i = 1; i <= 5; i++) {
            if (bingo[C][i]) count++;
        }
        boolean flag = count <= 3;
        return flag == bingo[C][4];
    }

    static boolean c5() {
        // 이 칸은 색칠되어 있다
        boolean flag = bingo[C][5];
        return flag == bingo[C][5];
    }

    static boolean d1() {
        // D4는 색칠 되어 있다
        boolean flag = bingo[D][4];
        return flag == bingo[D][1];
    }

    static boolean d2() {
        // 17개 이하의 칸이 색칠 되어 있다
        int count = 0;

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                if (bingo[i][j]) count++;
            }
        }

        boolean flag = count <= 17;
        return flag == bingo[D][2];
    }

    static boolean d3() {
        // 세로 빙고줄은 2개 이상이다

        int count = 0;

        if(bingo[A][1] && bingo[A][2] && bingo[A][3] && bingo[A][4] && bingo[A][5]) count++;
        if(bingo[B][1] && bingo[B][2] && bingo[B][3] && bingo[B][4] && bingo[B][5]) count++;
        if(bingo[C][1] && bingo[C][2] && bingo[C][3] && bingo[C][4] && bingo[C][5]) count++;
        if(bingo[D][1] && bingo[D][2] && bingo[D][3] && bingo[D][4] && bingo[D][5]) count++;
        if(bingo[E][1] && bingo[E][2] && bingo[E][3] && bingo[E][4] && bingo[E][5]) count++;

        boolean flag = count >= 2;
        return flag == bingo[D][3];
    }

    static boolean d4() {
        // D1은 색칠되어 있다
        boolean flag = bingo[D][1];
        return flag == bingo[D][4];
    }

    static boolean d5() {
        // 빙고 줄의 개수는 3개 이상이다
        int count = 0;
        for (int i = 1; i <= 5; i++) {
            if (bingo[i][1] && bingo[i][2] && bingo[i][3] && bingo[i][4] && bingo[i][5]) count++;
        }

        for (int i = 1; i <= 5; i++) {
            if (bingo[1][i] && bingo[2][i] && bingo[3][i] && bingo[4][i] && bingo[5][i]) count++;
        }

        if (isA1ToE5Exist()) count++;
        if (isA5ToE1Exist()) count++;

        boolean flag = count >= 3;
        return flag == bingo[D][5];
    }

    static boolean e1() {
        // 이 칸은 빙고줄의 일부이다
        boolean flag = isBingoLine(E, 1);
        return flag == bingo[E][1];
    }

    static boolean e2() {
        // 빙고 줄의 일부인 칸은 짝수 개이다
        int count = 0;

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                if (isBingoLine(i, j)) count++;
            }
        }

        boolean flag = count % 2 == 0 && count > 0;
        return flag == bingo[E][2];
    }

    static boolean e3() {
        // 빙고 줄의 일부가 아닌 칸은 10개 이상이다
        int count = 0;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                if (!isBingoLine(i, j)) count++;
            }
        }

        boolean flag = count >= 10;
        return flag == bingo[E][3];
    }

    static boolean e4() {
        // 대각선 빙고 줄이 있다
        boolean flag = isA1ToE5Exist() || isA5ToE1Exist();
        return flag == bingo[E][4];
    }

    static boolean e5() {
        // A5는 색칠되어 있다
        boolean flag = bingo[A][5];
        return flag == bingo[E][5];
    }
}