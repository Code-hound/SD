package example.ws;

import java.util.Random;

import javax.jws.WebService;

@WebService(
    endpointInterface="example.ws.PingPortType",
    wsdlLocation="Ping.wsdl",
    name="Ping",
    portName="PingPort",
    targetNamespace="http://ws.example/",
    serviceName="PingService"
)
public class PingPort implements PingPortType {

	private Random random = new Random();

	@Override
	public String ping(String name) throws PingFault_Exception {
		int nextInt = random.nextInt(3);
		if (nextInt == 0) {
			PingFault faultInfo = new PingFault();
			faultInfo.setNumber(nextInt);
			throw new PingFault_Exception("simulated error in server", faultInfo);
		}
		return "Pong " + name + "!";
	}

}
