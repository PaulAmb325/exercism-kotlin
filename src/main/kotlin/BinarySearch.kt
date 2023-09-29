object BinarySearch {
    fun search(list: List<Int>, item: Int): Int {
        val res : Int = list.binarySearch(item);
        if (res < 0) {
            throw NoSuchElementException();
        }
        return res;
    }
}
