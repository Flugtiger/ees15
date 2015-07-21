package de.ees.group1.cs.controller;


import java.util.ListIterator;

import de.ees.group1.bt.BT_manager;
import de.ees.group1.com.IControlStation;
import de.ees.group1.cs.gui.IConnectionController;
import de.ees.group1.cs.gui.IOrderController;
import de.ees.group1.cs.gui.MainWindow;
import de.ees.group1.model.*;

public class ControlStation implements IOrderController, IControlStation, IConnectionController{

	private ProductionOrder currentOrder;
	private ProductionStep currentStep;
	private int currentStepNumber;
	private OrderList list;
	private int statusNXT;
	private BT_manager btManager;
	private WorkingStationAll workingStation;
	private MainWindow mainWindow;
	private boolean isInWaitingPosition;
	private WorkingStation currentWorkStation;
	
	
	public ControlStation(MainWindow mainWindow){
		this.mainWindow=mainWindow;
		btManager=new BT_manager();
		btManager.register(this);
		//Erzeugt die vier Arbeitsstationen
		workingStation=new WorkingStationAll();
		for (int i = 0; i < 4; i++) {
			new WorkingStation(btManager, i+1, workingStation);
		}
		//Erzeugt OrderList
		list=new OrderList();
		/*btManager.connectWithDevice("00:16:53:05:65:FD");
		//Test
		type=WorkstationType.DRILL;
		currentStep=new ProductionStep(type, 1,5);
		currentOrder.add(currentStep);
		type=WorkstationType.LATHE;
		currentStep=new ProductionStep(type, 3,2);
		currentOrder.add(1,currentStep);
		workingStation.workstationQualityUpdatedAction(1, 1);
		workingStation.workstationQualityUpdatedAction(2, 1);
		workingStation.workstationQualityUpdatedAction(3, 3);
		workingStation.workstationQualityUpdatedAction(4, 3);
		workingStation.workstationTypeUpdatedAction(1, WorkstationType.DRILL);
		workingStation.workstationTypeUpdatedAction(2, WorkstationType.DRILL);
		workingStation.workstationTypeUpdatedAction(3, WorkstationType.LATHE);
		workingStation.workstationTypeUpdatedAction(4, WorkstationType.LATHE);
	*/
	}
	
	
	/*
	 * �bergibt den gerade an den NXT �bermittleten Auftrag an die ControlStation
	 */	
	public void setCurrentOrder(){
		currentOrder=list.getFirstOrder();
		currentStepNumber=0;
	}
	
	/*
	 * F�gt der Liste mit den ProductionOrder einen neuen Auftrag zu.
	 */
	public void addProductionOrder(ProductionOrder order){
		list.setProductionOrder(order);
	}
	/*
	 * Gibt den Status des NXT zur�ck
	 */
	public int getStatusNXT(){
		return statusNXT;
	}
	/*
	 * evaluiert den Status des NXT und setzt die aktuelle Arbeitsstation. Bei Abarbeitung eines Schritts wird die Variable currentStepNumber erh�ht
	 */
	public void evaluateStatusNXT(){
		int status=getStatusNXT();
		if ((0<status) & (status<=22)){
			switch (status){
			case 1: case 5: case 9: case 13: case 17:
				currentWorkStation=workingStation.getWorkingStaion(1);
				break;
			case 2: case 6: case 10: case 14: case 18:
				currentWorkStation=workingStation.getWorkingStaion(2);
				break;
			case 3: case 7: case 11: case 15: case 19:
				currentWorkStation=workingStation.getWorkingStaion(3);
				break;
			case 4: case 8: case 12: case 16: case 20:
				currentWorkStation=workingStation.getWorkingStaion(4);
				break;
			case 21:
				//neuen Auftrag ansto�en
				break;
			case 22:
				//Meldung alles kaputt
				break;
			}
		}
		if ((0<status) & (status<=20)){
			switch (status){
			case 1: case 2: case 3: case 4: 
				currentStepNumber++;
				break;
			case 5: case 6: case 7: case 8: 
				//action to "Weiterfahrt";
				break;
			case 9: case 10: case 11: case 12: 
				//arbeit beginnen;
				break;
			case 13: case 14: case 15: case 16: 
				//Arbeit beendet;
				break;
			case 17: case 18: case 19: case 20: 
				//arbeit konnte nicht durchgef�hrt werden;
				break;
			}
		}
	}
	/*
	 * �bergibt der variablen currentStep den aktuellen Schritt
	 */
	public void setCurrentStep(ProductionStep step) {
		currentStep=step;		
	}

	/*
	 * Gibt die Variable currentStep zur�ck
	 */
	public ProductionStep getCurrentStep() {
		return currentStep;
	}

	/*
	 * f�gt der list die �bergebene ProductionOrder zu.
	 * updated im Mainwindo die Liste mit den Auftr�gen
	 * falls kein Auftrag in der Order war, als der NXT die Parkposition erreicht hat, wird versucht den aktuellen Auftrag zu senden
	 */
	public void orderCreatedAction(ProductionOrder order) {
		list.add(order);
		mainWindow.updateOrderList(list);
		if(isInWaitingPosition==true){
		reachedParkingPositionInd(21);
		}
	}

	/*
	 * Entfernt den Auftrag mit der �bergebenen ID
	 */
	public void orderRemovedAction(int orderID) {
		ListIterator<ProductionOrder> iterator=list.listIterator();
		while(iterator.hasNext()){
			ProductionOrder temp=iterator.next();
			if (temp.getId()==orderID){
				list.remove(temp);
			}
		}
		mainWindow.updateOrderList(list);
	}

/*
 * Gibt die ID des n�chsten Auftrags zur�ck
 */
	public int getNextOrderId() {
		ListIterator<ProductionOrder> iterator=list.listIterator();
		if(iterator.hasNext()){
			return iterator.next().getId();
		}
		else{
			return -1;
		}
	}

	/*
	 *Verschiebt die Order mit der angegebenen ID eins nach unten und updated das mainwindow 
	 */
	public void moveOrderDown(int orderID) {
		int i=0;
		ListIterator<ProductionOrder> iterator=list.listIterator();
		while(iterator.hasNext()&(i==0)){
			ProductionOrder temp=iterator.next();
			if (temp.getId()==orderID){
				list.remove(temp);
				int index =iterator.nextIndex();
				list.add(index, temp);
				i=1;
			}
		}
		mainWindow.updateOrderList(list);
	}

	/*
	 *Verschiebt die Order mit der angegebenen ID eins nach oben und updated das mainwindow 
	 */
	public void moveOrderUp(int orderID) {
		int i=0;
		ListIterator<ProductionOrder> iterator=list.listIterator();
		while(iterator.hasNext()&(i==0)){
			ProductionOrder temp=iterator.next();
			if (temp.getId()==orderID){
				list.remove(temp);
				int index =iterator.nextIndex();
				index=index-2;
				list.add(index, temp);
				i=1;
			}
		}
		mainWindow.updateOrderList(list);
	}

	/*
	 * Aktualisiert die ausgew�hlte Order
	 */
	public void orderUpdatedAction(ProductionOrder tmp) {
		int i=tmp.getId();
		list.remove(i);
		list.setProductionOrder(tmp);
		mainWindow.updateOrderList(list);
	}

	//Auftrag erfolgreich �bertragen, keine Reaktion 
	public void giveAcknowledgement(boolean answer) {
	}

	/*
	 * aktualisiert den Status des NXT und evaluiert ihn anschlie�end
	 */
	public void transmitActualState(int state) {
		statusNXT=state;
		evaluateStatusNXT();
	}

	/*
	 *NXT hat die Parkposition erreicht, falls der vorherige Auftrag erfolgreich durchgef�hrt wurde, wird der n�chste Auftrag �bergeben
	 *Falls der aktuelle Auftrag nicht erfolgreich verlief wird kein Auftrag mehr �bermittelt
	 */
	public void reachedParkingPositionInd(int nextWorkingStep) {
		if  (nextWorkingStep==21){
			if(isInWaitingPosition==false){
				list.remove(0);
			}
			if(list.isEmpty()==false){
			currentOrder=list.getFirstOrder();
			btManager.transmitProductionOrder(currentOrder);
			isInWaitingPosition=false;
			}
			else{
				isInWaitingPosition=true;
				
			}
		}
		else{
			
		}
	}

	/*
	 * Verbindet sich mit dem NXT
	 */
	public void connectBT(String MAC) {
		btManager.connectWithDevice(MAC);
	}


	@Override
	public void connectBT(byte[] MAC) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void activeOrderCanceledAction() {
		// TODO Auto-generated method stub
		
	}
}
