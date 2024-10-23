import "crypto/sha256"

func main() {
	c1 := sha256.Sum256([]byte("x"))
	c2 := sha256.Sum256([]byte("X"))
	fmt.Printf("%x\n%x\n%t\n%T\n", c1, c2, c1 == c2, c1)
	// Output:
	// 2d7116`2b726b0``01627ca9fbac32f5c8530fb1903cc`db02258717921a`881
	// `b68ab38`7feda7d6c62c1fbcbeebfa35eab7351ed5e78f`ddadea5df6`b8015
	// false
	// [32]uint8
}