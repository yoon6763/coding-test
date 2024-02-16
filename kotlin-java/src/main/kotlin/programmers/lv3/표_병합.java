package programmers.lv3;

import java.util.*;

class Solution {
    int[] parent = new int[2500];
    String[] cell = new String[2500];
    List<String> answer = new ArrayList<>();

    public String[] solution(String[] commands) {
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
            cell[i] = "";
        }

        for(int i = 0; i < commands.length; i++) {
            String[] cmd = commands[i].split(" ");

            if(cmd[0].equals("UPDATE") && cmd.length == 4) {
                update(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]), cmd[3]);
            } else if(cmd[0].equals("UPDATE") && cmd.length == 3) {
                update(cmd[1], cmd[2]);
            } else if(cmd[0].equals("MERGE")) {
                merge(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]), Integer.parseInt(cmd[3]), Integer.parseInt(cmd[4]));
            } else if(cmd[0].equals("UNMERGE")) {
                unmerge(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
            } else if(cmd[0].equals("PRINT")) {
                print(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
            }
        }

        return answer.toArray(new String[0]);
    }

    void update(int x, int y, String value) {
        int index = toIndex(x, y);
        cell[find(index)] = value;
    }

    void update(String value1, String value2) {
        for(int i = 0; i < cell.length; i++) {
            if(cell[i].equals(value1)) {
                cell[i] = value2;
            }
        }
    }

    void merge(int x1, int y1, int x2, int y2) {
        int index1 = toIndex(x1, y1);
        int index2 = toIndex(x2, y2);

        int pIndex1 = find(index1);
        int pIndex2 = find(index2);
        if(pIndex1 == pIndex2) return;

        String rootString = cell[pIndex1].isEmpty() ? cell[pIndex2] : cell[pIndex1];
        cell[pIndex1] = "";
        cell[pIndex2] = "";
        union(pIndex1, pIndex2);
        cell[pIndex1] = rootString;
    }

    void unmerge(int x, int y) {
        int num = toIndex(x, y);
        int root = find(num);
        String rootString = cell[root];
        cell[root] = "";
        cell[num] = rootString;
        List<Integer> deleteList = new ArrayList<>();
        for (int i = 0; i < 2500; i++) {
            if (find(i) == root)
                deleteList.add(i);
        }
        for (Integer i : deleteList)
            parent[i] = i;
    }

    void print(int x, int y) {
        int num = toIndex(x, y);
        int root = find(num);
        if (cell[root].isEmpty())
            answer.add("EMPTY");
        else
            answer.add(cell[root]);
    }

    int toIndex(int x, int y) {
        return (x - 1) * 50 + y - 1;
    }

    int find(int a) {
        if(a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }

    void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }
}