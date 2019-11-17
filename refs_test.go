package main

import "testing"

func TestGetContentTextFromRange(t *testing.T) {
	type test struct {
		words    []string
		from, to int
		want     string
	}

	tests := []test{
		{
			words: []string{"la", "morra", "esa", "fea", "ok"},
			from:  1,
			to:    3,
			want:  "morra esa ",
		},
	}

	for _, tc := range tests {
		got := getContentTextFromRange(tc.from, tc.to, tc.words)
		if got != tc.want {
			t.Errorf("got=[%s], want=[%s]", got, tc.want)
		}
	}

}

func TestGetNextReferenceIndex(t *testing.T) {
	type test struct {
		index int
		words []string
		want  int
	}

	tests := []test{
		{index: 0, words: []string{"hola", "que", "haces", "w", "JAvier", "Muriel", "hola", "no"}, want: 6},
	}

	for _, tc := range tests {
		got := getNextReferenceIndex(4, tc.words)
		if got != tc.want {
			t.Errorf("got=[%d], want=[%d]", got, tc.want)
		}
	}

}
