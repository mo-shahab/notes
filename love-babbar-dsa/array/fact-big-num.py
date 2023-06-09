
class Solution:
    def factorial(self, N):
        #code here
        def util(N):
            if N == 0 or N == 1:
                return 1
            return N * util(N - 1)
        ans = util(N)
        return list(str(ans))