package recursion;

import java.util.Stack;

public class HanoiSolver {
    public static void exchange(Stack from, Stack help, Stack to, int count) {
        if (count > 0) {
            exchange(from,to,help,count-1); // перенести башню из n−1 диска на 2-й штырь
            int biggest = (int) from.pop();
            to.push(biggest); // переносим самый большой диск на 3-й штырь
            exchange(help,from,to,count-1); // перенеси башню из n−1 диска на 3-й штырь
        }
    }

    public static void main(String[] args) {
        Stack<Integer> from = new Stack<>();
        Stack<Integer> to = new Stack<>();
        Stack<Integer> help = new Stack<>();

        from.push(3);
        from.push(2);
        from.push(1);

        System.out.println("print from = " + from);
        exchange(from, help, to, from.size());
        System.out.println("print to = "+ to);
    }
} 