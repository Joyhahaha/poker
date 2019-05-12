import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class PlayPoke {
	
	//定义常量代表9个不同的等级
	public  final Integer TONGHUASHUN = 9;
	public  final Integer TIEZHI = 8;
	public  final Integer HULU = 7;
	public  final Integer TONGHUA = 6;
	public  final Integer SHUNZI = 5;
	public  final Integer SANTIAO = 4;
	public  final Integer LIADUI = 3;
	public  final Integer DUIZI = 2;
	public  final Integer SANPAI = 1;
	

	
	public  String intoStr(Integer rank){
		String rank_str = "";
		switch(rank){
		case 1:
			rank_str = "High Card";
			break;
		case 2:
			rank_str = "Pair";
			break;
		case 3:
			rank_str = "Two Pairs";
			break;
		case 4:
			rank_str = "Three of a Kind";
			break;
		case 5:
			rank_str = "Straight";
			break;
		case 6:
			rank_str = "Flush";
			break;
		case 7:
			rank_str = "Full House";
			break;
		case 8:
			rank_str = "Four of a kind";
			break;
		case 9:
			rank_str = "Straight flush";
			break;
		}
		return rank_str;
	}
	
	//判断花色是否相同
	public  Boolean suitEquals(List<String> suitlist){
		String s = suitlist.get(0);
		for(int i=1;i<suitlist.size();i++){
			if(!s.equalsIgnoreCase(suitlist.get(i))){
				return false;
			}						
		}
		return true;				
	}
	//判断是否顺子
	public  Boolean isConsecutive(List<Integer> numlist){
		Integer min = numlist.get(0);
		for(int i=1;i<numlist.size();i++){
			if(numlist.get(i)<min){
				min = numlist.get(i);
			}			
		}
		
		if(numlist.contains(min+1)&&numlist.contains(min+2)&&
				numlist.contains(min+3)&&numlist.contains(min+4)){
			return true;
		}
		
		return false;
		
	}
	
	//计算各个数字的个数
	public  Map<Integer,Integer> numCount(List<Integer> numlist){
		Map<Integer,Integer> numCount = new HashMap<Integer,Integer>();
		for(int i=0;i<numlist.size();i++){
			Integer num = numlist.get(i);
			if(numCount.containsKey(num)){
				numCount.put(num, numCount.get(num)+1);
			}else{
				numCount.put(num, 1);
			}
		}
		return numCount;	
	}
	
	
	//判断黑白都是什么牌：比如：同花顺、葫芦等；
public  Integer rank(List<String> suit,List<Integer> num){
	if(suitEquals(suit)&&isConsecutive(num)){
		return TONGHUASHUN;
		
	}
	if(isConsecutive(num)){
		return SHUNZI;
	}
	if(suitEquals(suit)){
		return TONGHUA;
	}
	Map<Integer,Integer> numCount = new HashMap<Integer,Integer>();
	numCount = numCount(num);	
	int size = numCount.values().size();

	if(size == 4){
		return DUIZI;
	}else if(size == 3){
		if(numCount.values().contains(3)){
			return SANTIAO;
		}else{
			return LIADUI;
		}
	}else if(size == 2){
		if(numCount.values().contains(4)){
			return TIEZHI;
		}else{
			return HULU;
		}
	}else{
		return SANPAI;			
	}
}
	

	

	

}
