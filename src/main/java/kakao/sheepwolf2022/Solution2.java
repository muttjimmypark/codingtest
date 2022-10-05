package kakao.sheepwolf2022;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    //dfs에 대해 검색해본 다른사람 풀이

    int[] ginfo;
    //Map하고 비교해서 뭐가 나을까 직접짤때 해보자
    List<Integer>[] list;
    int answer = 0;

    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        ginfo = info;
        list = new ArrayList[n];

        //list[부모노드] = {}
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<Integer>();
        }

        //edges로 받은 관계들을 정렬
        //부모노드 리스트를 찾아서 거기에 자식노드 이름들을 추가한다
        //list[부모노드] = {자식1, 자식2}
        for (int i[] : edges) {
            list[i[0]].add(i[1]);
        }

        dfs(0, 0, 0, new LinkedList<Integer>());
        return answer;
    }

    public void dfs(int node, int sheep, int wolf, LinkedList<Integer> waitingQue) {
        //info를 전역변수로 뺐을뿐, 그대로 살려서 필요시 읽어보는구나
        //지금 바라보는 node의 양/늑 여부를 판단
        if (ginfo[node] == 0) {
            sheep++;
        } else {
            wolf++;

            //양이 늘었으면 양>늑 재귀조건이 깨지지 않을것이므로 하위노드로 더 깊이 들어가야함
            //늑대가 늘었으니, 양<=늑인지 확인
            //지금 바라보는 node에서는 이게 최선이라 도출하고 return
            if (sheep <= wolf) {
                return;
            }
        }

        //지금 바라보는 node의 자식이름들을 myQue에 담는다
        //내 부모의 다른자식 다음으로 내자식을 넣는다
        LinkedList<Integer> myQue = (LinkedList<Integer>) waitingQue.clone();
        for (int i : list[node]) {
            myQue.add(i);
        }

        //이 node의 자식이 없으면 여기서 결론을 낸다
        if (myQue.isEmpty()) {
            answer = Math.max(sheep, answer);
            return;
        }
        System.out.println("no breaking : add more nodes");
        System.out.println("myQue = " + myQue);

        int size = myQue.size();
        while (size-- > 0) {
            //linkedlist의 첫항목을 : peek() 읽어보기, poll() 잡아빼기
            int next = myQue.poll();

            //하위 노드를 탐색
            dfs(next, sheep, wolf, myQue);

            //이건 왜있지
            //맨앞을 빼서 dfs하고 맨뒤로 넣는데
            //이미 while은 size가 소진되면 끝나잖아
            myQue.add(next);
        }

    }
}
