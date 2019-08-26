package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"strings"
)

func main() {

	if len(os.Args) != 2 {
		log.Fatal("error: missing book file")
	}

	fileToOpen := os.Args[1]
	fmt.Println(fileToOpen)
	file, err := os.Open(os.Args[1])
	if err != nil {
		log.Fatal(err)
	}

	scanner := bufio.NewScanner(file)
	// scanner.Split(bufio.ScanWords)
	for scanner.Scan() {
		word := scanner.Text()
		words := strings.Split(word, " ")
		for _, w := range words {
			fmt.Printf("[%s]\n", w)
		}
		// strings.SPl
		// fmt.Println(word)
	}

}
