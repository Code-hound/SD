package calc;

import static javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY;

import java.util.Map;

import javax.xml.ws.BindingProvider;

import pt.ulisboa.tecnico.sdis.ws.uddi.UDDINaming;

import java.util.Scanner;

// classes generated from WSDL
//import example.ws.PingFault_Exception;
//import example.ws.PingPortType;
//import example.ws.PingService;

public class CalcClient {

	public static void main(String[] args) throws Exception {
		// Check arguments
		if (args.length < 2) {
			System.err.println("Argument(s) missing!");
			System.err.printf("Usage: java %s uddiURL name%n", CalcClient.class.getName());
			return;
		}

		String uddiURL = args[0];
		String name = args[1];

		System.out.printf("Contacting UDDI at %s%n", uddiURL);
		UDDINaming uddiNaming = new UDDINaming(uddiURL);

		System.out.printf("Looking for '%s'%n", name);
		String endpointAddress = uddiNaming.lookup(name);

		if (endpointAddress == null) {
			System.out.println("Not found!");
			return;
		} else {
			System.out.printf("Found %s%n", endpointAddress);
		}

		System.out.println("Creating stub ...");
		CalcService service = new CalcService();
		CalcPortType port = service.getCalcPort();

		System.out.println("Setting endpoint address ...");
		BindingProvider bindingProvider = (BindingProvider) port;
		Map<String, Object> requestContext = bindingProvider.getRequestContext();
		requestContext.put(ENDPOINT_ADDRESS_PROPERTY, endpointAddress);

		try {
			int operation=-1;
			int a;
			int b;
			Scanner in=new Scanner(System.in);

			do{
				try{
			System.out.println("Choose an operation by inserting the corresponding value:\n\t0 - Exit \n\t1 - Sum\n\t2 - Subtraction\n\t3 - Multiplication\n\t4 - Division");
			operation=in.nextInt();

			switch(operation){
				case 0:
					break;
				case 1:
					System.out.print("Insert numbers to be added:\nFirst number to be added: ");
					a=in.nextInt();
					System.out.print("\tInserted: "+a +"\nSecond number to be added: ");
					b=in.nextInt();
					System.out.println("\tInserted: "+b);
					System.out.println("====>Result: "+port.sum(a,b));
					break;
				case 2:
					System.out.print("Insert numbers to be subtrated:\nFirst number to be subtracted: ");
					a=in.nextInt();
					System.out.print("\tInserted: "+a +" \nSecond number to be subtracted: ");
					b=in.nextInt();
					System.out.println("\tInserted: " + b);
					System.out.println("====>Result: "+port.sub(a,b));
					break;
				case 3:
					System.out.print("Insert numbers to be Multiplied:\nFirst number to be multiplied: ");
					a=in.nextInt();
					System.out.print("\tInserted: "+a +"\nSecond number to be multiplied: ");
					b=in.nextInt();
					System.out.println("\tInserted: " + b);
					System.out.println("====>Result: "+port.mult(a,b));
					break;
				case 4:
					System.out.print("Insert numbers to be Divided:\nFirst number to be divided: ");
					a=in.nextInt();
					System.out.print("\tInserted: "+a +"\nSecond number to be divided: ");
					b=in.nextInt();
					System.out.println("\tInserted: " + b);
					System.out.println("====>Result: "+port.intdiv(a,b));
					break;
				default: 
					operation=-1;
					break;
				}
				}catch(Exception e){
					System.out.println("\n\nCaught: "+e);
			}
			System.out.println("===================================================================");
		}while(operation!=0);

		} catch (Exception pfe) {
			System.out.println("Caught: " + pfe);
		}
	}

}
