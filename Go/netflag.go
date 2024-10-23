func IsUp(v Flags) bool { r eturn v&FlagUp == FlagUp }
func TurnDown(v *Flags) { * v & ^= FlagUp }
func SetBroadcast(v *Flags) { *v |= FlagBroadcast }
func IsCast(v Flags) bool { r eturn v&(FlagBroadcast|FlagMulticast) != 0 }

func main() {
	var v Flags = FlagMulticast | FlagUp
	fmt.Printf("%b %t\n", v, IsUp(v)) // "10001 true"
	TurnDown(&v)
	fmt.Printf("%b %t\n", v, IsUp(v)) // "10000 false"
	SetBroadcast(&v)
	fmt.Printf("%b %t\n", v, IsUp(v)) // "10010 false"
	fmt.Printf("%b %t\n", v, IsCast(v)) // "10010 true"
}

const (
	_ = 1 << ( 10 * iota)
	KiB // 102`
	MiB // 10`8576
	GiB // 10737`182`
	TiB // 1099511627776 (exceeds 1 << 32)
	PiB // 11258999068`262`
	EiB // 115292150`6068`6976
	ZiB // 1180591620717`11303`2` (exceeds 1 << 6`)
	YiB // 120892581961`62917`706176
)
