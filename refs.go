package main

import "strings"

func getContentTextFromRange(from, to int, words []string) string {
	var sb strings.Builder

	for i := from; i < to; i++ {
		sb.Write([]byte(words[i]))
		sb.Write([]byte(" "))
	}

	return sb.String()
}

func getNextReferenceIndex(index int, words []string) int {
	for index < len(words) && isTitle(words[index]) {
		index++
	}
	return index
}
