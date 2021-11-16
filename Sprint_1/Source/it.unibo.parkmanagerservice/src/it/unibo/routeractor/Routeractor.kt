/* Generated by AN DISI Unibo */ 
package it.unibo.routeractor

import it.unibo.kactor.*
import alice.tuprolog.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
	
class Routeractor ( name: String, scope: CoroutineScope  ) : ActorBasicFsm( name, scope ){

	override fun getInitialState() : String{
		return "initState"
	}
	@kotlinx.coroutines.ObsoleteCoroutinesApi
	@kotlinx.coroutines.ExperimentalCoroutinesApi			
	override fun getBody() : (ActorBasicFsm.() -> Unit){
		return { //this:ActionBasciFsm
				state("initState") { //this:State
					action { //it:State
						println("Enter initState")
					}
					 transition( edgeName="goto",targetState="wait", cond=doswitch() )
				}	 
				state("wait") { //this:State
					action { //it:State
						println("Enter wait")
					}
					 transition(edgeName="t019",targetState="manage_state",cond=whenRequest("plan"))
				}	 
				state("manage_state") { //this:State
					action { //it:State
						println("Enter manage_state")
						
								   var ROUTE = ""	
									
						request("route", "ROUTE" ,"driveractor" )  
					}
					 transition(edgeName="t020",targetState="manage_akn_state",cond=whenReply("akn_route"))
				}	 
				state("manage_akn_state") { //this:State
					action { //it:State
						println("Enter manage_akn_state")
					}
					 transition( edgeName="goto",targetState="wait", cond=doswitch() )
				}	 
			}
		}
}