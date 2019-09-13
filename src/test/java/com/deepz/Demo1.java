package com.deepz;

import java.util.Scanner;
import java.util.Stack;

/**
 * created by zhangdingping on 2019/9/13
 */
public class Demo1 {
    static Boolean isOk = true;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        Stack<String> stack = new Stack<>();

        judgeStr(stack, str);
        if (isOk) {
            System.out.println("符合规则");
        } else {
            System.out.println("不符合规则！");
            System.exit(0);
        }
    }

    static void judgeStr(Stack<String> stack, String str) {
        for (int i = 0, len = str.length(); i < len; i++) {
            String opStr = String.valueOf(str.charAt(i));
            String pop;
            switch (opStr) {
                case "{":
                    if (stack.size() > 0 && ("{".equals(stack.peek()) || "(".equals(stack.peek()) || "[".equals(stack.peek()))) {
                        isOk = false;
                        return;
                    }
                    stack.push(opStr);
                    break;
                case "[":
                    if (stack.size() > 0 && ("[".equals(stack.peek()) || "(".equals(stack.peek()))) {
                        isOk = false;
                        return;
                    }
                    stack.push(opStr);
                    break;
                case "(":
                    if (stack.size() > 0 && "(".equals(stack.peek())) {
                        isOk = false;
                        return;
                    }
                    stack.push(opStr);
                    break;
                case "}":
                    if (stack.size() <= 0) {
                        isOk = false;
                        return;
                    }
                    pop = stack.pop();
                    if (!"{".equals(pop)) {
                        isOk = false;
                        return;
                    }
                    break;
                case "]":
                    if (stack.size() <= 0) {
                        isOk = false;
                        return;
                    }
                    pop = stack.pop();
                    if (!"[".equals(pop)) {
                        isOk = false;
                        return;
                    }
                    break;
                case ")":
                    if (stack.size() <= 0) {
                        isOk = false;
                        return;
                    }
                    pop = stack.pop();
                    if (!"(".equals(pop)) {
                        isOk = false;
                        return;
                    }
                    break;
                default:
                    isOk = false;
                    return;
            }
        }

        isOk = true;
    }
}
