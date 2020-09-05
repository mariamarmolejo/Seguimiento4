package s4;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt( br.readLine());
		double[][] nums = new double[n][];
		
		//fill the matrix rows 
		for (int i = 0; i<n; i++) {
			String line = br.readLine();
			String[] numsLine = line.split(" ");
			nums[i]= new double[numsLine.length];
			for(int j =0;j<numsLine.length;j++) {
				nums[i][j] = Double.parseDouble(numsLine[j]);
			}
		}
		
		double[] exchanges = new double[n];
		double[] pass = new double[n];
		
		//Sorting the matrix rows 
		for(int i = 0;i<n;i++) {
			for(int j = nums[i].length-1; j>0; j--) {
				for(int g = 0;g<nums[i].length-1;g++) {
					double temp = nums[i][g];
					if(nums[i][g+1]<temp) {
						nums[i][g]=nums[i][g+1];
						nums[i][g+1]=temp;
						exchanges[i] ++;
					}
				}
				if(exchanges[i]>0) {
					pass[i]++;
				}
				
			}
			
		}
		
		//calculate average exchanges
		double[] average = new double[n];
		for(int i = 0;i<n;i++) {
			average[i]=exchanges[i]/pass[i];
		}
		
		String numList = "";
		
		for(int i = 0;i<n;i++) {
			numList += String.format("%.2f",average[i]) + "-";
			
			for(int j=0;j<nums[i].length-1;j++) {
				numList += nums[i][j] + " ";
			}
			int last = nums[i].length - 1;
			numList += "" + nums[i][last] + "\n";
		}
		
		bw.write(numList);
		br.close();
		bw.close();
		
	}

}
