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
	
	public  String playPoke(String blk,String wht){
//		Scanner scanner = new Scanner(System.in);
//		String input;
//		System.out.println("请输入Black:");
//		input = scanner.nextLine();	
//		System.out.println("请输入White:");	
//		input = scanner.nextLine();
		
		Map<String,String> black= new HashMap<String,String>();
		Map<String,String> white= new HashMap<String,String>();
		
		black.put("Black", blk.substring(6).trim());
		white.put("White", wht.substring(6).trim());
		
		String[] str_b = black.get("Black").split(" ");
		String[] str_w = white.get("White").split(" ");
		
		
		List<String> suit_b = new ArrayList<String>();
		List<Integer> num_b = new ArrayList<Integer>();
		List<String> suit_w = new ArrayList<String>();
		List<Integer> num_w = new ArrayList<Integer>();
		for(int i=0;i<str_b.length;i++){
			if(str_b[i].substring(0, 1).equals("T")){
				num_b.add(10);
			}
			else if(str_b[i].substring(0, 1).equals("J")){
				num_b.add(11);
			}else if(str_b[i].substring(0, 1).equals("Q")){
				num_b.add(12);
			}else if(str_b[i].substring(0, 1).equals("K")){
				num_b.add(13);
			}else if(str_b[i].substring(0, 1).equals("A")){
				num_b.add(14);
			}else{
				num_b.add(Integer.parseInt(str_b[i].substring(0, 1)));
			}
			
			suit_b.add(str_b[i].substring(1));		
		}
		for(int i=0;i<str_w.length;i++){
			if(str_w[i].substring(0, 1).equals("T")){
				num_w.add(10);
			}
			else if(str_w[i].substring(0, 1).equals("J")){
				num_w.add(11);
			}else if(str_w[i].substring(0, 1).equals("Q")){
				num_w.add(12);
			}else if(str_w[i].substring(0, 1).equals("K")){
				num_w.add(13);
			}else if(str_w[i].substring(0, 1).equals("A")){
				num_w.add(14);
			}else{
				num_w.add(Integer.parseInt(str_w[i].substring(0, 1)));
			}
			suit_w.add(str_w[i].substring(1));		
		}
		
		Integer bak_rank = rank(suit_b,num_b);
		Integer whi_rank = rank(suit_w,num_w);
		String bak_str = intoStr(bak_rank);
		String whi_str = intoStr(whi_rank);
		
		Collections.sort(num_b);
		Collections.sort(num_w);
		
		Integer numb = 0;
		Integer numw = 0;
		
		
		Map<Integer,Integer> numb3 = new HashMap<Integer,Integer>();
		Map<Integer,Integer> numw3 = new HashMap<Integer,Integer>();
		numb3 = numCount(num_b);
		numw3 = numCount(num_b);
		Set<Integer> keys = numb3.keySet();
		Set<Integer> keys2 = numw3.keySet();
		Boolean flag = false;
		
		if(bak_rank == whi_rank){
			if(bak_rank == 9 || bak_rank == 5){
				if(num_b.get(num_b.size()-1) > num_w.get(num_w.size()-1)){
					System.out.println("Black wins");
					return "Black wins";
				}else if(num_b.get(num_b.size()-1) < num_w.get(num_w.size()-1)){
					System.out.println("White wins");
					return "White wins";
				}else{
					System.out.println("Tie");
					return "Tie";
				}
			}
			else if(bak_rank == 8){
				
				for(int i=0;i < num_b.size();i++){
					if(num_b.get(i)==num_b.get(i+1))
					{
						numb = num_b.get(i);
						break;
					}						
				}
				for(int j=0;j < num_b.size();j++){
					if(num_w.get(j)==num_w.get(j+1)){
						numw = num_w.get(j);
						break;
					}
				}
				if(numb > numw){
					System.out.println("Black wins");
					return "Black wins";
				}else{
					System.out.println("White wins");
					return "White wins";
				}									
			}
			else if(bak_rank == 7 || bak_rank == 4){
				
				for(Integer in:keys){
					if(numb3.get(in) == 3){
						numb = in;
					}
				}
				
				for(Integer in2:keys2){
					if(numw3.get(in2) == 3){
						numw = in2;
					}
				}
				if(numb > numw){
					System.out.println("Black wins");
					return "Black wins";
				}else{
					System.out.println("White wins");
					return "White wins";
				}				
			}
			else if(bak_rank == 6){
				
				for(int i=num_b.size()-1;i >= 0;i--){
					if(num_b.get(i) > num_w.get(i)){
						System.out.println("Black wins");
						flag = true;
						return "Black wins";
					}else if(num_b.get(i) < num_w.get(i)){
						System.out.println("White wins");
						flag = true;
						return "White wins";
					}					
				}
				if(!flag){
					System.out.println("Tie");
					return "Tie";
				}
				
			}
			else if(bak_rank == 3){
				List<Integer> numb2 = new ArrayList<Integer>();
				Integer numb1=0;
				Integer numw1=0;
				for(Integer k1:keys){
					if(numb3.get(k1) == 2){
						numb2.add(k1);
					}
					if(numb3.get(k1) == 1){
						numb1 = k1;
					}
				}
				List<Integer> numw2 = new ArrayList<Integer>();
				for(Integer k2:keys2){
					if(numw3.get(k2) == 2){
						numw2.add(k2);
					}
					if(numw3.get(k2) == 1){
						numw1 = k2;
					}
					
				}
				Collections.sort(numb2);
				Collections.sort(numw2);
				
				for(int i=num_b.size()-1;i >= 0;i--){
					if(num_b.get(i) > num_w.get(i)){
						System.out.println("Black wins");
						flag = true;
						return "Black wins";
					}else if(num_b.get(i) < num_w.get(i)){
						System.out.println("White wins");
						flag = true;
						return "White wins";
					}					
				}
				if(!flag){
					if(numb1>numw1){
						System.out.println("Black wins");
						return "Black wins";
					}else if(numb1<numw1){
						System.out.println("White wins");
						return "White wins";
					}else{
						System.out.println("Tie");
						return "Tie";
					}
				}			
			}
			else if(bak_rank == 2){
				List<Integer> numb3_2 = new ArrayList<Integer>();
				Integer numb1_2=0;
				Integer numw1_2=0;
				for(Integer k1:keys){
					if(numb3.get(k1) == 1){
						numb3_2.add(k1);
					}
					if(numb3.get(k1) == 2){
						numb1_2 = k1;
					}
				}
				List<Integer> numw3_2 = new ArrayList<Integer>();
				for(Integer k2:keys2){
					if(numw3.get(k2) == 1){
						numw3_2.add(k2);
					}
					if(numw3.get(k2) == 2){
						numw1_2 = k2;
					}
					
				}
				Collections.sort(numb3_2);
				Collections.sort(numw3_2);
			   if(numb1_2>numw1_2){
					System.out.println("Black wins");
					return "Black wins";
				}
			   else if(numb1_2<numw1_2){
					System.out.println("White wins");
					return "White wins";
				}else{

					for(int i=numb3_2.size()-1;i >= 0;i--){
						if(numb3_2.get(i) >numw3_2.get(i)){
							System.out.println("Black wins");
							flag = true;
							return "Black wins";
						}else if(numb3_2.get(i) < numw3_2.get(i)){
							System.out.println("White wins");
							flag = true;
							return "White wins";
						}					
					}
					if(!flag){
						
							System.out.println("Tie");
							return "Tie";
						}
					}
				
			}
			else if(bak_rank == 1){
				for(int i=num_b.size()-1;i >= 0;i--){
					if(num_b.get(i) >num_w.get(i)){
						System.out.println("Black wins");
						flag = true;
						return "Black wins";
					}else if(num_b.get(i) < num_w.get(i)){
						System.out.println("White wins");
						flag = true;
						return "White wins";
					}					
				}
				if(!flag){					
						System.out.println("Tie");
						return "Tie";
					}
		}			
		}else{
			if(bak_rank > whi_rank){
				
				System.out.println("Black wins"); 
				return "Black wins";
				
			}else{
				System.out.println("White wins"); 
				return "White wins";
			}
		}
		return null;
	}
	
	
	
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
