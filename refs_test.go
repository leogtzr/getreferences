package main

import (
	"testing"
)

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

func Test_addReferenceWithConfidence(t *testing.T) {
	type test struct {
		content    string
		index      int
		references []Reference
		want       []Reference
	}

	tests := []test{
		{
			content:    "abc",
			index:      0,
			references: []Reference{},
			want: []Reference{
				Reference{content: "abc", confidence: Begin},
			},
		},

		{
			content:    "abc",
			index:      1,
			references: []Reference{},
			want: []Reference{
				Reference{content: "abc", confidence: Begin},
			},
		},
	}

	for _, tc := range tests {
		addReferenceWithConfidence(tc.content, tc.index, &tc.references)
		if len(tc.references) != len(tc.want) {
			t.Errorf("got=[%d], want=[%d] as length", len(tc.references), len(tc.want))
		}
		if tc.references[0].content != tc.want[0].content {
			t.Errorf("got=[%s], want=[%s]", tc.references[0].content, tc.want[0].content)
		}
		if tc.references[0].confidence != tc.want[0].confidence {
			t.Errorf("got=[%d], want=[%d]", tc.references[0].confidence, tc.want[0].confidence)
		}
	}
}
