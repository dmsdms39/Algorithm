// Comparator interface를 이용한 Java 객체 정렬
// main에서 Checker 클래스 형식 사용 -> player를 정렬함
class Checker implements Comparator<Player> {
    // complete this method
  public int compare(Player a, Player b) {

      if(a.score > b.score)
      
          return -1;//큰 숫자를 왼쪽으로 내림차순(less than)
      
      else if(a.score == b.score)
      
          return a.name.compareTo(b.name);//compareTo로 이름 오름차순 정렬(a가 앞이면 negative integer)
      
      else
      
          return 1;//뒤에 숫자가 클때 내림차순으로 변경
          }
}

