package leetcode

func lengthOfLongestSubstring(s string) int {
	n := len(s)
	var ans int
	m := make(map[byte]int)
	for i, j := 0, 0; j < n; j++ {
		k := s[j]
		if v, ok := m[k]; ok {
			if v > i {
				i = v
			}
		}
		if ans < j-i+1 {
			ans = j - i + 1
		}
		m[k] = j + 1
	}
	return ans
}
