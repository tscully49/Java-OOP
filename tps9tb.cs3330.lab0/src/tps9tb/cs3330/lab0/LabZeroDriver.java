package tps9tb.cs3330.lab0;

public class LabZeroDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Object a = new Object();
		Object aClone = a;
		Object b = new Object();
		b.equals(aClone);
		Object c = null;
		
		if (comparingTwoObjects(a,aClone)) {
			System.out.println("They are the same object");
		}
		else {
			System.out.println("They are not the same object");
		}
		if (comparingTwoObjects(b,aClone)) {
			System.out.println("They are the same object");
		}
		else {
			System.out.println("They are not the same object");
		}
		
		viewObjectString(a,'A');
		viewObjectString(b,'B');
		viewObjectString(c,'C');
		
	}
	
	public static boolean comparingTwoObjects(Object firstObj, Object secondObj) {
		return firstObj.equals(secondObj);
	}
	
	public static void viewObjectString(Object obj, char objLetter){
		System.out.println("Object " + objLetter + " JVM value is " + obj.toString());
	}

}
