//코드가 너무 더러워서 수정해야 함
//C번 미완성 

package W11;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class W11 {
    static Scanner sc = new Scanner(System.in);
    static MyLinkedList[] road_node = new MyLinkedList[50000];

    public static class MyLinkedList {
        Node head;
        Node tail;
        private int size = 0;

        private class Node {
            Object data;    //데이터가 저장될 필드
            double dist;
            int visited_BFS=-1;  //(a)번
            int visited_DFS=0;   //(b)번
            double disRoute=999999;  //(c)번 (무한대로 초기화)

            private Node next;    //다음 노드를 가리키는 필드

            public Node(Object input) {
                this.data = input;
                this.next = null;
            }
            public String toString(){
                return String.valueOf(this.data);
            }
        }

        public void addFirst(Object input) {
            Node newNode = new Node(input); //노드 생성
            newNode.next = head;    //새로운 노드의 다음 노드는 헤드
            head = newNode; //헤드는 새로운 노드
            size++;
            if (head.next == null) {
                tail = head;
            }
        }

        public void addLast(Object input) {
            Node newNode = new Node(input);   //노드 생성
            if (size == 0) {
                addFirst(input);
            } else {
                tail.next = newNode;
                tail = newNode;   //마지막 노드 갱신
                size++;
            }
        }
    }

    static String arr_alabama[] = new String[15000];
    public static void main(String[] args) throws IOException {
        String arr_roadlist[] = new String[50000];
        int String_idx = 0;
        try {
            File txt = new File("C:\\Users\\dbwls\\Desktop\\roadList2.txt");
            BufferedReader br = new BufferedReader(new FileReader(txt));
            String line = "";
            while ((line = br.readLine()) != null) {
                arr_roadlist[String_idx] = line;
                String_idx++;
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String_idx = 0;
        try {
            File txt = new File("C:\\Users\\dbwls\\Desktop\\alabama.txt");
            BufferedReader br = new BufferedReader(new FileReader(txt));
            String line = "";
            while ((line = br.readLine()) != null) {
                arr_alabama[String_idx] = line;
                String_idx++;
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 여기까지 파일에서 배열로 저장 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

        int i = 0, j = 0, idx = 0;
        double[] dist_arr = new double[50000];
        String S_lat1 = null, S_lat2 = null, S_lon1 = null, S_lon2 = null;
        while (arr_alabama[j] != null) {
            AlabamaTok(arr_alabama[j]);
            j++;
        }
        j=0;
        while (arr_roadlist[j] != null) {
            RoadlistTok(arr_roadlist[j]);   //A와 B로 나누기
            j++;
        }
        int cnt;
        while (arr_roadlist[i] != null) {   //거리 구하기
            j = 0;
            cnt = 0;
            while (arr_alabama[j] != null) {
                if (cnt == 2) {
                    break;
                } else if (A[i].equals(area[j])) {
                    S_lon1 = lon[j];
                    S_lat1 = lat[j];
                    cnt++;
                } else if (B[i].equals(area[j])) {
                    S_lon2 = lon[j];
                    S_lat2 = lat[j];
                    cnt++;
                }
                j++;
            }
            double lat1, lon1, lat2, lon2;
            lat1 = Double.parseDouble(S_lat1);
            lon1 = Double.parseDouble(S_lon1);
            lat2 = Double.parseDouble(S_lat2);
            lon2 = Double.parseDouble(S_lon2);

            dist_arr[idx++] = calDistance(lat1, lon1, lat2, lon2);    //A와 B의 거리 계산하여 거리 배열에 넣기
            i++;
        }

        //ㅡㅡㅡㅡㅡ 리스트 만들기 ㅡㅡㅡㅡㅡ
        i=0;

        int a=1, nodeIdx=0;
        road_node[nodeIdx]=new MyLinkedList();
        road_node[nodeIdx].addLast(A[i]);
        while(arr_roadlist[i]!=null) {
            if (A[a - 1].equals(A[a])){
                road_node[nodeIdx].addLast(B[i]);
            }
            else {
                road_node[nodeIdx].addLast(B[i]);
                nodeIdx++;
                road_node[nodeIdx] = new MyLinkedList();
                road_node[nodeIdx].addLast(A[a]);
            }
            i++;  a++;
        }

        int n=0;
        i=0;
        MyLinkedList.Node p = road_node[i].head.next;
        while(true) {   //road_node에 거리 넣어주기
            if (p == null) {
                i++;
                p = road_node[i].head.next;
            }
            if(road_node[i].head.data==null){
                break;
            }
            p.dist = dist_arr[n++];
            p = p.next;
        }

        i=0;    //오른쪽 왼쪽 중복된 경우 리스트에 넣어주기
        n=0;
        while (true) {
            if (B[i] == null) {
                break;
            }
            if (B[i].equals(road_node[n].head.data)) {
                road_node[n].addLast(A[i]);
                road_node[n].tail.dist = dist_arr[i];
                i++;
                n = 0;
            }
            n++;
            if (road_node[n] == null) {
                road_node[nodeIdx] = new MyLinkedList();
                road_node[nodeIdx].addLast(B[i]);
                road_node[nodeIdx].addLast(A[i]);
                road_node[nodeIdx].tail.dist = dist_arr[i];
                nodeIdx++;
                i++;
                n = 0;
            }
        }
        //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
        //ㅡㅡㅡ a번 10홉 이내의 모든 지점 출력하기 ㅡㅡㅡ
        String input_a;
        System.out.print("a. 임의의 한 지점 입력 : ");
        input_a=sc.nextLine();

        BFS(0,input_a);   //a번


        //ㅡㅡㅡ b번 DFS로 순회하며 모든 지점 출력하기 ㅡㅡㅡ
        String input_b;
        System.out.print("b. 임의의 한 지점 입력 : ");
        input_b=sc.nextLine();

        DFS(0, input_b);    //b번


        int fi=0;
        while(DFS_file[fi]!=null) {
            dfsSave.append(DFS_file[fi]).append("\n");
            fi++;
        }
        FileWriter fileWriter =new FileWriter("b번 DFS 출력.txt");
        BufferedWriter bufferedWriter =new BufferedWriter(fileWriter);
        bufferedWriter.write(dfsSave.toString());
        fileWriter.flush();
        bufferedWriter.close();
        System.out.println("파일 저장 완료!\n");


        //ㅡㅡㅡ c번 Dijkstra 알고리즘으로 최단 경로 찾기 ㅡㅡㅡ
        String input_c1, input_c2;
        System.out.println("c. 두 지점 입력하기 ");
        System.out.print("지점 1 입력 : ");
        input_c1=sc.nextLine();
        System.out.print("지점 2 입력 : ");
        input_c2=sc.nextLine();

        DIJKSTRA(input_c1,input_c2);
    }

    public static StringBuilder dfsSave=new StringBuilder();

    static String[] DFS_file=new String[15000];
    static int file_idx=0;
    private static void DFS(int idx, String input_b) {  //b번. DFS
        while (road_node[idx] != null) {
            if (road_node[idx].head.data.equals(input_b)) {    //input_b 위치 인덱스 찾기
                break;
            }
            idx++;
        }
        road_node[idx].head.visited_DFS = 1;    //방문한 곳은 visited = 1

        //ㅡㅡㅡㅡ중복된 부분 다 visited = 1 만들어주기
        int z=0;
        MyLinkedList.Node w=road_node[idx].head.next; //세로
        MyLinkedList.Node j=road_node[0].head.next;   //가로
        while(w!=null){
            while(road_node[z]!=null){
                if(road_node[z].head.data.equals(w.data)){
                    j=road_node[z].head.next;
                    while((j!=null)&&(!j.data.equals(road_node[idx].head.data))){
                        j=j.next;
                    }
                    if(j!=null) {
                        j.visited_DFS = 1;
                    }
                    break;  //
                }
                z++;
            }
            w=w.next;
            z=0;
        }
        //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
        z=0;
        while(area[z]!=null) {  //출력
            if (area[z].equals(road_node[idx].head.data)) {
                DFS_file[file_idx++]=arr_alabama[z];
                //System.out.println(area[z] + "\t" + lon[z] + "\t" + lat[z]);
                break;
            }
            z++;
        }
        MyLinkedList.Node q=road_node[idx].head.next;
        while(true) {  //재귀위해 while
            while (q.visited_DFS == 1) {  //이미 방문한 곳일 때
                q = q.next;
                if (q == null) {
                    break;
                }
            }
            if (q != null && q.visited_DFS == 0) {   //방문 X일 때
                input_b = (String) q.data;
                DFS(0, input_b);
            }
            else {
                return;
            }
        }
    }

    public static void BFS(int idx, String input_a) {
        Queue<Object> queue = new LinkedList<Object>();

        while (road_node[idx] != null) {
            if (road_node[idx].head.data.equals(input_a)) {    //input_a 위치 인덱스 찾기
                break;
            }
            idx++;
        }

        queue.offer(road_node[idx].head);
        road_node[idx].head.visited_BFS = 0;    //처음 방문한 곳은 visited = 0
        //ㅡㅡㅡㅡ중복된 부분 다 visited = 0 만들어주기
        int z=0;
        MyLinkedList.Node w=road_node[idx].head.next; //세로
        MyLinkedList.Node j;   //가로
        while(w!=null){
            while(road_node[z]!=null){
                if(road_node[z].head.data.equals(w.data)){
                    j=road_node[z].head.next;
                    while((j!=null)&&(!j.data.equals(road_node[idx].head.data))){
                        j=j.next;
                    }
                    if(j!=null) {
                        j.visited_BFS = 0;
                    }
                    break;  //
                }
                z++;
            }
            w=w.next;
            z=0;
        }
        //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

        MyLinkedList.Node u=road_node[idx].head;
        MyLinkedList.Node v;  MyLinkedList.Node Real_v;
        int v_idx=idx;
        Object Q_u; int ch=0;
        while(queue!=null) {
            queue.poll();
            Real_v = road_node[v_idx].head.next;

            while (Real_v != null) {
                if(ch==0){
                    u = road_node[idx].head;
                    ch=1;
                }

                v_idx = 0;
                while (road_node[v_idx] != null) {
                    if (road_node[v_idx].head.data.equals(Real_v.data)) {    //input_a 위치 인덱스 찾기
                        break;
                    }
                    v_idx++;
                }

                v=road_node[v_idx].head;
                if (v.visited_BFS == -1) {
                    v.visited_BFS = u.visited_BFS + 1;
                    //ㅡㅡㅡㅡ 중복된 부분 다 visited + 1 만들어주기 ㅡㅡㅡㅡ
                    z=0;
                    w=road_node[v_idx].head.next; //세로
                    j=road_node[0].head.next;   //가로
                    while(w!=null){
                        while(road_node[z]!=null){
                            if(road_node[z].head.data.equals(w.data)){
                                j=road_node[z].head.next;
                                while((j!=null)&&(!j.data.equals(road_node[v_idx].head.data))){
                                    j=j.next;
                                }
                                if(j!=null) {
                                    j.visited_BFS = u.visited_BFS + 1;
                                }
                                break;  //
                            }
                            z++;
                        }
                        w=w.next;
                        z=0;
                    }
                    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
                    queue.offer(v);
                }
                Real_v = Real_v.next;
            }
            if(queue.size()==0){
                break;
            }
            Q_u = queue.element();
            v_idx = 0;
            while (road_node[v_idx] != null) {
                if (road_node[v_idx].head.equals(Q_u)) {    //input_a 위치 인덱스 찾기
                    break;
                }
                v_idx++;
            }
            u = road_node[v_idx].head;
            idx=v_idx;
        }

        int bfs_idx=0;
        while(road_node[bfs_idx]!=null){    //출력하기
            int aaa=0;
            if(road_node[bfs_idx].head.visited_BFS<=10) {
                while(area[aaa]!=null) {
                    if (area[aaa].equals(road_node[bfs_idx].head.data)) {
                        System.out.println(area[aaa]);
                        break;
                    }
                    aaa++;
                }
            }
            bfs_idx++;
        }
        System.out.println();
    }

    public static void DIJKSTRA(String input1, String input2){
        PriorityQueue Queue=new PriorityQueue();    //우선순위 큐

        int idx=0;
        while (road_node[idx] != null) {
            if (road_node[idx].head.data.equals(input1)) {    //input1 위치 인덱스 찾기
                break;
            }
            idx++;
        }
        road_node[idx].head.disRoute=0;
        //ㅡㅡㅡㅡ중복된 부분 다 0 만들어주기
        int z=0;
        MyLinkedList.Node w=road_node[idx].head.next; //세로
        MyLinkedList.Node j;   //가로
        while(w!=null){
            while(road_node[z]!=null){
                if(road_node[z].head.data.equals(w.data)){
                    j=road_node[z].head.next;
                    while((j!=null)&&(!j.data.equals(road_node[idx].head.data))){
                        j=j.next;
                    }
                    if(j!=null) {
                        j.visited_BFS = 0;
                    }
                    break;  //
                }
                z++;
            }
            w=w.next;
            z=0;
        }
        //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

        Queue.offer(road_node[idx].head);   //시작점 큐에 넣기

        MyLinkedList.Node u=road_node[idx].head;
        MyLinkedList.Node v;
        MyLinkedList.Node Real_v;
        int v_idx=idx;
        Object Q_u; int ch=0;
        while(Queue!=null) {
            Queue.poll();
            Real_v = road_node[v_idx].head.next;
            if(Real_v.equals(input2)){
                break;
            }

            while (Real_v != null) {
                if(ch==0){
                    u = road_node[idx].head;
                    ch=1;
                }

                v_idx = 0;
                while (road_node[v_idx] != null) {
                    if (road_node[v_idx].head.data.equals(Real_v.data)) {    //input_a 위치 인덱스 찾기
                        break;
                    }
                    v_idx++;
                }

                v=road_node[v_idx].head;
                if(v.visited_BFS == -1) {
                    if (v.dist > u.dist) {
                        v.disRoute = u.disRoute + v.dist;
                        //ㅡㅡㅡㅡ 중복된 부분 다 visited + 1 만들어주기 ㅡㅡㅡㅡ
                        z = 0;
                        w = road_node[v_idx].head.next; //세로
                        j = road_node[0].head.next;   //가로
                        while (w != null) {
                            while (road_node[z] != null) {
                                if (road_node[z].head.data.equals(w.data)) {
                                    j = road_node[z].head.next;
                                    while ((j != null) && (!j.data.equals(road_node[v_idx].head.data))) {
                                        j = j.next;
                                    }
                                    if (j != null) {
                                        j.disRoute = u.disRoute + v.dist;
                                    }
                                    break;  //
                                }
                                z++;
                            }
                            w = w.next;
                            z = 0;
                        }
                        //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
                        Queue.offer(v);
                    }
                }
                Real_v = Real_v.next;
            }
            if(Queue.size()==0){
                break;
            }
            Q_u = Queue.element();
            v_idx = 0;
            while (road_node[v_idx] != null) {
                if (road_node[v_idx].head.equals(Q_u)) {    //input_a 위치 인덱스 찾기
                    break;
                }
                v_idx++;
            }
            u = road_node[v_idx].head;
            idx=v_idx;
            System.out.println(area[idx]);
        }

        System.out.println(road_node[idx].head.disRoute);

    }

    //ㅡㅡㅡㅡㅡㅡㅡ tok 나누기 ㅡㅡㅡㅡㅡㅡㅡ
    static String[] A=new String[50000];  //두 지점
    static String[] B=new String[50000];  //두 지점
    static int p=0; //배열 인덱스
    private static void RoadlistTok(String infor) {
        String[] tokarr = infor.split("\t");
        A[p]=tokarr[0];
        B[p]=tokarr[1];
        p++;
    }

    static String[] lon=new String[15000];
    static String[] lat=new String[15000];
    static String[] area=new String[15000];
    static int l=0; //area, lon, lat 배열 인덱스
    private static void AlabamaTok(String infor) {
        String[] tokarr = infor.split("\t");
        area[l]=tokarr[0];
        lon[l]=tokarr[1];
        lat[l]=tokarr[2];
        l++;
    }

    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    //위도 경도 값으로부터 거리 계산해주는 함수
    // 매개변수는 첫번째 지점의 위도(lat1), 경도(lon1), 두번째 지점의 위도(lat2), 경도(lon2) 순서
    public static double calDistance(double lat1, double lon1, double lat2, double lon2)  {
        double theta, dist;
        theta = lon1 - lon2;
        dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1))
                * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;    // 단위 mile 에서 km 변환.
        dist = dist * 1000.0;      // 단위  km 에서 m 로 변환
        return dist;
    }

    // 주어진 도(degree) 값을 라디언으로 변환
    private static double deg2rad(double deg) {
        return (double)(deg * Math.PI / (double)180);
    }

    // 주어진 라디언(radian) 값을 도(degree) 값으로 변환
    private static double rad2deg(double rad) {
        return (double)(rad * (double)180 / Math.PI);
    }
}