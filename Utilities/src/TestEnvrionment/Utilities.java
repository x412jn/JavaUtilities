package TestEnvrionment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Utilities
{
    public static Utilities instance;

    Utilities()
    {
        if (instance == null)
        {
            instance = this;
        }
        else
        {
            return;
        }
    }

    public static void printLinkedList(LinkedList<Integer> head)
    {
        System.out.println(head.toString());
    }

    public static void printListNodes(ListNode head)
    {
        List<Integer> list = new LinkedList<>();
        while (head != null)
        {
            list.add((Integer) head.value);
            head = head.next;
        }
        System.out.println(list.toString());
    }

    public static void printArray(int[] array)
    {
        System.out.println(Arrays.toString(array));
    }

    public static void printTree(TreeNode root, int space, int COUNT)
    {
        // Base case
        if (root == null)
        {
            return;
        }

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        printTree(root.right, space, COUNT);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.key + "\n");

        // Process left child
        printTree(root.left, space, COUNT);
    }

    public static TreeNode treeFromArray(String[] array)
    {
        //turn array into list;
        List<String> list = new LinkedList<>(Arrays.asList(array));
        System.out.println(list.toString());
        //check if first element is null, if so, seize
        if (list.get(0) == "#")
        {
            return null;
        }
        else
        {
            //generate root node for return
            TreeNode root = new TreeNode(Integer.parseInt(list.remove(0)));
            //generate queue for helper, [HELPER ONLY CONTAINS NODES THAT FEASIBLE TO BE PARENT NODE]
            Queue<TreeNode> queue = new LinkedList<>();
            //helper gain root for initiation
            queue.offer(root);

            /*
                      HELPER
              poll ← 1-2-3-4-5 ← offer

              we will draw first element (or, first remaining parent node) from helper on each iteration,
              each iteration, we check if we have valid child nodes from list or not,
              if not, then we return nothing back to helper, means this route has come to its end,
              if so, we return its child nodes back to end of helper, that will ensure only previous parents nodes
              can be draw from list on next iteration than later ones.
             */

            //DECLARE INPUT VAR

            String strLeft;
            String strRight;
            while (!queue.isEmpty())
            {
                //get and remove first element on queue
                TreeNode node = queue.poll();
                //Initiation of left right input, we will always assume there will be a null input to prevent npe
                strLeft = "#";
                strRight = "#";
                //do a list empty check to prevent potential npe
                if (!list.isEmpty())
                {
                    strLeft = list.remove(0);
                }
                if (!list.isEmpty())
                {
                    strRight = list.remove(0);
                }
                node.left = strLeft == "#" ? null : new TreeNode(Integer.parseInt(strLeft));
                node.right = strRight == "#" ? null : new TreeNode(Integer.parseInt(strRight));
                //offer next available parent nodes to the tail of queue,
                // this will ensure only existing sub node can be offered
                if (node.left != null)
                {
                    queue.offer(node.left);

                }
                if (node.right != null)
                {
                    queue.offer(node.right);
                }
            }
            return root;
        }
    }

    public static TreeNode treeFromArray(Integer[] array)
    {
        //turn array into list;
        List<Integer> list = new LinkedList<>(Arrays.asList(array));
        System.out.println(list.toString());
        //generate queue for helper, [HELPER ONLY CONTAINS NODES THAT FEASIBLE TO BE PARENT NODE]
        if (list.get(0) == null)
        {
            return null;
        }
        else
        {
            //generate root node for return
            TreeNode root = new TreeNode(list.remove(0));
            //generate queue for helper, [HELPER ONLY CONTAINS NODES THAT FEASIBLE TO BE PARENT NODE]
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            //DECLARE INPUT VAR
            Integer left;
            Integer right;

            while (!queue.isEmpty())
            {
                //get and remove first element on queue
                TreeNode node = queue.poll();
                //Initiation of left right input, we will always assume there will be a null input to prevent npe
                left = null;
                right = null;
                //do a list empty check to prevent potential npe
                if (!list.isEmpty())
                {
                    left = list.remove(0);
                }
                if (!list.isEmpty())
                {
                    right = list.remove(0);
                }
                node.left = left == null ? null : new TreeNode(left);
                node.right = right == null ? null : new TreeNode(right);
                //offer next available parent nodes to the tail of queue,
                // this will ensure only existing sub node can be offered
                if (node.left != null)
                {
                    queue.offer(node.left);
                }
                if (node.right != null)
                {
                    queue.offer(node.right);
                }
            }
            return root;
        }
    }


    public static LinkedList<Integer> generateIntegerLinkedListFromArray(int[] array)
    {
        LinkedList<Integer> result = new LinkedList<Integer>();
        for (int i = 0; i < array.length; i++)
        {
            result.add(array[i]);
        }
        return result;
    }

    public static ListNode generateListNodeFromArray(int[] array)
    {
        ListNode head = new ListNode(0);
        ListNode node = head;
        for (int i = 0; i < array.length; i++)
        {
            node.next = new ListNode(array[i]);
            node = node.next;
        }
        return head.next;
    }



    public static int findHeightOfTree(TreeNode root, int index)
    {
        if (root == null)
        {
            return index;
        }
        index++;
        int left = findHeightOfTree(root.left, index);
        int right = findHeightOfTree(root.right, index);
        if (index < left)
        {
            index = left;
        }
        if (index < right)
        {
            index = right;
        }
        return index;
    }

    public static void swapArrayElements(int[] array, int start, int end)
    {
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }

    public static ListNode reverseListNode(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        ListNode newHead = reverseListNode(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static ListNode getMidListNode(ListNode head)
    {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
