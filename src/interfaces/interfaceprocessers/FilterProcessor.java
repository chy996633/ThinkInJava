package interfaces.interfaceprocessers;

import interfaces.filters.BandPass;
import interfaces.filters.Filter;
import interfaces.filters.HighPass;
import interfaces.filters.Waveform;

class FilterAdapter implements Processor{
	Filter filter;
	
	public FilterAdapter(Filter filter) {
		this.filter = filter;
	}

	@Override
	public String name() {
		return filter.name();
	}

	@Override
	public Object process(Object input) {
		return filter.process((Waveform)input);
	}
	
}

public class FilterProcessor{
	static Waveform w = new Waveform();
	public static void main(String[] args){
		Apply.process(new FilterAdapter(new HighPass(1.0)), w);
		Apply.process(new FilterAdapter(new BandPass(1.0, 0.8)), w);
	}
	
}
