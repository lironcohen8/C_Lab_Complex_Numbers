public class ComplexNumber {

	private static final double EPSILON = 0.001;
	private double realPart;
	private double imaginaryPart;
	private double radius;
	private double argument;
	
	public ComplexNumber(double realPart, double imaginaryPart) {
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
		this.updatePolarMembers();
	}
	
	public double getRealPart() {
		return realPart;
	}
	
	public double getImaginaryPart() {
		return imaginaryPart;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getArgument() {
		return argument;
	}
	
	public ComplexNumber plus(ComplexNumber other) {
		double sumRealPart = this.realPart + other.realPart;
		double sumImaginaryPart = this.imaginaryPart + other.imaginaryPart;
		return new ComplexNumber(sumRealPart, sumImaginaryPart);
	}
	
	public ComplexNumber minus(ComplexNumber other) {
		double differenceRealPart = this.realPart - other.realPart;
		double differenceImaginaryPart = this.imaginaryPart - other.imaginaryPart;
		return new ComplexNumber(differenceRealPart, differenceImaginaryPart);
	}
	
	public ComplexNumber times(ComplexNumber other) { 
		double productRadius = this.radius * other.radius;
		double productArgument = this.argument + other.argument;
		return fromPolarCoordinates(productRadius, productArgument);
	}
	
	public ComplexNumber divide(ComplexNumber other) {
		double divisionRadius = this.radius / other.radius;
		double divisionArgument = this.argument - other.argument;
		return fromPolarCoordinates(divisionRadius, divisionArgument);
	}
	
	public boolean almostEquals(ComplexNumber other) {
		return this.minus(other).getRadius() < EPSILON;
	}
	
	public static ComplexNumber fromPolarCoordinates(double radius, double argument) {
		double realPart = radius * Math.cos(argument);
		double imaginaryPart = radius * Math.sin(argument);
		return new ComplexNumber(realPart, imaginaryPart);
	}
	
	private void updatePolarMembers() {
		radius = Math.sqrt((realPart * realPart) + (imaginaryPart * imaginaryPart));
		argument = Math.atan2(imaginaryPart, realPart);
	}
}
