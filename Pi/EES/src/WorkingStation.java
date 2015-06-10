
public class WorkingStation {
	public String machineTyp;	//Gibt den Maschinentyp an Bohr-oder Drehmaschine
	public int quality;			//Gibt die Qualtit�t an mit der ein Bearbeitungsschritt durchgef�hrt werden kann. 1 Schlechteste 4 Beste 
	public int status;			//Gibt den Status der Station an 1 Bereit, 2 Belegt, 3 Defekt
	public int id;
	public WorkingStation(String typ, int quality, int status, int id){
		if (typ=="Bohrmaschine"||typ=="Drehmaschine"){
			machineTyp=typ;
			}
		else {
			System.out.println("Sie m�ssen Bohrmaschine oder Drehmaschine eingeben");
		}
		
		if ((1<=id)&&(id<=4)){
			this.id=id;
		}
		else {
			System.out.println("Wert muss zwischen 1 und 4 liegen. Die ID wurde nicht festgelegt");
		}
		if ((1<=quality)&&(quality<=4)){
			this.quality=quality;
		}
		else {
			System.out.println("Wert muss zwischen 1 und 4 liegen. Die Qualit�t wurde nicht ver�ndert");
		}
			
		if ((1<=status)&&(status<=3)){
			this.status=status;
			}
		else{
			System.out.println("Der Wert f�r Status muss zwischen 1 und 3 liegen");
		}
	}
	public void setParameters(String typ, int quality){
		machineTyp=typ;
		this.quality=quality;
		status=1;
	}
	public void setTyp(String typ){
		if (typ=="Bohrmaschine"||typ=="Drehmaschine"){
			machineTyp=typ;
			}
		else {
			System.out.println("Sie m�ssen Bohrmaschine oder Drehmaschine eingeben");
		}
		
	}
	//Erm�glicht es die Qualit�t zu ver�ndern von 1 -4
	public void setQuality(int quality){
		if ((1<=quality)&&(quality<=4)){
			this.quality=quality;
		}
		else {
			System.out.println("Wert muss zwischen 1 und 4 liegen. Die Qualit�t wurde nicht ver�ndert");
		}
	}
	//Erm�glicht es den Status zu setzten
	public void setStatus(int status){
		if ((1<=status)&&(status<=3)){
		this.status=status;
		}
		else{
			System.out.println("Der Wert f�r Status muss zwischen 1 und 3 liegen");
		}
	}
	//Gibt die drei Parameter machineTyp, quality und status zur�ck in einem Array
	public Object[] getParameters(){
	return new Object[] {machineTyp,quality,status};
	}
	//Simuliert den Bearbeitungsschritt und gibt nach Ablauf der Bearbeitungszeit dem Transportfahrzeug bekannt, dass der Schritt erfolgreich durchgef�hrt wurde.
	public void working(int time){
		/*
		 * TODO:	warten implementieren
		 * 			senden der Benachrichtigung an Transportfahrzeug	
		 */
	}
	//Gibt die Qualit�t als Integer zur�ck
	public int getQuality(){
		return quality;
	}
	//Gibt den Status als Integer zur�ck
	public int getStatus(){
		return status;
	}
	//Gibt den Maschinentyp als String zur�ck
	public String getMachineTyp(){
		return machineTyp;
	}
	//Gibt die Id als Integer zur�ck
	public int getId(){
		return id;
	}
}
