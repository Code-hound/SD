package pt.upa.transporter.ws.cli;


import pt.upa.transporter.ws.TransporterPortType;
import pt.upa.transporter.ws.BadLocationFault_Exception;
import pt.upa.transporter.ws.BadPriceFault_Exception;
import pt.upa.transporter.ws.BadJobFault_Exception;
import pt.upa.transporter.ws.JobView;

import java.util.List;

public class TransporterClient {

	private TransporterPortType _tc;
	public TransporterClient(TransporterPortType tc){
			_tc=tc;
	}
	public String ping(String name){
		return _tc.ping(name);
	}


    public JobView requestJob(String origin,String destination,int price) throws BadLocationFault_Exception, BadPriceFault_Exception{
    	return null;
    }

    public JobView decideJob(String id,boolean accept) throws BadJobFault_Exception{
    	return null;
    }

   	public JobView jobStatus(String id){
   		return null;
   	}

    public List<JobView> listJobs(){
    	return null;
    }

    public void clearJobs(){

    }

}
