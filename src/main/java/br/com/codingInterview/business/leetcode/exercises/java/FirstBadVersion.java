/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

/**
 * @author Evaristo
 *
 */
public class FirstBadVersion {

	/**
	 * 278. First Bad Version
	 */
	public FirstBadVersion() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version. 
	 */
	public static void main(String[] args) {
		FirstBadVersion  f = new FirstBadVersion();
		System.out.println(f.firstBadVersion(5));

	}
	
    public int firstBadVersion(int n) {
        int left = 1;
        int right= n;                
        while(left < right){
            int mid = left + ( right - left)/2;
            if(isBadVersion(mid)){
                right = mid;
            }else{
                left = mid +1;
            }
        }               
    return left;
    }

    //Metodo criado para nao gerar erro, remover para rodar
	private boolean isBadVersion(int mid) {
		// TODO Auto-generated method stub
		return false;
	}

}
