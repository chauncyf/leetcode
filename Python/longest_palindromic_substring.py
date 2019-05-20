class Solution:
    def longestPalindrome(self, s: str) -> str:
        start, end = 0, 0
        for i in range(len(s)):
            cur_len = max(self.expand(s, i, i), self.expand(s, i, i + 1))
            if cur_len > end - start:
                start = i - (cur_len - 1) // 2  # remember to -1 since it could expand at center of two char
                end = i + cur_len // 2
        return s[start:end + 1]
        
    def expand(self, s, left, right):
        l , r = left, right
        while (l >= 0 and r < len(s) and s[l] == s[r]):
            l -= 1
            r += 1
        return r - l - 1
