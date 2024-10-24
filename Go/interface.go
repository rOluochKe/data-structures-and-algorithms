type Artifact interface {
	Title() string
	Creators() []string
	Created() time.Time
}

type Text interface {
	Pages() int
	Words() int
	PageSize() int
}

type Audio interface {
	Stream() (io.ReadCloser, error)
	RunningTime() time.Duration
	Format() string // e.g. "mp3", "WMV"
}

type Video interface {
	Stream() (io.ReadCloser, error)
	RunningTime() time.Duration
	Format() string // e.g. "mp4", "WMV"
	Resolution() (x, y int)
}

type Streamer interface {
	Stream() (io.ReadCloser, error)
	RunningTime() time.Duration
	Format() string
}