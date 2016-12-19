package concurrency.practise;

import java.awt.Image;
import java.util.Set;

/**
 * 出租车车队类，指挥出租车的调动
 * @author Andre
 *
 */
public class Dispatcher {
	private final Set<Taxi> taxis;//出租车集合
	private final Set<Taxi> availableTaxis;///可用出租车集合
	
	public Dispatcher(Set<Taxi> taxis , Set<Taxi> availableTaxis){
		this.taxis = taxis;
		this.availableTaxis = availableTaxis;
	}

	public synchronized  void notifyAvailable(Taxi taxi) {
		availableTaxis.add(taxi);
	}
	
	/**
	 * 获得包含当前出租车的完整画面
	 * @return
	 */
	public synchronized CarImage getImage(){
		CarImage image = new CarImage();
		for(Taxi t: taxis)
			image.drawMarker(t.getLocation());
		return image;
	}

}
