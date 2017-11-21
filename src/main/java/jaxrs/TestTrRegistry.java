package jaxrs;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.transaction.TransactionSynchronizationRegistry;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("tsr")
@Stateless
public class TestTrRegistry {
	
	@Resource
	TransactionSynchronizationRegistry tsr;
	
	@GET
	public Response name() {
		tsr.putResource("key1", "value1");
		System.out.println(tsr.getTransactionKey());
		System.out.println("tsr.getResource('key1') - "+tsr.getResource("key1"));
		return Response.ok("TransactionSynchronizationRegistry test").build();
	}
	
	//null for the key here, works only in the same transaction
	@Path("2")
	@GET
	public Response name2() {
		System.out.println(tsr.getTransactionKey());
		System.out.println("tsr.getResource('key1') - "+tsr.getResource("key1"));
		return Response.ok("TransactionSynchronizationRegistry test").build();
	}
	
}
