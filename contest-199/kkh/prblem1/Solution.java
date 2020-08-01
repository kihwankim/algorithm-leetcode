import java.util.*;

class Solution { // 1528. Shuffle String
    public String restoreString(String s, int[] indices) {
        List<Data> list = new ArrayList<>();
        for (int index = 0; index < indices.length; index++) {
            list.add(new Data(s.charAt(index), indices[index]));
        }
        list.sort(Comparator.comparingInt(listData -> listData.index));
        StringBuilder sb = new StringBuilder();
        for (Data inner : list) {
            sb.append(inner.name);
        }

        return sb.toString();
    }
}

class Data {
    char name;
    int index;

    public Data(char name, int index) {
        this.name = name;
        this.index = index;
    }
}