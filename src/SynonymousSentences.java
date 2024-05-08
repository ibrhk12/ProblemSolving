import java.util.*;

public class SynonymousSentences {
    private class UnionFind{
        // Key is item and value is parent
        Map<String, String> node;
        UnionFind(){
            node = new HashMap<>();
        }
        String find(String item){
            if(node.containsKey(item)) {
                if (node.get(item).equals(item))
                    return item;
                node.put(item, find(node.get(item)));
            }
            else
                node.put(item, item);
            return node.get(item);
        }
        void union(String a, String b){
            String parentA = find(a);
            String parentB = find(b);
            node.put(parentB, parentA);
        }
    }
    private void backTrack(Map<String, List<String>> groups, List<String> answer, List<String> txt, UnionFind uf, int index) {
        if (index == txt.size()) {
            answer.add(String.join(" ", txt));
            return;
        }
        if(!uf.node.containsKey(txt.get(index))){
            backTrack(groups, answer, txt, uf, index + 1);
            return;
        }
        String parent = uf.find(txt.get(index));
        for (String item : groups.get(parent)) {
            txt.set(index, item);
            backTrack(groups, answer, txt, uf,index + 1);

        }
    }
    public List<String> generateSentences(List<List<String>> synonyms,
                                          String text) {
        Map<Integer, String> mapSyn = new TreeMap<>();
        List<String> syn = new ArrayList<>();
        UnionFind uf = new UnionFind();
        List<String> txt = Arrays.asList(text.split(" "));
        for(List<String> synonym : synonyms) {
            uf.union(synonym.get(0), synonym.get(1));
           /* for (String s : synonym) {
                int index = txt.indexOf(s);
                while(txt.contains(s) && !mapSyn.containsKey(index)) {
                    txt.set(index, "0");
                    mapSyn.put(index, s);
                    index = txt.indexOf(s);
                }

            }*/
        }
        /*text = String.join(" ", txt);
        for(Map.Entry<Integer, String> it : mapSyn.entrySet())
            syn.add(it.getValue());
        for(String newParent : syn){
            String parent = uf.find(newParent);
            uf.node.put(parent, newParent);
            uf.node.put(newParent, newParent);
        }*/
        Map<String, List<String>> groups = new HashMap<>();
        for(Map.Entry<String, String> it : uf.node.entrySet()) {
            if (groups.containsKey(uf.find(it.getValue())))
                groups.get(uf.find(it.getValue())).add(it.getKey());
            else {
                groups.put(uf.find(it.getValue()), new ArrayList<>());
                groups.get(uf.find(it.getValue())).add(it.getKey());
            }

        }
        //System.out.println(syn);
        //System.out.println(uf.node);
        //System.out.println(groups);
        //System.out.println(txt);
        List<String> answer = new ArrayList<>();
        backTrack(groups, answer, txt, uf, 0);
        Collections.sort(answer);
        return answer;
    }
}
