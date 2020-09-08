package PA04;

import java.io.*;
import java.lang.String;
import java.util.Scanner;
import java.util.StringTokenizer;

public class No1 {
    static Scanner sc = new Scanner(System.in);
    public static int ch_print = 0;

    public static void main(String[] args) throws IOException {
        String[] Person = new String[500];
        Binary binary = new Binary();

        String menu_input, name_input;
        while (true) {
            System.out.print("$ ");
            menu_input = sc.next();
            if ("list".equals(menu_input)) {
                binary.Tree_Inorder(binary.root);
            } else if ("exit".equals(menu_input)) {
                break;
            } else {
                name_input = sc.next();
                if ("delete".equals(menu_input)) {
                    binary.Tree_Delete(name_input);
                } else if ("find".equals(menu_input)) {
                    ch_print = 1;
                    binary.Tree_Search(binary.root, name_input);
                } else if ("trace".equals(menu_input)) {
                    binary.Tree_Trace(binary.root, name_input);
                } else if ("save".equals(menu_input)) {
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\dbwls\\Desktop\\" + name_input), "MS949"));
                    bw.write("name,company_name,address,zip,phone,email\n");
                    binary.Tree_Save(binary.root, bw);
                    bw.close();
                } else if ("read".equals(menu_input)) {
                    int i = 0, ch = 0;
                    try {
                        File csv = new File("C:\\Users\\dbwls\\Desktop\\address_book2020.csv");
                        BufferedReader br = new BufferedReader(new FileReader(csv));
                        String line = "";
                        while ((line = br.readLine()) != null) {
                            if (ch == 0) {
                                ch = 1;
                            } else {
                                Person[i] = line;
                                i++;
                            }
                        }
                        br.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    for (int j = 0; j < 500; j++) {
                        binary.make_tree(Person[j]);
                    }
                }
            }
        }
    }

    public static class Binary {
        private Node root;

        protected class Node {
            private String data;     //배열 속 정보
            protected Node parent;   //인덱스로 표현
            protected Node left;
            protected Node right;

            public Node(String data) {
                this.data = data;
                left = null;
                right = null;
            }

            public String toString() {
                return data.toString();
            }

            public Node getLeft() {
                return left;
            }

            public Node getRight() {
                return right;
            }

            public String getData() {
                return data;
            }

            public Node getRoot() {
                return root;
            }
        }

        private void make_tree(String data) {   //트리 만들기
            //여기서 data는 배열에서 현재 있는 곳의 정보
            Node node = new Node(data);
            Node focus;
            Node parent_B;

            if (root == null) {
                root = node;
            } else {
                focus = root;
                while (true) {
                    parent_B = focus;
                    if (data.compareTo(parent_B.data) < 0) {   //data가 parent_B보다 작다
                        focus = parent_B.left;
                        if (focus == null) {   //왼쪽 노드 비었으면
                            parent_B.left = node;
                            node.parent = parent_B;
                            return;
                        }
                    } else {
                        focus = parent_B.right;
                        if (focus == null) {
                            parent_B.right = node;
                            node.parent = parent_B;
                            return;
                        }
                    }
                }
            }
        }

        private void Tree_Inorder(Node x) {              //LIST_INORDER
            if (x != null) {
                Tree_Inorder(x.getLeft());
                print_tok(x.getData());
                Tree_Inorder(x.getRight());
            }
        }

        private Node Tree_Search(Node x, String name) {  //FIND
            StringTokenizer token = new StringTokenizer(x.data);
            String data_name = token.nextToken(",");
            if (data_name.equals(name)) {
                if (ch_print == 1) {
                    print_tok(x.data);
                    ch_print = 0;
                }
                return x;
            }
            if (x.left == null && x.right == null) {
                System.out.println("\t검색 대상이 없습니다. 다시 입력해주세요. ");
                return null;
            }
            if (name.compareTo(x.data) < 0) {    //name이 x.data보다 작다
                if (x.left == null) {
                    System.out.println("\t검색 대상이 없습니다. 다시 입력해주세요. ");
                    return null;
                }
                return Tree_Search(x.left, name);
            } else {
                if (x.right == null) {
                    System.out.println("\t검색 대상이 없습니다. 다시 입력해주세요. ");
                    return null;
                }
                return Tree_Search(x.right, name);
            }
        }

        private Node Tree_Minimum(Node x) {
            while (x.left != null) {
                x = x.left;
            }
            return x;
        }

        private Node Tree_Successor(Node x) {
            Node y;
            if (x.right != null) {
                return Tree_Minimum(x.right);
            }
            y = x.parent;
            while (y != null && x == y.right) {
                x = y;
                y = y.parent;
            }
            return y;
        }

        private Node Tree_Delete(String name) {
            Node z = Tree_Search(root, name);
            if (z == null) {    //잘못 입력했을 경우
                return null;
            }
            Node T, x, y;    //y의 역할 : 우리가 실제로 삭제할 코드(z의 자식이 하나이거나 없을 경우 실제로 삭제해줄 노드)
            //자식노드가 없거나 하나일 경우
            T = root;
            if (z.left == null || z.right == null) {
                y = z;
            } else {
                y = Tree_Successor(z);
            }
            // 노드 y를 삭제하는 코드
            if (y.left != null) {
                x = y.left;
            } else {
                x = y.right;
            }
            if (x != null) {
                x.parent = y.parent;
            }
            if (y.parent == null) {
                T = x;
            } else if (y == y.parent.left) {
                y.parent.left = x;
            } else {
                y.parent.right = x;
            }
            //자식노드가 2개일 경우
            if (y != z) {
                z.data = y.data;
            }
            return y;
        }

        private Node Tree_Trace(Node x, String name) {
            StringTokenizer token = new StringTokenizer(x.data);
            String data_name = token.nextToken(",");

            if (data_name.equals(name)) {
                System.out.println(data_name);
                return x;
            }
            if (x.left == null && x.right == null) {
                System.out.println("\t검색 대상이 없습니다. 다시 입력해주세요. ");
                return null;
            }
            if (name.compareTo(x.data) < 0) {    //name이 x.data보다 작다
                if (x.left == null) {
                    System.out.println("\t검색 대상이 없습니다. 다시 입력해주세요. ");
                    return null;
                }
                System.out.println(data_name);
                return Tree_Trace(x.left, name);
            } else {
                if (x.right == null) {
                    System.out.println("\t검색 대상이 없습니다. 다시 입력해주세요. ");
                    return null;
                }
                System.out.println(data_name);
                return Tree_Trace(x.right, name);
            }
        }

        private void Tree_Save(Node x, BufferedWriter bw) throws IOException {
            if (x != null) {
                Tree_Save(x.getLeft(), bw);
                bw.write(x.getData() + "\n");
                Tree_Save(x.getRight(), bw);
            }
        }
    }

    private static void print_tok(String infor) {
        String[] tokarr = infor.split(",");
        int idx = 0;
        StringTokenizer token;

        System.out.println(tokarr[idx++]);    //name

        if (tokarr[idx].contains("\"")) {     //company
            token = new StringTokenizer(tokarr[idx]);
            String company = token.nextToken("\"");
            System.out.print("\tCompany: " + company + ",");
            idx++;
            while (true) {
                if (tokarr[idx].contains("\"")) {
                    token = new StringTokenizer(tokarr[idx]);
                    String str = token.nextToken("\"");
                    System.out.println(str);
                    idx++;
                    break;
                } else {
                    System.out.print(tokarr[idx++] + ",");
                }
            }
        } else {
            System.out.println("\tCompany: " + tokarr[idx++]);
        }

        if (tokarr[idx].contains("\"")) {         //address
            token = new StringTokenizer(tokarr[idx]);
            String address = token.nextToken("\"");
            System.out.print("\tAddress: " + address + ",");
            idx++;
            while (true) {
                if (tokarr[idx].contains("\"")) {
                    token = new StringTokenizer(tokarr[idx]);
                    String str = token.nextToken("\"");
                    System.out.println(str);
                    idx++;
                    break;
                } else {
                    System.out.print(tokarr[idx++] + ",");
                }
            }
        } else {
            System.out.println("\tAddress: " + tokarr[idx++]);
        }
        System.out.println("\tZipcode: " + tokarr[idx++]);
        System.out.println("\tPhones: " + tokarr[idx++]);
        System.out.println("\tEmail: " + tokarr[idx++]);
    }
}