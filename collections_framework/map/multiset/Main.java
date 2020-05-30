import java.util.*;

interface Multiset<E> {

    /**
     * Add an element to the multiset.
     * It increases the multiplicity of the element by 1.
     */
    void add(E elem);

    /**
     * Remove an element from the multiset.
     * It decreases the multiplicity of the element by 1.
     */
    void remove(E elem);

    /**
     * Unite this multiset with another one. The result is the modified multiset (this).
     * It will contain all elements that are present in at least one of the initial multisets.
     * The multiplicity of each element is equal to the maximum multiplicity of
     * the corresponding elements in both multisets.
     */
    void union(Multiset<E> other);

    /**
     * Intersect this multiset with another one. The result is the modified multiset (this).
     * It will contain all elements that are present in the both multisets.
     * The multiplicity of each element is equal to the minimum multiplicity of
     * the corresponding elements in the intersecting multisets.
     */
    void intersect(Multiset<E> other);

    /**
     * Returns multiplicity of the given element.
     * If the set doesn't contain it, the multiplicity is 0
     */
    int getMultiplicity(E elem);

    /**
     * Check if the multiset contains an element,
     * i.e. the multiplicity > 0
     */
    boolean contains(E elem);

    /**
     * The number of unique elements,
     * that is how many different elements there are in a multiset.
     */
    int numberOfUniqueElements();

    /**
     * The size of the multiset, including repeated elements
     */
    int size();

    /**
     * The set of unique elements (without repeating)
     */
    Set<E> toSet();
}

class HashMultiset<E> implements Multiset<E> {

    private Map<E, Integer> map = new HashMap<>();

    @Override
    public void add(E elem) {
        if (this.map.containsKey(elem)) {
            this.map.put(elem, this.map.get(elem) + 1);
        } else {
            this.map.put(elem, 1);
        }
    }

    @Override
    public void remove(E elem) {
        if (this.map.get(elem) > 1) {
            this.map.put(elem, this.map.get(elem) - 1);
        } else {
            this.map.remove(elem);
        }
    }

    @Override
    public void union(Multiset<E> other) {
        for (E e : other.toSet()) {
            if (this.map.containsKey(e)) {
                this.map.put(e, Math.max(this.map.get(e), other.getMultiplicity(e)));
            } else {
                this.map.put(e, other.getMultiplicity(e));
            }
        }
    }

    @Override
    public void intersect(Multiset<E> other) {
        Set<E> setThis = this.toSet();
        Set<E> setOther = other.toSet();

        setThis.retainAll(setOther);
        HashMap<E, Integer> intersecMap = new HashMap<>();
        for (E e : setThis) {
            intersecMap.put(e, Math.min(this.map.get(e), other.getMultiplicity(e)));
        }

        this.map.clear();
        this.map = intersecMap;
    }

    @Override
    public int getMultiplicity(E elem) {
        return this.map.get(elem) == null ? 0 : this.map.get(elem);
    }

    @Override
    public boolean contains(E elem) {
        return this.map.containsKey(elem);
    }

    @Override
    public int numberOfUniqueElements() {
        return this.map.size();
    }

    @Override
    public int size() {
        int sum = 0;
        for (int i : this.map.values()) {
            sum += i;
        }

        return sum;
    }

    @Override
    public Set<E> toSet() {
        // Creating a new HashSet<> object helps us avoid ConcurrentModificationException.
        // It is thrown when we try to iterate over elements of Map and modify them at the same time
        return new HashSet<>(map.keySet());
    }
}