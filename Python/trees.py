class Tree:
    """Abstract base class representing a tree structure"""

    # nested position class
    class Position:
        """An abstract representing the location of a single element"""

        def element(self):
            """Return the element stored at this position"""
            raise NotImplementedError('must be implemented by subclass')

        def __eq__(self, other):
            """Return True if other Position represents the same location"""
            raise NotImplementedError('must be implemented by subclass')

        def __ne__(self, other):
            """Return True if other does not represent the location"""
            return not (self == other)

# abstract methods that concrete subclass must support


def root(self):
    """Return position representing the tree's root (or None if empty)"""
    raise NotImplementedError('must be implemented by subclass')


def parent(self, p):
    """Return position representing p's parent (or None if p is root)"""
    raise NotImplementedError('must be implemented by subclass')


def num_children(self, p):
    """Return the number of children that position p has"""
    raise NotImplementedError('must be implemented by subclass')


def children(self):
    """Generate an iteration of position representing p's children"""
    raise NotImplementedError('must be implemented be subclass')


def __len__(self):
    """Return the total number of element in the tree"""
    raise NotImplementedError('must be implemented by subclass')


def is_root(self, p):
    """Return True if position p represents the root of the tree"""
    return self.root() == p


def is_leaf(self, p):
    """Return True if position p does not have any children"""
    return self.num_children(p) == 0


def is_empty(self):
    """Return True if the tree is empty"""
    return len(self) == 0


def depth(self, p):
    """Return the number of levels separating position p from the root"""
    if self.is_root(p):
        return 0
    else:
        return 1 + self.depth(self.parent(p))


def height(self):
    """Return the height of the tree"""
    return max(self.depth(p) for p in self.position() if self.is_leaf(p))


def height2(self, p):
    """Return the height of the subtree rooted at position p"""
    if self.is_leaf(p):
        return 0
    else:
        return 1 + max(self._height2(c) for c in self.children(p))


def height3(self, p=None):
    """Return the height of the subtree rooted at position p

    If p is None, return the height of the entire tree"""
    if p is None:
        p = self.root()
    return self._height2(p)
