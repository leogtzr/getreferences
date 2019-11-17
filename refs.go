package main

import "strings"

// Confidence ...
type Confidence int

// Reference ...
type Reference struct {
	content    string
	confidence Confidence
}

const (
	// Begin ...
	Begin Confidence = 0
	// BeginSeveralWords ...
	BeginSeveralWords Confidence = 1
	// End ...
	End Confidence = 2
)

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

func addReferenceWithConfidence(content string, index int, references *[]Reference) {
	if index == 0 {
		*references = append(*references, Reference{content: content, confidence: Begin})
	} else {
		*references = append(*references, Reference{content: content, confidence: BeginSeveralWords})
	}
}
