/**
 * Useful in recommended system.
 * 
 * Formula:
 * 		DCG(p) = rel(1) + Sumation(i=2 to p, rel(i) / log2(i))
 */
package evaluation;

import java.util.List;

/**
 * @author Toni Lam
 *
 * @since
 * @version ?, Jun 10, 2017
 */
public class DiscountedCumulativeGain {
	private List<Double> relevanceScale;
	public DiscountedCumulativeGain(List<Double> relevanceScale) {
		this.relevanceScale = relevanceScale;
	}
	
	public double getDcgAtPosition(int rankPosition) {
		double dcg = relevanceScale.get(0);
		for (int pos = 2; pos <= rankPosition; ++pos) {
			dcg += relevanceScale.get(pos-1)
					/
					(Math.log(pos) /  Math.log(2));	// change log base 2
		}
		return dcg;
	}
}
