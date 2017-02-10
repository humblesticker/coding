class CombinationSum2 {
    vector<vector<int>> set;
    vector<int> candidates;
    
    void walk(int pos, int T, vector<int> seq) {
        if(T == 0) {
            //sort(seq.begin(), seq.end());
            set.push_back(seq);
            return;
        }
        if(pos < 0 || T < 0) return;
        
        walk(pos-1, T, seq);
        
        seq.push_back(candidates[pos]);
        walk(pos-1, T-candidates[pos], seq);
    }
    
    bool contains(vector<int>& seq) {
        for(int i=0; i<set.size(); i++) {
            if(set[i].size() != seq.size()) continue;
            bool matched = true;
            for(int j=0; j<set[i].size(); j++) if(set[i][j] != seq[j]) { matched = false; break; }
            if(matched) return true;
        }
        return false;
    }
    
    void check(int pos, int T, vector<int> seq) {
        if(T == 0) { if(!contains(seq)) set.push_back(seq); return; }
        if(pos >= candidates.size() || T < 0) return;
        
        seq.push_back(candidates[pos]);
        check(pos+1, T-candidates[pos], seq);
        
        seq.pop_back();
        check(pos+1, T, seq);
    }
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        this->candidates = candidates;
        vector<int> seq;
        //walk(candidates.size()-1, target, seq);
        check(0, target, seq);
        return set;
    }
};
/*
bf
    recursively try all comb

    ~ 2^n

dP
    S(n, T) = S(n-1, T-n) or S(n-1, T)
    if T == 0 
    
    ~ nT
    

walk(int pos, int T, vector<int> seq) 
    if(T == 0) set.push_back(seq);
    walk(pos-1, T-candidates[pos], seq.push_back(candidates[pos]));
    walk(pos-1, T, seq);

*/