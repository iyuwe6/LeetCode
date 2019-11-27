package leetcode

// 暴力法
func twoSum(nums []int, target int) []int {
	result := make([]int, 2)
	for i := 0; i < len(nums); i++ {
		for j := i + 1; j < len(nums); j++ {
			if nums[i]+nums[j] == target {
				result[0] = i
				result[1] = j
				return result
			}
		}
	}
	return result
}

// HashMap一次循环
func twoSum2(nums []int, target int) []int {
	result := make([]int, 2)
	m := make(map[int]int)

	for j := 0; j < len(nums); j++ {
		sub := target - nums[j]
		v, ok := m[sub]
		if ok {
			result[0] = v
			result[1] = j
			return result
		}
		m[nums[j]] = j
	}
	return result
}

// HashMap两次循环，有缺陷
func twoSum3(nums []int, target int) []int {
	result := make([]int, 2)
	m := make(map[int]int)

	for i := 0; i < len(nums); i++ {
		m[nums[i]] = i
	}

	for j := 0; j < len(nums); j++ {
		sub := target - nums[j]
		v, ok := m[sub]
		if ok && v != nums[j] {
			result[0] = v
			result[1] = j
			return result
		}
	}
	return result
}
