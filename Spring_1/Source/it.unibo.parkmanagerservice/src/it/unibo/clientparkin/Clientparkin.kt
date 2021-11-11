/* Generated by AN DISI Unibo */ 
package it.unibo.clientparkin

import it.unibo.kactor.*
import alice.tuprolog.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
	
class Clientparkin ( name: String, scope: CoroutineScope  ) : ActorBasicFsm( name, scope ){

	override fun getInitialState() : String{
		return "initstate"
	}
	@kotlinx.coroutines.ObsoleteCoroutinesApi
	@kotlinx.coroutines.ExperimentalCoroutinesApi			
	override fun getBody() : (ActorBasicFsm.() -> Unit){
		 var SLOTNUM = 0  
		return { //this:ActionBasciFsm
				state("initstate") { //this:State
					action { //it:State
						println("Enter initstate")
					}
					 transition( edgeName="goto",targetState="waitfromclientguistate", cond=doswitch() )
				}	 
				state("waitfromclientguistate") { //this:State
					action { //it:State
						println("Enter waitfromclientguistate")
					}
					 transition(edgeName="t00",targetState="carrequeststate",cond=whenRequest("carrequest_ext"))
				}	 
				state("carrequeststate") { //this:State
					action { //it:State
						println("Enter carrequeststate")
						request("carrequest_in", "carrequest_in(X)" ,"statusactor" )  
					}
					 transition( edgeName="goto",targetState="waitforinforminstate", cond=doswitch() )
				}	 
				state("waitforinforminstate") { //this:State
					action { //it:State
						println("Enter waitforinforminstate")
					}
					 transition(edgeName="t01",targetState="waitforcarenter",cond=whenReply("informin_in"))
				}	 
				state("waitforcarenter") { //this:State
					action { //it:State
						println("Enter waitforcarenter")
					}
					 transition(edgeName="t02",targetState="carenterstate",cond=whenDispatch("carenter"))
				}	 
				state("carenterstate") { //this:State
					action { //it:State
						println("Enter carenterstate")
						request("carenterreq", "carenterreq(SLOTNUM)" ,"statusactor" )  
					}
					 transition( edgeName="goto",targetState="waitforreceipt", cond=doswitch() )
				}	 
				state("waitforreceipt") { //this:State
					action { //it:State
						println("Enter waitforreceipt")
					}
					 transition(edgeName="t03",targetState="receiptstate",cond=whenReply("receipt"))
				}	 
				state("receiptstate") { //this:State
					action { //it:State
						println("Enter receiptstate")
						forward("carenterresponse", "carenterresponse(X)" ,"clientguiparkin" ) 
					}
					 transition( edgeName="goto",targetState="waitfromclientguistate", cond=doswitch() )
				}	 
			}
		}
}