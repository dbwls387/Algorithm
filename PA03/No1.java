package PA03;
        import java.util.Random;
        import java.util.Arrays;

public class No1 {
    public static void main(String[] args) {
        int N1 = 1000, N2 = 10000, N3 = 100000;
        int[] arr1_ran = new int[N1];   //Random1,000
        int[] arr2_ran = new int[N2];   //Random10,000
        int[] arr3_ran = new int[N3];   //Random100,000

        int[] arr1_Rev = new int[N1];   //Reverse1,000
        int[] arr2_Rev = new int[N2];   //Reverse10,000
        int[] arr3_Rev = new int[N3];   //Reverse100,000

        //거꾸로 정렬 설정하기
        for (int i = 0; i < N1; i++) {
            arr1_Rev[i]=N1-i;
        }
        for (int i = 0; i < N2; i++) {
            arr2_Rev[i]=N2-i;
        }
        for (int i = 0; i < N3; i++) {
            arr3_Rev[i]=N3-i;
        }

        //테이블 출력
        System.out.println("\t\tRandom1000\tReverse1000\tRandom10000\tReverse10000\tRandom100000\tReverse100000 ");
        long beTime,aftTime;
        double sec=0.0,average=0.0;
        Random random = new Random();

        //(1)버블정렬
        System.out.print("Bubble\t\t");
        for(int j=0;j<10;j++) {     //버블 랜덤1000
            for (int i = 0; i < N1; i++) {
                arr1_ran[i] = random.nextInt(N1) + 1;
            }
            beTime = System.currentTimeMillis();
            BubbleSort(N1, arr1_ran);
            aftTime = System.currentTimeMillis();
            sec = (aftTime - beTime) / 1000.0;
            average += sec;
        }
        average/=10.0;
        System.out.printf("%.3f \t\t",average);
        average=0;

        beTime=System.currentTimeMillis();
        BubbleSort(N1,arr1_Rev);        //버블 거꾸로1000
        aftTime=System.currentTimeMillis();
        sec=(aftTime-beTime)/1000.0;
        System.out.printf("%.3f \t\t",sec);

        for(int j=0;j<10;j++) {//버블 랜덤10000
            for (int i = 0; i < N2; i++) {
                arr2_ran[i]=random.nextInt(N2)+1;
            }
            beTime = System.currentTimeMillis();
            BubbleSort(N2, arr2_ran);
            aftTime = System.currentTimeMillis();
            sec = (aftTime - beTime) / 1000.0;
            average+=sec;
        }
        average/=10.0;
        System.out.printf("%.3f \t\t",average);
        average=0;

        beTime=System.currentTimeMillis();//버블 거꾸로10000
        BubbleSort(N2,arr2_Rev);
        aftTime=System.currentTimeMillis();
        sec=(aftTime-beTime)/1000.0;
        System.out.printf("%.3f \t\t",sec);

        for(int j=0;j<10;j++) {
            for (int i = 0; i < N3; i++) {
                arr3_ran[i]=random.nextInt(N3)+1;
            }
            beTime = System.currentTimeMillis();
            BubbleSort(N3, arr3_ran);       //버블 랜덤100000
            aftTime = System.currentTimeMillis();
            sec = (aftTime - beTime) / 1000.0;
            average+=sec;
        }
        average/=10.0;
        System.out.printf("%.3f \t\t",average);
        average=0;

        beTime=System.currentTimeMillis();
        BubbleSort(N3,arr3_Rev);        //버블 거꾸로10000
        aftTime=System.currentTimeMillis();
        sec=(aftTime-beTime)/1000.0;
        System.out.printf("%.3f \n",sec);

        //(2)선택정렬
        System.out.print("Selection\t");
        for(int j=0;j<10;j++) {//선택 랜덤1000
            for (int i = 0; i < N1; i++) {
                arr1_ran[i]=random.nextInt(N1)+1;
            }
            beTime = System.currentTimeMillis();
            SelectionSort(N1, arr1_ran);
            aftTime = System.currentTimeMillis();
            sec = (aftTime - beTime) / 1000.0;
            average+=sec;
        }
        average/=10.0;
        System.out.printf("%.3f \t\t",average);
        average=0;

        beTime=System.currentTimeMillis(); //선택 거꾸로1000
        SelectionSort(N1,arr1_Rev);
        aftTime=System.currentTimeMillis();
        sec=(aftTime-beTime)/1000.0;
        System.out.printf("%.3f \t\t",sec);

        for(int j=0;j<10;j++) { //선택 랜덤10000
            for (int i = 0; i < N2; i++) {
                arr2_ran[i]=random.nextInt(N2)+1;
            }
            beTime = System.currentTimeMillis();
            SelectionSort(N2, arr2_ran);
            aftTime = System.currentTimeMillis();
            sec = (aftTime - beTime) / 1000.0;
            average+=sec;
        }
        average/=10.0;
        System.out.printf("%.3f \t\t",average);
        average=0;

        beTime=System.currentTimeMillis();
        SelectionSort(N2,arr2_Rev);        //선택 거꾸로10000
        aftTime=System.currentTimeMillis();
        sec=(aftTime-beTime)/1000.0;
        System.out.printf("%.3f \t\t",sec);

        for(int j=0;j<10;j++) {
            for (int i = 0; i < N3; i++) {
                arr3_ran[i]=random.nextInt(N3)+1;
            }
            beTime = System.currentTimeMillis();
            SelectionSort(N3, arr3_ran);       //선택 랜덤100000
            aftTime = System.currentTimeMillis();
            sec = (aftTime - beTime) / 1000.0;
            average+=sec;
        }
        average/=10.0;
        System.out.printf("%.3f \t\t",average);
        average=0;

        beTime=System.currentTimeMillis();
        SelectionSort(N3,arr3_Rev);        //선택 거꾸로100000
        aftTime=System.currentTimeMillis();
        sec=(aftTime-beTime)/1000.0;
        System.out.printf("%.3f \n",sec);

        //(3)삽입정렬
        System.out.print("Insertion\t");
        for(int j=0;j<10;j++) {
            for (int i = 0; i < N1; i++) {
                arr1_ran[i]=random.nextInt(N1)+1;
            }
            beTime = System.currentTimeMillis();
            InsertionSort(N1, arr1_ran);       //삽입 랜덤1000
            aftTime = System.currentTimeMillis();
            sec = (aftTime - beTime) / 1000.0;
            average+=sec;
        }
        average/=10.0;
        System.out.printf("%.3f \t\t",average);
        average=0;

        beTime=System.currentTimeMillis();
        InsertionSort(N1,arr1_Rev);        //삽입 거꾸로1000
        aftTime=System.currentTimeMillis();
        sec=(aftTime-beTime)/1000.0;
        System.out.printf("%.3f \t\t",sec);

        for(int j=0;j<10;j++) { //삽입 랜덤10000
            for (int i = 0; i < N2; i++) {
                arr2_ran[i]=random.nextInt(N2)+1;
            }
            beTime = System.currentTimeMillis();
            InsertionSort(N2, arr2_ran);
            aftTime = System.currentTimeMillis();
            sec = (aftTime - beTime) / 1000.0;
            average+=sec;
        }
        average/=10.0;
        System.out.printf("%.3f \t\t",average);
        average=0;

        beTime=System.currentTimeMillis();
        InsertionSort(N2,arr2_Rev);        //삽입 거꾸로10000
        aftTime=System.currentTimeMillis();
        sec=(aftTime-beTime)/1000.0;
        System.out.printf("%.3f \t\t",sec);

        for(int j=0;j<10;j++) {     //삽입 랜덤10000
            for (int i = 0; i < N3; i++) {
                arr3_ran[i]=random.nextInt(N3)+1;
            }
            beTime = System.currentTimeMillis();
            InsertionSort(N3, arr3_ran);
            aftTime = System.currentTimeMillis();
            sec = (aftTime - beTime) / 1000.0;
            average+=sec;
        }
        average/=10.0;
        System.out.printf("%.3f \t\t",average);
        average=0;

        beTime=System.currentTimeMillis();  //삽입 거꾸로10000
        InsertionSort(N3,arr3_Rev);
        aftTime=System.currentTimeMillis();
        sec=(aftTime-beTime)/1000.0;
        System.out.printf("%.3f \n",sec);

        //(4)합병정렬
        System.out.print("Merge\t\t");
        for(int j=0;j<10;j++) {         //합병 랜덤1000
            for (int i = 0; i < N1; i++) {
                arr1_ran[i]=random.nextInt(N1)+1;
            }
            beTime = System.currentTimeMillis();
            MergeSort(N1, arr1_ran, 0, N1 - 1);
            aftTime = System.currentTimeMillis();
            sec = (aftTime - beTime) / 1000.0;
            average+=sec;
        }
        average/=10.0;
        System.out.printf("%.3f \t\t",average);
        average=0;

        beTime=System.currentTimeMillis();      //합병 거꾸로1000
        MergeSort(N1, arr1_Rev, 0, N1 - 1);
        aftTime=System.currentTimeMillis();
        sec=(aftTime-beTime)/1000.0;
        System.out.printf("%.3f \t\t",sec);

        for(int j=0;j<10;j++) {             //합병 랜덤10000
            for (int i = 0; i < N2; i++) {
                arr2_ran[i]=random.nextInt(N2)+1;
            }
            beTime = System.currentTimeMillis();
            MergeSort(N2, arr2_ran, 0, N2 - 1);
            aftTime = System.currentTimeMillis();
            sec = (aftTime - beTime) / 1000.0;
            average+=sec;
        }
        average/=10.0;
        System.out.printf("%.3f \t\t",average);
        average=0;

        beTime=System.currentTimeMillis();      //합병 거꾸로10000
        MergeSort(N2, arr2_Rev, 0, N2 - 1);
        aftTime=System.currentTimeMillis();
        sec=(aftTime-beTime)/1000.0;
        System.out.printf("%.3f \t\t",sec);

        for(int j=0;j<10;j++) {             //합병 랜덤100000
            for (int i = 0; i < N3; i++) {
                arr3_ran[i]=random.nextInt(N3)+1;
            }
            beTime = System.currentTimeMillis();
            MergeSort(N3, arr3_ran, 0, N3 - 1);
            aftTime = System.currentTimeMillis();
            sec = (aftTime - beTime) / 1000.0;
            average+=sec;
        }
        average/=10.0;
        System.out.printf("%.3f \t\t",average);
        average=0;

        beTime=System.currentTimeMillis();      //합병 거꾸로100000
        MergeSort(N3, arr3_Rev, 0, N3 - 1);
        aftTime=System.currentTimeMillis();
        sec=(aftTime-beTime)/1000.0;
        System.out.printf("%.3f \n",sec);

        //(5)빠른정렬1 - 마지막 값을 피봇으로 선택
        System.out.print("Quick1\t\t");
        for(int j=0;j<10;j++) {         //빠른1 랜덤1000
            for (int i = 0; i < N1; i++) {
                arr1_ran[i]=random.nextInt(N1)+1;
            }
            beTime = System.currentTimeMillis();
            QuikSort_lastP(N1, arr1_ran, 0, N1 - 1);
            aftTime = System.currentTimeMillis();
            sec = (aftTime - beTime) / 1000.0;
            average+=sec;
        }
        average/=10.0;
        System.out.printf("%.3f \t\t",average);
        average=0;

        beTime=System.currentTimeMillis();      //빠른1 거꾸로1000
        QuikSort_lastP(N1, arr1_Rev, 0, N1 - 1);
        aftTime=System.currentTimeMillis();
        sec=(aftTime-beTime)/1000.0;
        System.out.printf("%.3f \t\t",sec);

        for(int j=0;j<10;j++) {         //빠른1 랜덤10000
            for (int i = 0; i < N2; i++) {
                arr2_ran[i]=random.nextInt(N2)+1;
            }
            beTime = System.currentTimeMillis();
            QuikSort_lastP(N2, arr2_ran, 0, N2 - 1);
            aftTime = System.currentTimeMillis();
            sec = (aftTime - beTime) / 1000.0;
            average+=sec;
        }
        average/=10.0;
        System.out.printf("%.3f \t\t",average);
        average=0;

        beTime=System.currentTimeMillis();      //빠른1 거꾸로10000
        QuikSort_lastP(N2, arr2_Rev, 0, N2 - 1);
        aftTime=System.currentTimeMillis();
        sec=(aftTime-beTime)/1000.0;
        System.out.printf("%.3f \t\t",sec);

        for(int j=0;j<10;j++) {         //빠른1 랜덤100000
            for (int i = 0; i < N3; i++) {
                arr3_ran[i]=random.nextInt(N3)+1;
            }
            beTime = System.currentTimeMillis();
            QuikSort_lastP(N3, arr3_ran, 0, N3 - 1);
            aftTime = System.currentTimeMillis();
            sec = (aftTime - beTime) / 1000.0;
            average+=sec;
        }
        average/=10.0;
        System.out.printf("%.3f \t\t",average);
        average=0;

        /*  //스택 오버플로우
        beTime=System.currentTimeMillis();      //빠른1 거꾸로100000
        QuikSort_lastP(N3, arr3_Rev, 0, N3 - 1);
        aftTime=System.currentTimeMillis();
        sec=(aftTime-beTime)/1000.0;
        System.out.printf("%.3f \n",sec);
        */
        System.out.println("StackOverflow");

        //(6)빠른정렬2 - 중간 값을 피봇으로 선택
        System.out.print("Quick2\t\t");
        for(int j=0;j<10;j++) {         //빠른2 랜덤1000
            for (int i = 0; i < N1; i++) {
                arr1_ran[i]=random.nextInt(N1)+1;
            }
            beTime = System.currentTimeMillis();
            QuikSort_medianP(N1, arr1_ran, 0, N1 - 1);
            aftTime = System.currentTimeMillis();
            sec = (aftTime - beTime) / 1000.0;
            average+=sec;
        }
        average/=10.0;
        System.out.printf("%.3f \t\t",average);
        average=0;

        beTime=System.currentTimeMillis();      //빠른2 거꾸로1000
        QuikSort_medianP(N1, arr1_Rev, 0, N1 - 1);
        aftTime=System.currentTimeMillis();
        sec=(aftTime-beTime)/1000.0;
        System.out.printf("%.3f \t\t",sec);

        for(int j=0;j<10;j++) {         //빠른2 랜덤10000
            for (int i = 0; i < N2; i++) {
                arr2_ran[i]=random.nextInt(N2)+1;
            }
            beTime = System.currentTimeMillis();
            QuikSort_medianP(N2, arr2_ran, 0, N2 - 1);
            aftTime = System.currentTimeMillis();
            sec = (aftTime - beTime) / 1000.0;
            average+=sec;
        }
        average/=10.0;
        System.out.printf("%.3f \t\t",average);
        average=0;

        beTime=System.currentTimeMillis();      //빠른2 거꾸로10000
        QuikSort_medianP(N2, arr2_Rev, 0, N2 - 1);
        aftTime=System.currentTimeMillis();
        sec=(aftTime-beTime)/1000.0;
        System.out.printf("%.3f \t\t",sec);

        for(int j=0;j<10;j++) {         //빠른2 랜덤100000
            for (int i = 0; i < N3; i++) {
                arr3_ran[i]=random.nextInt(N3)+1;
            }
            beTime = System.currentTimeMillis();
            QuikSort_medianP(N3, arr3_ran, 0, N3 - 1);
            aftTime = System.currentTimeMillis();
            sec = (aftTime - beTime) / 1000.0;
            average+=sec;
        }
        average/=10.0;
        System.out.printf("%.3f \t\t",average);
        average=0;

        /*
        beTime=System.currentTimeMillis();      //빠른2 거꾸로100000
        QuikSort_medianP(N3, arr3_Rev, 0, N3 - 1);
        aftTime=System.currentTimeMillis();
        sec=(aftTime-beTime)/1000.0;
        System.out.printf("%.3f \n",sec);
        */
        System.out.println("StackOverflow");

        //(7)빠른정렬3 - 랜덤 값을 피봇으로 선택
        System.out.print("Quick3\t\t");
        for(int j=0;j<10;j++) {         //빠른3 랜덤1000
            for (int i = 0; i < N1; i++) {
                arr1_ran[i]=random.nextInt(N1)+1;
            }
            beTime = System.currentTimeMillis();
            QuikSort_randP(N1, arr1_ran, 0, N1 - 1);
            aftTime = System.currentTimeMillis();
            sec = (aftTime - beTime) / 1000.0;
            average+=sec;
        }
        average/=10.0;
        System.out.printf("%.3f \t\t",average);
        average=0;

        beTime=System.currentTimeMillis();      //빠른3 거꾸로1000
        QuikSort_randP(N1, arr1_Rev, 0, N1 - 1);
        aftTime=System.currentTimeMillis();
        sec=(aftTime-beTime)/1000.0;
        System.out.printf("%.3f \t\t",sec);

        for(int j=0;j<10;j++) {         //빠른3 랜덤10000
            for (int i = 0; i < N2; i++) {
                arr2_ran[i]=random.nextInt(N2)+1;
            }
            beTime = System.currentTimeMillis();
            QuikSort_randP(N2, arr2_ran, 0, N2 - 1);
            aftTime = System.currentTimeMillis();
            sec = (aftTime - beTime) / 1000.0;
            average+=sec;
        }
        average/=10.0;
        System.out.printf("%.3f \t\t",average);
        average=0;

        beTime=System.currentTimeMillis();      //빠른3 거꾸로10000
        QuikSort_randP(N2, arr2_Rev, 0, N2 - 1);
        aftTime=System.currentTimeMillis();
        sec=(aftTime-beTime)/1000.0;
        System.out.printf("%.3f \t\t",sec);

        for(int j=0;j<10;j++) {         //빠른3 랜덤100000
            for (int i = 0; i < N3; i++) {
                arr3_ran[i]=random.nextInt(N3)+1;
            }
            beTime = System.currentTimeMillis();
            QuikSort_randP(N3, arr3_ran, 0, N3 - 1);
            aftTime = System.currentTimeMillis();
            sec = (aftTime - beTime) / 1000.0;
            average+=sec;
        }
        average/=10.0;
        System.out.printf("%.3f \t\t",average);
        average=0;

        /*
        beTime=System.currentTimeMillis();      //빠른3 거꾸로100000
        QuikSort_randP(N3, arr3_Rev, 0, N3 - 1);
        aftTime=System.currentTimeMillis();
        sec=(aftTime-beTime)/1000.0;
        System.out.printf("%.3f \n",sec);
        */
        System.out.println("StackOverflow");

        //(8)힙정렬
        System.out.print("Heap\t\t");
        for(int j=0;j<10;j++) {         //힙 랜덤1000
            for (int i = 0; i < N1; i++) {
                arr1_ran[i]=random.nextInt(N1)+1;
            }
            beTime = System.currentTimeMillis();
            HeapSort(N1, arr1_ran);
            aftTime = System.currentTimeMillis();
            sec = (aftTime - beTime) / 1000.0;
            average+=sec;
        }
        average/=10.0;
        System.out.printf("%.3f \t\t",average);
        average=0;

        beTime=System.currentTimeMillis();      //힙 거꾸로1000
        HeapSort(N1, arr1_Rev);
        aftTime=System.currentTimeMillis();
        sec=(aftTime-beTime)/1000.0;
        System.out.printf("%.3f \t\t",sec);

        for(int j=0;j<10;j++) {         //힙 랜덤10000
            for (int i = 0; i < N2; i++) {
                arr2_ran[i]=random.nextInt(N2)+1;
            }
            beTime = System.currentTimeMillis();
            HeapSort(N2, arr2_ran);
            aftTime = System.currentTimeMillis();
            sec = (aftTime - beTime) / 1000.0;
            average+=sec;
        }
        average/=10.0;
        System.out.printf("%.3f \t\t",average);
        average=0;

        beTime=System.currentTimeMillis();      //힙 거꾸로10000
        HeapSort(N2, arr2_Rev);
        aftTime=System.currentTimeMillis();
        sec=(aftTime-beTime)/1000.0;
        System.out.printf("%.3f \t\t",sec);

        for(int j=0;j<10;j++) {         //힙 랜덤100000
            for (int i = 0; i < N3; i++) {
                arr3_ran[i]=random.nextInt(N3)+1;
            }
            beTime = System.currentTimeMillis();
            HeapSort(N3, arr3_ran);
            aftTime = System.currentTimeMillis();
            sec = (aftTime - beTime) / 1000.0;
            average+=sec;
        }
        average/=10.0;
        System.out.printf("%.3f \t\t",average);
        average=0;

        beTime=System.currentTimeMillis();      //힙 거꾸로100000
        HeapSort(N3, arr3_Rev);
        aftTime=System.currentTimeMillis();
        sec=(aftTime-beTime)/1000.0;
        System.out.printf("%.3f \n",sec);

        //(9)표준 라이브러리가 제공하는 정렬 알고리즘
        System.out.print("Library\t\t");
        for(int j=0;j<10;j++) {         //라이브러리 랜덤1000
            for (int i = 0; i < N1; i++) {
                arr1_ran[i]=random.nextInt(N1)+1;
            }
            beTime = System.currentTimeMillis();
            Arrays.sort(arr1_ran);
            aftTime = System.currentTimeMillis();
            sec = (aftTime - beTime) / 1000.0;
            average+=sec;
        }
        average/=10.0;
        System.out.printf("%.3f \t\t",average);
        average=0;

        beTime=System.currentTimeMillis();      //라이브러리 거꾸로1000
        Arrays.sort(arr1_Rev);
        aftTime=System.currentTimeMillis();
        sec=(aftTime-beTime)/1000.0;
        System.out.printf("%.3f \t\t",sec);

        for(int j=0;j<10;j++) {         //라이브러리 랜덤10000
            for (int i = 0; i < N2; i++) {
                arr2_ran[i]=random.nextInt(N2)+1;
            }
            beTime = System.currentTimeMillis();
            Arrays.sort(arr2_ran);
            aftTime = System.currentTimeMillis();
            sec = (aftTime - beTime) / 1000.0;
            average+=sec;
        }
        average/=10.0;
        System.out.printf("%.3f \t\t",average);
        average=0;

        beTime=System.currentTimeMillis();      //라이브러리 거꾸로10000
        Arrays.sort(arr2_Rev);
        aftTime=System.currentTimeMillis();
        sec=(aftTime-beTime)/1000.0;
        System.out.printf("%.3f \t\t",sec);
        //
        for(int j=0;j<10;j++) {         //라이브러리 랜덤100000
            for (int i = 0; i < N3; i++) {
                arr3_ran[i]=random.nextInt(N3)+1;
            }
            beTime = System.currentTimeMillis();
            Arrays.sort(arr3_ran);
            aftTime = System.currentTimeMillis();
            sec = (aftTime - beTime) / 1000.0;
            average+=sec;
        }
        average/=10.0;
        System.out.printf("%.3f \t\t",average);
        average=0;

        beTime=System.currentTimeMillis();      //라이브러리 거꾸로100000
        Arrays.sort(arr3_Rev);
        aftTime=System.currentTimeMillis();
        sec=(aftTime-beTime)/1000.0;
        System.out.printf("%.3f \n",sec);
    }

    private static void BubbleSort(int N, int[] arr) {   //버블정렬
        int tmp;
        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    private static void SelectionSort(int N, int[] arr) {  //선택정렬
        int K;
        int max;
        for (int i = 0; i < N - 1; i++) {
            max = i;
            for (int j = i + 1; j < N; j++) {
                if (arr[max] > arr[j]) {
                    max = j;
                }
            }
            K = arr[max];
            arr[max] = arr[i];
            arr[i] = K;
        }
    }

    private static void InsertionSort(int N, int[] arr) {   //삽입정렬
        int tmp;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    private static void MergeSort(int N, int[] arr, int p, int r) {        //합병정렬
        if (p < r) {
            int q = (p + r) / 2;             //p,q의 중간 지점 계산
            MergeSort(N, arr, p, q);         //전반부 정렬
            MergeSort(N, arr, q + 1, r);  //후반부 정렬
            Merge(N, arr, p, q, r);          //합병
        }
    }

    private static void Merge(int N, int[] arr, int p, int q, int r) {      //합병
        //정렬되어 있는 두 배열 A[p...q]와 A[q+1...r]을 합하여
        //정렬된 하나의 배열 A[p...r]을 만든다.
        int i = p;
        int j = q + 1;
        int k = p;
        int tmp[] = new int[N];
        while (i <= q && j <= r) {
            if (arr[i] < arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        while (i <= q) {
            tmp[k++] = arr[i++];
        }
        while (j <= r) {
            tmp[k++] = arr[j++];
        }
        for (int a = p; a <= r; a++) {
            arr[a] = tmp[a];
        }
    }

    private static void QuikSort_lastP(int N, int[] arr, int p, int r) {     //빠른정렬 - 마지막 값을 피봇으로 선택
        if (p < r) {
            int q = Partition(N, arr, p, r);        //분할
            QuikSort_lastP(N, arr, p, q - 1);     //왼쪽 배열 정렬
            QuikSort_lastP(N, arr, q + 1, r);     //오른쪽 배열 정렬
        }
    }

    private static void QuikSort_medianP(int N, int[] arr, int p, int r) { //빠른정렬 - 중간값을 피봇으로 선택
        int mid = (N - 1) / 2;
        int[] mid_piv = new int[3];
        int[] mid_idx = new int[3];
        mid_piv[0] = arr[0];
        mid_piv[1] = arr[mid];
        mid_piv[2] = arr[N - 1];
        mid_idx[0] = 0;
        mid_idx[1] = mid;
        mid_idx[2] = N - 1;
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (mid_piv[i] > mid_piv[j]) {
                    swap(mid_idx, i, j);
                }
            }
        }
        int m = mid_piv[1];
        swap(arr, m, r);

        if (p < r) {
            int q = Partition(N, arr, p, r);
            QuikSort_lastP(N, arr, p, q - 1);
            QuikSort_lastP(N, arr, q + 1, r);
        }
    }

    private static void QuikSort_randP(int N, int[] arr, int p, int r) {    //빠른정렬 - 랜덤 피봇
        Random random = new Random();
        int rand = random.nextInt(N);
        swap(arr, rand, r);

        if (p < r) {
            int q = Partition(N, arr, p, r);
            QuikSort_lastP(N, arr, p, q - 1);
            QuikSort_lastP(N, arr, q + 1, r);
        }
    }

    private static int Partition(int N, int[] arr, int p, int r) {
        //배열 A[p...r]의 원소들을 A[r]을 기준으로 양쪽으로 재배치하고
        //A[r]이 자리한 위치를 리턴한다.
        int x, i;
        x = arr[r];
        i = p - 1;
        for (int j = p; j < r; j++) {
            if (arr[j] <= x) {
                i = i + 1;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, r);

        return i + 1;
    }

    private static void HeapSort(int N, int[] arr) { //힙정렬
        BuildMaxHeap(N, arr);
        int heapsize = arr.length - 1;
        for (int i = heapsize; i >= 0; i--) {
            swap(arr, 0, i);
            MaxHeapify(heapsize, arr, 0);
            heapsize--;
        }
    }

    private static void MaxHeapify(int N, int[] arr, int i) { //힙 - 순환버전
        int k = 0, heapsize = N;
        int left = (i * 2) + 1;
        int right = (i * 2) + 2;

        if (left > heapsize || right > heapsize) {    //자식이 없을 경우 종료
            return;
        }

        if (right > N - 1) {
            k = left;
        } else {
            if (arr[left] > arr[right]) {
                k = left;
            } else {
                k = right;
            }
        }
        if (arr[i] >= arr[k]) {
            return;
        }

        swap(arr, i, k);
        MaxHeapify(N, arr, k);
    }

    private static void BuildMaxHeap(int N, int[] arr) {
        int heapsize = N;
        for (int i = (heapsize / 2) - 1; i >= 0; i--) {
            MaxHeapify(N, arr, i);
        }
    }

    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}