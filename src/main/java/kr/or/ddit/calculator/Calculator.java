package kr.or.ddit.calculator;

public class Calculator {
	public static void main(String[] args) {
		int addResult = new Calculator().add(5, 6);

		if(addResult == 11){
			System.out.println("덧셈O");
		}else{
			System.out.println("덧셈X");
		}
		/////////////////////////////////////////////////////

		int minusResult = new Calculator().minus(6, 4);

		if(minusResult == 2){
			System.out.println("뺄셈O");
		}else{
			System.out.println("뺄셈X");
		}
		/////////////////////////////////////////////////////
		int mulResult = new Calculator().mul(3, 5);

		if(mulResult == 15){
			System.out.println("곱셈O");
		}else{
			System.out.println("곱셈X");
		}
		/////////////////////////////////////////////////////
		int divResult = new Calculator().div(10, 5);

		if(divResult == 2){
			System.out.println("나눗셈O");
		}else{
			System.out.println("나눗셈X");
		}

		divResult = new Calculator().div(10, 5);

		if(divResult == 2.0){
			System.out.println("나눗셈O");
		}else{
			System.out.println("나눗셈X");
		}
	}


	/**
	 * Method : add
	 * 최초작성일 : 2018. 7. 6.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param param1
	 * @param param2
	 * @return
	 * Method 설명 : 계산기의 덧셈 기능
	 */
	public int add(int param1, int param2) {
		return param1 + param2;
	}

	/**
	 * Method : minus
	 * 최초작성일 : 2018. 7. 6.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param param1
	 * @param param2
	 * @return
	 * Method 설명 : 계산기의 빼기 기능
	 */
	public int minus(int param1, int param2){
		return param1 - param2;
	}

	/**
	 * Method : mul
	 * 최초작성일 : 2018. 7. 6.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param param1
	 * @param param2
	 * @return
	 * Method 설명 : 계산기의 곱셈 기능
	 */
	public int mul(int param1, int param2){
		return param1 * param2;
	}

	/**
	 * Method : div
	 * 최초작성일 : 2018. 7. 6.
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param param1
	 * @param param2
	 * @return
	 * Method 설명 : 계산기의 나눗셈 기능
	 */
	public int div(int param1, int param2){
		if(param2 == 0){
			return 0;
		}else{
			return param1 / param2;
		}
	}
}
