
import java.util.ArrayList;


public class Fertigungsauftrag {
	public int  orderNumber; //Auftragsnummer
	public ArrayList<Bearbeitungsschritt> processStepQueue; //Warteschlange f�r die einzelnen Bearbeitungsschritte
	public Fertigungsauftrag(int orderNumber){
		this.orderNumber=orderNumber;
	}
	//F�gt einen Bearbeitungsschritt in die Liste ein
	public void insertWorkingStep(Bearbeitungsschritt newStep){
		int i=newStep.getNumber();
		processStepQueue.add(i++,newStep);
	}
	//Gibt die Auftragsnummer zur�ck
	public int getOrderNumber(){
		return orderNumber;
	}
}
