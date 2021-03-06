/* Generated by AN DISI Unibo */ 
package it.unibo.planneractor

import it.unibo.kactor.*
import alice.tuprolog.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
	
class Planneractor ( name: String, scope: CoroutineScope  ) : ActorBasicFsm( name, scope ){

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
					 transition(edgeName="t017",targetState="manage_state",cond=whenRequest("ready"))
				}	 
				state("manage_state") { //this:State
					action { //it:State
						println("Enter manage_state")
						
								   var PLAN	= "O,An,U,O,D"
									
						request("route", "PLAN" ,"routeractor" )  
					}
					 transition(edgeName="t018",targetState="manage_akn_state",cond=whenReply("akn_ready"))
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
