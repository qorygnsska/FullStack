package Inheritance;

public class 마법사 {
	String id;
	int hp;
	int mp;
	String attack;
}


class 바드 extends 마법사{
	// 마법사 중에서 회복시켜줌
}

class 서머너 extends 마법사{
	// 마법사 중에서 정령을 가지고 싸우는 캐릭터
	
}

class 아르카나 extends 마법사{
	// 마법사 중에서 카드를 가지고 싸우는 캐릭터
	
}
