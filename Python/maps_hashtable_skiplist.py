freq = {}
for piece in open(filename).read().lower().split():
    # only consider alphabetic characters within this piece
    word = ''.join(c for c in piece if c.isalpha())
    if word:  # require at least one alphabetic character
        freq[word] = freq.get(word, 0) + 1

max_word = ''
max_count = 0
for (w, c) in freq.items():  # (key, value) tuples represent (word, count)
    if c > max_count:
        max_word = w
        max_count = c
print('The most frequency word is', max_word)
print('Its number of occurrences is', max_count)


class UnsortedTableMap(MapBase):
    """Map implementation using an unordered list"""

    def __init__(self):
        """Create an empty map"""
        self._table = []

    def __getitem__(self, k):
        """Return value associated with key k (raise KeyError if not found)"""
        for item in self._table:
            if k == item._key:
                return item._value
        raise KeyError('Key Error: ' + repr(k))

    def __setitem__(self, k, v):
        """Assign value v to key k, overwriting value if present"""
        for item in self._table:
            if k == item._key:
                item._value = v
                return
        # did not find match for key
        self._table.append(self._Item(k, v))

    def __delitem__(self, k):
        """Return number of items in the map"""
        for j in range(len(self._table)):
            if k == self._table[j]._key:
                self._table.pop(j)
                return
        raise KeyError('Key Error: ' + repr(k))

    def __len__(self):
        """Return the number of items in the map"""
        return len(self._table)

    def __iter__(self):
        """Generate iteration of the map's keys"""
        for item in self._table:
            yield item._key


def hash_code(s):
    mask = (1 << 32) - 1  # limit to 32 bit integers
    h = 0
    for character in s:
        h = (h << 5 & mask) | (h >> 27)  # 5 bit cycle shift of running sum
        h += ord(character)  # add in value of next character
    return h


class HashTableMap(MapBase):
    """Abstract base class for map using table with MAD compression"""

    def __init__(self, N=11, p=109345121):
        """create an empty ash table map"""
        self._table = cap * [None]
        self._n = 0
        self._prime = p
        self._scale = 1 + randrange(p - 1)
        self._shift = randrange(p)

    def _hash_function(self, k):
        return (hash(k)*self._scale+self._shift) % self._prime % len(self._table)

    def __len__(self):
        return self._n

    def __getitem__(self, k):
        j = self._hash_function(k)
        return self._bucket_getitem(j, k)

    def __setitem__(self, k, v):
        j = self._hash_function(k)
        self._bucket_setitem(j, k, v)
        if self._n > len(self._table) // 2:
            self.resize(2 * len(self._table) - 1)

    def __delitem__(self, k):
        j = self._hash_function(k)
        self._bucket_delitem(j, k)
        self._n -= 1

    def _resize(self, c):
        old = list(self.items())
        self._table = cap * [None]
        self._n = 0
        for (k, v) in old:
            self[k] = v


class ChainHashMap(HashTableMap):
    """Hash map implemented with separate chaining for collision resolution"""

    def _bucket_getitem(self, j, k):
        bucket = self._table[j]
        if bucket is None:
            raise KeyError('Key Error: ' + repr(k))  # no match
        return bucket[k]

    def _bucket_setitem(self, j, k, v):
        if self._table[j] is None:
            self._table[j] = UnsortedTableMap()
        oldsize = len(self._table[j])
        self._table[j][k] = v
        if len(self._table[j]) > oldsize:
            self._n += 1

    def _bucket_delitem(self, j, k):
        bucket = self._table[j]
        if bucket is None:
            raise KeyError('Key Error: ' + repr(k))  # no match
        del bucket[k]

    def __iter__(self):
        for bucket in self._table:
            if bucket is not None:
                for key in bucket:
                    yield key


class ProbeHashMap(HashMapBase):
    """Hash map implemented with linear probing for collision resolution"""
    _AVAIL = object()

    def _is_available(self, j):
        """Return True if index j is available in table"""
        return self._table[j] is None or self._table[j] is ProbeHashMap._AVAIL

    def _find_slot(self, j, k):
        """Search for key k in bucket at index j

        Return (success, index) tuple, describe as follows:
        If match was found, success is True and index denotes its location
        If no match found, success is False and index denotes first available slot.
        """
        firstAvail = None
        while True:
            if self._is_available(j):
                if firstAvail is None:
                    firstAvail = j
                if self._table[j] is None:
                    return (False, firstAvail)
            elif k == self._table[j]._key:
                return (True, j)
        j = (j + 1) % len(self._table)

    def _bucket_getitem(self, j, k):
        found, s = self._find_slot(j, k)
        if not found:
            raise KeyError('Key Error: ' + repr(k))
        return self._table[s]._value

    def _bucket_setitem(self, j, k, v):
        found, s = self._find_slot(j, k)
        if not found:
            self._table[s] = self._Item(k, v)
            self._n += 1
        else:
            self._table[s]._value = v

    def _bucket_delitem(self, j, k):
        found, s = self._find_slot(j, k)
        if not found:
            raise KeyError('Key Error: ' + repr(k))
        self._table[s] = ProbeHashMap._AVAIL

    def __iter__(self):
        for j in range(len(self._table)):
            if not self._is_available(j):
                yield self._table[j]._key
