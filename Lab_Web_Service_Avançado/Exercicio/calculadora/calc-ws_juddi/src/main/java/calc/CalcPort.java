package calc;

import javax.jws.WebService;

@WebService(
    endpointInterface="calc.CalcPortType",
    wsdlLocation="Calc.wsdl",
    name="Calc",
    portName="CalcPort",
    targetNamespace="urn:calc",
    serviceName="CalcService"


)
public class CalcPort implements CalcPortType {

	public int sum(int a, int b){
		
		return a+b;
	}
	public int sub(int a, int b){
		return a-b;
	}
	public int mult(int a, int b){
		return a*b;
	}
	public int intdiv(int a, int b) throws DivideByZero{
		if(b!=0){
			return a/b;
		}
		throw new DivideByZero("Divided by zero", new DivideByZeroType());
	}
}
