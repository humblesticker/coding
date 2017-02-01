public class RepeatedDNASequence {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> found = new HashSet<>(), repeated = new HashSet<>();
        for(int i=0; i<=s.length()-10; i++) {
            String seq = s.substring(i, i+10);
            if(!found.add(seq)) repeated.add(seq);
        }
        return new ArrayList(repeated);
    }
}