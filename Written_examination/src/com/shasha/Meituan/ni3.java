package com.shasha.Meituan;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author ShaLuwei
 * @create 2022-09-03 12:18
 */
public class ni3 {

    static Node[] tree;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        tree = new Node[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new Node();
        }
        for (int i = 1; i < n; i++) {
            int parent = in.nextInt() - 1;
            tree[parent].children.add(tree[i]);
        }
        in.nextLine();
        String values = in.nextLine();
        for (int i = 0; i < n; i++) {
            tree[i].value = values.charAt(i);
        }
        dfs(tree[0]);
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", tree[i].chars.size());
        }
    }
    static void dfs(Node root) {
        Set<Character> chars = new HashSet<>();
        chars.add(root.value);
        while (!root.children.isEmpty()) {
            Node child = root.children.pollFirst();
            dfs(child);
            chars.addAll(child.chars);
        }
        root.chars = chars;
    }

}

class Node {
    public ArrayDeque<Node> children;
    public char value;
    public Set<Character> chars;
    public Node() {
        children = new ArrayDeque<>();
        value = '0';
        chars = null;
    }
}