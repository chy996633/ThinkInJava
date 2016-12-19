//: interfaces/filters/BandPass.java
package interfaces.filters;

import java.io.IOException;
import java.nio.CharBuffer;

public class BandPass extends Filter {
  double lowCutoff, highCutoff;
  public BandPass(double lowCut, double highCut) {
    lowCutoff = lowCut;
    highCutoff = highCut;
  }
  public Waveform process(Waveform input) { return input; }
} ///:~


class RandomWords implements Readable{

	@Override
	public int read(CharBuffer cb) throws IOException {
		cb.append("asdasds");
		return 10;
	}
	
}
