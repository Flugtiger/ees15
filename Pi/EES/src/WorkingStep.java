
public class WorkingStep {
	private int processTime; //Gibt die benötigte Bearbeitungszeit an
	private int quality;		//Gibt die Mindestqualität an
	private String machine;	//Gibt die Maschinenart an
	private int number;		//Gibt die Nummer des Bearbeitungsschritts innerhalb des Auftrags an, beginnend bei 1
	//Erzeugt Bearbeitungsschritt
	public WorkingStep(int time, int quality, String machine, int num){
		processTime=time;
		this.quality=quality;
		this.machine=machine;
		number=num;
	}
	public int getNumber(){
		return number;
	}
	public int getProcessTime(){
		return processTime;
	}
	public String getMachineTyp(){
		return machine;
	}
	public int getQuality(){
		return quality;
	}
}

