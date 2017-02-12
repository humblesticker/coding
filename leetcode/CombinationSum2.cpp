class CombinationSum2 {
    vector<vector<int>> set;
    vector<int> candidates;
    
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
        check(0, target, seq);
        return set;
    }
};
/*

*/