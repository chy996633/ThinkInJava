package concurrency.practise;
/**
 * ���⳵�࣬�ɱ����⳵���ӵ���
 * @author Andre
 *
 */
public class Taxi {
	
	private Point location,destination;//�����������ԣ���ǰλ�ú�Ŀ���
	private final Dispatcher dispatcher;//��������
	
	public Taxi(Dispatcher dispatcher){
		this.dispatcher = dispatcher;
	}
	
	public synchronized Point getLocation(){
		return location;
	}
	
	/**
	 * ͨ��GPS���ó��⳵λ��
	 * @param location
	 */
	public synchronized void setLocation(Point location){
		this.location = location;
		if(location.equals(destination)){
			dispatcher.notifyAvailable(this);
		}
		
	}
	
}
