package CompetitionProgramming;

import java.io.*;
import java.util.*;

@SuppressWarnings("resource")
public class UVA408 {

	static int dr[] = {1, 0, -1, 0, 1, -1, -1, 1};
	static int dc[] = {0, 1, 0, -1, 1, -1, 1, -1};
	static char[][] grid = new char[99][99];
	static boolean[][] visited = new boolean[99][99];
	
	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner s = new Scanner(new File("CompetitionProgramming/UVA408.input"));
		int cases = s.nextInt();
		s.nextLine(); s.nextLine();

		for (int k = 0; k < cases; k++){
			int index = 0;
			while(s.hasNextLine()){
				String str = s.nextLine();
				if(str.trim().length() == 0) break;
				grid[index] = str.toCharArray();
				for(int i = 0; i < 99; i++) visited[index][i] = false;
				index++;
			}
			while(s.hasNextLine()){
				int r = s.nextInt();
				int c = s.nextInt();
				System.out.println(floodfill(r-1, c-1, 'W', 'L'));
			}
		}

	}
	
	public static int floodfill(int r, int c, char c1, char c2){
		if(r<0 || r >= grid.length || c < 0 || c >= grid[0].length)return 0; 
		if(grid[r][c] != c1)return 0; 
		if(visited[r][c]) return 0;
		int ans = 1;
		visited[r][c] = true;
		for(int d = 0; d < 8; d++) ans += floodfill(r +dr[d], c + dc[d], c1, c2);
		return ans;
	}
	
}