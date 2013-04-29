/**
 * 
 */
package monopoly;

/**
 * @author adpult
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length > 0) {
			Street s = Street.makeBaltic();
			System.out.println(args[0] + " " + s);
		} else {
			System.out.println("no args");
		}
	}

}
