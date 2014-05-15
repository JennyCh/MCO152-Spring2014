package charnetskaya.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UniqueNumbers {

	public static void main (String [] args){
		Scanner in = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		Set <Integer> set = new HashSet<Integer>();
		Map <Integer, Integer> map = new HashMap <Integer, Integer>();
		
		for(int i = 0; i < 10; i++){
			int number = in.nextInt();
		if(!map.containsKey(number)){
			map.put(number, 1);
		}else{
			int val = map.get(number);
			map.put(number, ++val);
		}
		}
		
		
	//	for(int i = 0; i < 10; i++ ){
			//int num = in.nextInt();
		//	set.add(in.nextInt());
			//if(!list.contains(num)){
			//	list.add(num);
			//}
		//}
		
		
		
	//	System.out.println(list);
		System.out.println(map);
	}
}
