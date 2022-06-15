package cc;

public class Circle {
	private final double PI = 3.14;
	private int r; // ¹ÝÁö¸§
	
	public Circle() {
		r = 0;
	}
	
	public Circle(int a) {
		r = a;
		
	}
	
	public int getR() {
		   return r;
		}
	
	public void setR(int r){
		   this.r = r;
		}

	public double getArea() {
		return r*r*PI;
		
	}
}

