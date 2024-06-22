package javaxox;


import java.util.Scanner;

public class xox {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String[][] list = new String[3][3];
		
		blanc(list);
		
		int player = 0;
		int p1 = 0;
		int p2 = 0;
		int end = 1;
		
		while (end == 1) {
			int w = 0;
			view(list);
			System.out.println();
			while( w == 0 ) {
				
				int wt = 0;
				if (player == 0 ) {
					
					while (wt == 0) {
						
						
						System.out.println("Birinci konumu giriniz:");
						int x = input.nextInt() - 1;
						System.out.println("İkinci konumu giriniz:");
						int y = input.nextInt() - 1;
						if (list[x][y] != " " ) {
							System.out.println("Aynı yeri bir daha seçemezsin.");
						} else {
							list[x][y] = "X";
							wt = 1;
							}
						
						
					}
					player = 1;
				}
				
				else {
					while (wt == 0) {
						
						
						System.out.println("Birinci konumu giriniz:");
						int x = input.nextInt() - 1;
						System.out.println("İkinci konumu giriniz:");
						int y = input.nextInt() - 1;
						if (list[x][y] != " ") {
							System.out.println("Aynı yeri bir daha seçemezsin.");
						} else {
							list[x][y] = "O";
							wt = 1;
							}
						
						
					}
				player = 0;
				}
				
				if ( (list[0][0] == "X" && list[0][1] == "X" && list[0][2] == "X")
						|| (list[1][0] == "X" && list[1][1] == "X" && list[1][2] == "X")
						|| (list[2][0] == "X" && list[2][1] == "X" && list[2][2] == "X") 
						|| (list[0][0] == "X" && list[1][0] == "X" && list[2][0] == "X")
						|| (list[0][1] == "X" && list[1][1] == "X" && list[2][1] == "X")
						|| (list[0][2] == "X" && list[1][2] == "X" && list[2][2] == "X")
						|| (list[0][0] == "X" && list[1][1] == "X" && list[2][2] == "X")
						|| (list[0][2] == "X" && list[1][1] == "X" && list[2][0] == "X") ) {
					w = 1;
					System.out.println("1. Oyuncu Kazandı!");
					view(list);
					blanc(list);
				}
				else if ((list[0][0] == "O" && list[0][1] == "O" && list[0][2] == "O")
						|| (list[1][0] == "O" && list[1][1] == "O" && list[1][2] == "O")
						|| (list[2][0] == "O" && list[2][1] == "O" && list[2][2] == "O") 
						|| (list[0][0] == "O" && list[1][0] == "O" && list[2][0] == "O")
						|| (list[0][1] == "O" && list[1][1] == "O" && list[2][1] == "O")
						|| (list[0][2] == "O" && list[1][2] == "O" && list[2][2] == "O")
						|| (list[0][0] == "O" && list[1][1] == "O" && list[2][2] == "O")
						|| (list[0][2] == "O" && list[1][1] == "O" && list[2][0] == "O") ) {
					w = 2;
					System.out.println("2. Oyuncu Kazandı!");
					view(list);
					blanc(list);
				}
				else if(check(list) == 0){
					System.out.println("Oyun Berabere!");
					view(list);
					blanc(list);
					w = 3;
				}
				else {
					view(list);
				}
			// Oyun kodu burda bitiyor.	
			}
			
			switch(w) {
				case 1:
					p1++;
					break;
				case 2:
					p2++;
					break;
				case 3:
					break;
			}
			System.out.println("Birinci oyuncu " + p1 + " kez kazandı.");
			System.out.println("İkinci oyuncu " + p2 + " kez kazandı.");
			System.out.println("Oyuna devam etmek istiyorsanız 1 istemiyorsanız 0 yazınız.");
			end = input.nextInt();
			
		}
			
		
	}
	
	public static void view(String VL[][]) {
		int VL1 = 0;
		int VL2 = 0;
		System.out.println("  1 2 3");
		System.out.print("1 ");
		for(int i = 0; i < 9; i++) {
			i++;
			

			if (i%3 == 0) {
				System.out.println(VL[VL1][VL2]);
				if(i/3 == 1) {
					System.out.print("2 ");
				} 
				else if (i/3 == 2) {
					System.out.print("3 ");
				}
			}
			else {
				System.out.print(VL[VL1][VL2] + "|");
			}
			if (VL2 == 2) {
				VL2 = 0;
				VL1++;
			}
			else {
				VL2++;
			}
						
			
			i--;
		}
	}
	
	public static void blanc(String BL[][]) {
		int BL1 = 0;
		int BL2 = 0;
		
		for(int i = 0; i < 9; i++) {
			
			BL[BL1][BL2] = " ";
			if (BL2 == 2) {
				BL2 = 0;
				BL1++;
			}
			else {
				BL2++;
			}
			
		}
	}
		
	public static int check(String CL[][]) {
		int CL1 = 0;
		int CL2 = 0;
		int check = 0;
		for(int i = 0; i < 9; i++) {
			if (CL[CL1][CL2] == " ") {
				check++;
			}
			if (CL2 == 2) {
				CL2 = 0;
				CL1++;
			}
			else {
				CL2++;
			}
		}
		return check;
		
	}
}
