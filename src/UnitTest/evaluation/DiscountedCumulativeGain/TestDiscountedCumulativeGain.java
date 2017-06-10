/**
 * 
 */
package UnitTest.evaluation.DiscountedCumulativeGain;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import evaluation.DiscountedCumulativeGain;

/**
 * @author Toni Lam
 *
 * @since
 * @version ?, Jun 10, 2017
 */
public class TestDiscountedCumulativeGain {

	@Test
	public void getDcgAtPositionReturnExpectedValue() {
		List<Double> ranking = Arrays.asList(new Double[] {
				3.0, 2.0, 3.0, 0.0, 0.0, 1.0, 2.0, 2.0, 3.0, 0.0
				});
		List<Double> expectedDcg = Arrays.asList(new Double[] {
				3.0, 5.0, 6.89, 6.89, 6.89, 7.28, 7.99, 8.66, 9.61, 9.61
				});
		DiscountedCumulativeGain dcg = new DiscountedCumulativeGain(ranking);
		for (int i = 1; i <= 10; ++ i) {
			assertEquals(expectedDcg.get(i-1), dcg.getDcgAtPosition(i), 0.01);
		}
		
	}

}
