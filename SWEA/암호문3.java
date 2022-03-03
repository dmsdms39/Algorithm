import java.util.Scanner;

class Solution4
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        DoubleLink doubleLink = new DoubleLink();

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            sc.nextLine(); //N 안쓰임
            String[] numbers = sc.nextLine().split(" ");

            doubleLink.init();
            doubleLink.insert(0, numbers);

            sc.nextLine(); //M 안쓰임
            String[] commands = sc.nextLine().split(" ");

            int pos = 0;
            while(pos < commands.length){
                String C = commands[pos++];
                int x, y;
                String[] s;

                switch (C){
                    case "I":
                        x = Integer.parseInt(commands[pos++]);
                        y = Integer.parseInt(commands[pos++]);
                        s = new String[y];
                        for(int i = 0; i < y; i++){
                            s[i] = commands[pos++];
                        }
                        doubleLink.insert(x, s);
//                        System.out.println(C +" "+x +" "+y+" "+s[s.length-1]);
                        break;

                    case "D":
                        x = Integer.parseInt(commands[pos++]);
                        y = Integer.parseInt(commands[pos++]);
                        //링크드리스트 delete 함수 수행
//                        System.out.println(C +" "+x +" "+y);
                        doubleLink.delete(x, y);
                        break;

                    case "A":
                        y = Integer.parseInt(commands[pos++]);
                        s = new String[y];
                        for(int i = 0; i < y; i++){
                            s[i] = commands[pos++];
                        }
//                        System.out.println(C+" " +y+" "+s[s.length-1]);
                        doubleLink.append(s);
                       break;
                }
            }
            System.out.printf("#%d ", test_case);
            doubleLink.print10();
        }
    }

    public static class Node{
        public int data;
        public Node next;
        public Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }

    }
    public static class DoubleLink{
        public Node head;
        public Node tail;
        public int nodeCnt;

        public void init(){
            head = new Node(-1);
            tail = new Node(-1);
            head.next = tail;
            tail.prev = head;
            nodeCnt = 0;
        }

        public void addFunction(Node stdNode, String[] nums){
            for(String data: nums) {
                Node newNode = new Node(Integer.parseInt(data));

                nodeCnt++;
                newNode.prev = stdNode;
                newNode.next = stdNode.next;
                stdNode.next.prev = newNode;
                stdNode.next = newNode;

                stdNode = stdNode.next;
            }
        }

        public void insert(int x, String[] nums){
            Node tmp = head;

            for(int i = 0; i < x; i++){
                tmp = tmp.next;
            }
            addFunction(tmp, nums);
        }

        public void delete(int x, int y){
            Node tmp = head;
            Node rmvnext;

            for(int i = 0; i < x; i++){
                tmp = tmp.next;
            }

            rmvnext = tmp;
            for(int j = 0; j < y; j++){
                nodeCnt--;
                rmvnext = rmvnext.next;
            }
            
            tmp.next = rmvnext.next;
            rmvnext.prev = tmp;
        }

        public void append(String[] nums){
            Node tmp = tail.prev;
            addFunction(tmp, nums);
        }

        public void print10(){
            Node tmp = head;

            for(int i = 0; i < 10 ; i++){
                tmp = tmp.next;
                if(tmp == tail){
                    break;
                }
                System.out.print(tmp.data+" ");
            }
            System.out.println("");
        }
    }
}