
#SuperPow
class Solution {
    public int superPow(int a, int[] b) {
   int mod = 1337;
        a = a % mod;
        return helper(a, b, b.length - 1, mod);
    }

    private int helper(int a, int[] b, int index, int mod) {
        if (index == -1) {
            return 1;
        }
        
        int currentDigit = b[index];
        int prevResult = helper(a, b, index - 1, mod);
        int result = (modularExponentiation(prevResult, 10, mod) * modularExponentiation(a, currentDigit, mod)) % mod;
        
        return result;
    }

    private int modularExponentiation(int base, int exp, int mod) {
        int result = 1;
        base = base % mod;
        
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        
        return result;
    }
}
