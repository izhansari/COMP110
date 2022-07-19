package comp110;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author: Izhan
 *
 * ONYEN:
 *
 * Collaborator(s):
 *
 * UNC Honor Pledge: I certify that no unauthorized assistance has been received
 * or given in the completion of this work. I certify that I understand and
 * could now rewrite on my own, without assistance from collaborators or course
 * staff, the problem set code I am submitting.
 */
public class Study {
	
	private Sample _subject;
	private List<Sample> _candidates;
	private int _threshold;
	
	public Study (Sample x, int y){
		_subject = x;
		_threshold = y;
		_candidates = new ArrayList<Sample>();

	}
	
	public double getAncestorProbability (Sample cand){
		Set<String> x = cand.filterAlleles(_threshold);
		Set<String> y = _subject.filterAlleles(_threshold);	
		x.retainAll(y);
		double i= y.size()/2.0;
		double ans= x.size()/i;
		return ans;
	}
	
	public void addCandidate (Sample x){
		_candidates.add(x);
	}
	
	public Set<Sample> getAncestors() {
		Set<Sample> _ancestors = new HashSet<Sample>();

		for (Sample x : _candidates){
			if (this.getAncestorProbability(x) >= 0.90){
				_ancestors.add(x);
			}
		}
		return _ancestors;
	}
}