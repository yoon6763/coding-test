public class Main {
    public static void main(String[] args) {

        int caseCnt = 50000000;

        // case 1 - sb.append(str + "\n")
        long case1StartTime = System.currentTimeMillis();

        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < caseCnt; i++) {
            sb1.append(i + "\n");
        }
        long case1EndTime = System.currentTimeMillis();


        // case 2 - sb.append(str).append("\n")
        long case2StartTime = System.currentTimeMillis();

        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < caseCnt; i++) {
            sb2.append(i).append("\n");
        }
        long case2EndTime = System.currentTimeMillis();


        System.out.println(case1EndTime - case1StartTime);
        System.out.println(case2EndTime - case2StartTime);
    }
}
