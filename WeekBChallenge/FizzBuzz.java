
public class FizzBuzz {

	public static void fizzBuzz1() {
		for(int i=1;i<101;i++) {
			if((i%15)==0) {
				System.out.println("fizzbuzz");
			}else if((i%3)==0) {
				System.out.println("fizz");
			}else if((i%5)==0) {
				System.out.println("buzz");
			}else
				System.out.println(i);		
		}
	}
	
	public static void fizzBuzz2(int m, int n) {
		if(m<=n) {
			
			for(int i=m;i<n;i++) {
				if((i%15)==0) {
					System.out.println("fizzbuzz");
				}else if((i%3)==0) {
					System.out.println("fizz");
				}else if((i%5)==0) {
					System.out.println("buzz");
				}else
					System.out.println(i);
			}
		}else System.out.println(m+" is greater than "+n);
	}
	
	public static void fizzBuzz3(int m, int n, int fizzNum, int buzzNum) {
		if(m<=n) {
			int fizzBuzz=fizzNum*buzzNum;
			for(int i=m;i<n;i++) {
				if((i%fizzBuzz)==0) {
					System.out.println("fizzbuzz");
				}else if((i%fizzNum)==0) {
					System.out.println("fizz");
				}else if((i%buzzNum)==0) {
					System.out.println("buzz");
				}else
					System.out.println(i);
			}
		}else System.out.println(m+" is greater than "+n);
	}
	
	public static void fizzBuzz4 (int m, int n, int[]numbers, String[]terms) {
		if(m<=n) {
			if(numbers.length==terms.length) {
				for(int i=m;i<n;i++) {
					String by="";
					for(int j=0;j<numbers.length;j++) {
						if((i%numbers[j])==0) {
							by=by+terms[j]+" ";
						}
					}
					if(by=="") {
						System.out.println(i);
					}else
					System.out.println("divisible by: "+by);
				}
			}
		
	}
	
}}
