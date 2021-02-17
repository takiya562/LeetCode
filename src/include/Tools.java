package include;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;


public class Tools {

    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }
    
        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
    
            if (node == null) {
              output += "null,";
              continue;
            }
    
            output += String.valueOf(node.val) + ",";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 1) + "]";
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }
    
        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
    
        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }   

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static int[][] stringToIntegerMatrix(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0][0];
        }

        String[] parts = input.split("(?<=]),(?=\\[)");
        int[][] output = new int[parts.length][];
        for (int i = 0; i < parts.length; i++) {
            int[] item = stringToIntegerArray(parts[i].trim());
            output[i] = item;
        }
        return output;
    }

    public static <T> String ArrayToString(T[] array) {
        if (array == null)  return "[]";
        int n = array.length;
        if (n == 0) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < n - 1; i++) {
            sb.append(array[i].toString()).append(",");
        }
        sb.append(array[n - 1].toString()).append("]");
        return sb.toString();
    }

    public static String IntegerArrayToString(int[] array) {
        if (array == null)  return "[]";
        int n = array.length;
        if (n == 0) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < n - 1; i++) {
            sb.append(array[i]).append(",");
        }
        sb.append(array[n - 1]).append("]");
        return sb.toString();
    }

    public static String IntegerMatrixToString(int[][] matrix) {
        if (matrix == null) return "[]";
        int n = matrix.length;
        if (n == 0) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < n - 1; i++) {
            int[] array = matrix[i];
            sb.append(IntegerArrayToString(array)).append(",");
        }
        sb.append(IntegerArrayToString(matrix[n - 1])).append("]");
        return sb.toString();
    }

    public static <T> String ListToString(List<T> list) {
        if (list == null)   return "[]";
        int n = list.size();
        if (n == 0) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < n - 1; i++) {
            sb.append(list.get(i).toString()).append(",");
        }
        sb.append(list.get(n - 1).toString()).append("]");
        return sb.toString();
    }

    public static <T> String ListsToString(List<List<T>> lists) {
        if (lists == null)  return "[]";
        int n = lists.size();
        if (n == 0) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < n - 1; i++) {
            sb.append(ListToString(lists.get(i))).append(",");
        }
        sb.append(ListToString(lists.get(n - 1))).append("]");
        return sb.toString();
    }

    public static String[] stringToStringArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        String[] parts = input.split(",");
        String[] output = new String[parts.length];
        for (int i = 0; i < parts.length; i++) {
            String item = parts[i].substring(1, parts[i].length() - 1);
            output[i] = item;
        }
        return output;
    }

    public static char[] stringToCharArray(String input) {
        input = input.trim();
        if (input.length() == 0)    return new char[]{};
        input = input.substring(1, input.length() - 1);
        String[] parts = input.split(",");
        char[] output = new char[parts.length];
        for (int i = 0; i < parts.length; i++) {
            char part = parts[i].charAt(1);
            output[i] = part;
        }
        return output;
    }

    public static char[][] stringToCharMatrix(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        String[] parts = input.split("(?<=]),(?=\\[)");
        char[][] output = new char[parts.length][];
        for (int i = 0; i < parts.length; i++) {
            char[] part = stringToCharArray(parts[i]);
            output[i] = part;
        }
        return output;
    }

    public static void prettyPrintCharArray(char[] chars) {
        int n = chars.length;
        if (n == 0) return;
        for (int i = 0; i < n - 1; i++)
            System.out.print(chars[i] + ",");
        System.out.println(chars[n - 1]);
    }

    public static void prettyPrintCharMatrix(char[][] matrix) {
        for (char[] chars : matrix)
            prettyPrintCharArray(chars);
    }

    public static String prettyCharArrayToString(char[] chars) {
        int n = chars.length;
        if (n == 0) return "";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < n - 1; i++)
            sb.append("\"").append(chars[i]).append("\",");
        sb.append("\"").append(chars[n - 1]).append("\"").append("]");
        return sb.toString();
    }

    public static String prettyCharMatrixToString(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) return "";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < n - 1; i++)
            sb.append(prettyCharArrayToString(matrix[i])).append(",");
        sb.append(prettyCharArrayToString(matrix[n - 1])).append("]");
        return sb.toString();
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static ListNode[] stringToListNodeArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0)
            return new ListNode[0];

        String[] parts = input.split("(?<=]),(?=\\[)");
        ListNode[] output = new ListNode[parts.length];
        for (int i = 0; i < parts.length; i++) {
            output[i] = stringToListNode(parts[i]);
        }
        return output;
    }

    public static void prettyPrintLinkedList(ListNode node) {
        while (node != null && node.next != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }

        if (node != null) {
            System.out.println(node.val);
        } else {
            System.out.println("Empty LinkedList");
        }
    }
}

class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            char[][] matrix = Tools.stringToCharMatrix(line);
            Tools.prettyPrintCharMatrix(matrix);
        }
    }
}
