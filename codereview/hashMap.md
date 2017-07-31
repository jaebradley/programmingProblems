## Purpose

I've never implemented a `HashMap` and thought it would be a good data structure exercise. I tried looking at the Java
source code as little as possible.

## Discussion

The `HashMap` was made up of an array of `Entry`s. Each `Entry` is points to another `Entry` (or `null` if it's the
last `Entry` in the linked list).

Since you'd want `Entry`s distributed as equally as possible across the different index values of the internal `Entry`
array, each key's hashcode is hashed again to combat a bad hashcode (this code is from the Java 8 source code) and
eventually an index value is calculated - this index value represents the index of the internal array that the
key-value pair will exist under.

Thus, the logic for getting a value for a particular key would be to translate the key into an index value, and then
to get the first `Entry` for that index value from the internal array. And then to get the `Entry` in the linked list
with the same key (or return `null` if the linked list has been exhausted).

Another thing that was interesting to implement was array resizing. Every time `put` is called, it checks to see if array
resizing needs to occur. I resize the array if the number of objects that have been added to the array is greater than
75% of the allocated array capacity. I don't know if this is the best way to implement a resize check. When actually
resizing the array, I needed to iterate through every `Entry` and reindex the `Entry`.

Things I don't like:
* My implementation seems really messy.
  1. I don't like the `addEntry` method. I don't like it has a `boolean` return. However, I did this so that when `put`ting
    I wouldn't update the `size` when I updated a key-value pair vs. added one.
  2. I don't like how the `setEntry` method keeps the `next` value in memory before overwriting it (this was done so
  that no `Entry` in the linked list did not get reindexed).
* Is the way I'm resizing logical? I read [this article](http://coding-geek.com/how-does-a-hashmap-work-in-java/) and
  that's where I got my ideas for how to resize the internal array.

## Implementation

<!-- language:lang-java --!>

    public class HashMap<K, V> {
        private int size = 0;
        private int capacity = 16;
        private Entry<K, V>[] entries = new Entry[capacity];
        private double loadFactor = 0.75;

        private static class Entry<K, V> {
            private final K key;
            private V value;
            private Entry<K, V> next = null;

            public Entry(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        public HashMap() {
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public int getSize() {
            return this.size;
        }

        public boolean containsKey(K key) {
            Entry<K, V> matchingEntry = getMatchingEntry(key);

            return matchingEntry != null && matchingEntry.key == key;
        }

        public boolean containsValue(V value) {
            for (Entry<K, V> entry : this.entries) {
                while (entry != null && !matches(value, entry.value)) {
                    entry = entry.next;
                }

                if (entry != null) {
                    return true;
                }
            }

            return false;
        }

        public V get(K key) {
            Entry<K, V> matchingEntry = getMatchingEntry(key);

            return matchingEntry == null ? null : matchingEntry.value;
        }

        public void put(K key, V value) {
            if (this.shouldResize()) {
                this.resize();
            }

            if (addEntry(new Entry<>(key, value), this.entries)) {
                this.size++;
            }

        }

        public void remove(K key) {
            int index = indexOf(key);
            Entry<K, V> currentEntry = this.entries[index];

            while (currentEntry != null && currentEntry.next != null && !matches(key, currentEntry.next.key)) {
                currentEntry = currentEntry.next;
            }

            if (currentEntry != null) {
                // this case can only occur if there is only one non-null entry at the index
                if (matches(key, currentEntry.key)) {
                    this.entries[index] = null;
                // this case can only occur because the next entry's key matched
                } else if (currentEntry.next != null) {
                    currentEntry.next = currentEntry.next.next;
                }

                this.size--;
            }
        }

        private boolean shouldResize() {
            return this.size > Math.ceil((double) this.capacity * this.loadFactor);
        }

        private void resize() {
            this.capacity = this.size * 2;

            Entry<K, V>[] newEntries = new Entry[this.capacity];
            for (Entry<K, V> entry : this.entries) {
                if (entry != null) {
                    this.setEntry(entry, newEntries);
                }
            }

            this.entries = newEntries;
        }

        private void setEntry(Entry<K, V> entry, Entry<K, V>[] entries){
            Entry<K, V> nextEntry = entry.next;
            entry.next = null;

            this.addEntry(entry, entries);

            if (nextEntry != null) {
                this.setEntry(nextEntry, entries);
            }
        }

        private boolean addEntry(Entry<K, V> entry, Entry<K, V>[] entries) {
            int index = indexOf(entry.key);
            Entry<K, V> existingEntry = entries[index];

            if (existingEntry == null) {
                entries[index] = entry;
                return true;
            } else {
                while (!this.matches(entry.key, existingEntry.key) && existingEntry.next != null) {
                    existingEntry = existingEntry.next;
                }

                if (this.matches(entry.key, existingEntry.key)) {
                    existingEntry.value = entry.value;
                    return false;
                }

                existingEntry.next = entry;
                return true;

            }
        }

        private Entry<K, V> getMatchingEntry(K key) {
            Entry<K, V> existingEntry = this.entries[indexOf(key)];

            while (existingEntry != null && !matches(key, existingEntry.key)) {
                existingEntry = existingEntry.next;
            }

            return existingEntry;
        }

        private int indexOf(K object) {
            return object == null ? 0 : hash(object) & (this.capacity - 1);
        }

        private boolean matches(Object o1, Object o2) {
            return (o1 == null && o2 == null) ||
                    (o1 != null && o2 != null && o1.equals(o2));
        }

        /**
         * Applies a supplemental hash function to a given hashCode, which
         * defends against poor quality hash functions.  This is critical
         * because HashMap uses power-of-two length hash tables, that
         * otherwise encounter collisions for hashCodes that do not differ
         * in lower bits. Note: Null keys always map to hash 0, thus index 0.
         */
        private static int hash(Object key) {
            // This function ensures that hashCodes that differ only by
            // constant multiples at each bit position have a bounded
            // number of collisions (approximately 8 at default load factor).
            int h;
            return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        }
    }
