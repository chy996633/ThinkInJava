package interfaces.interfaceprocessers;
import static net.mindview.util.Print.*;

public class Apply {
	public static void process(Processor p,Object o){
		print("Using processer"+p.name());
		print(p.process(o));
	}

}
