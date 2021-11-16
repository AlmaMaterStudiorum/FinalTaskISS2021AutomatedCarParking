/* Generated by AN DISI Unibo */ 
package it.unibo.statusactor

import it.unibo.kactor.*
import alice.tuprolog.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
	
class Statusactor ( name: String, scope: CoroutineScope  ) : ActorBasicFsm( name, scope ){

	override fun getInitialState() : String{
		return "initState"
	}
	@kotlinx.coroutines.ObsoleteCoroutinesApi
	@kotlinx.coroutines.ExperimentalCoroutinesApi			
	override fun getBody() : (ActorBasicFsm.() -> Unit){
		
				var SlotFreeList = mutableListOf("zero","free", "free", "free", "free", "free", "free")
				var IndoorArea = "OFF"
				var SequenceNumber = 0
				val ParkInQueue: java.util.Queue<String> = java.util.LinkedList<String>()
		        val ParkOutQueue: java.util.Queue<String> = java.util.LinkedList<String>() 
		        var Fan = "OFF"
		        var Alarm = "OFF"
		        var Trolley = "idle" // idle,working,stopped		
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
					 transition(edgeName="t09",targetState="carrequest_int_state",cond=whenRequest("carrequest_int"))
					transition(edgeName="t010",targetState="carenter_int_state",cond=whenRequest("carenter_int"))
					transition(edgeName="t011",targetState="pickup_int_state",cond=whenRequest("pickup_int"))
					transition(edgeName="t012",targetState="start_state",cond=whenDispatch("start"))
					transition(edgeName="t013",targetState="stop_state",cond=whenDispatch("stop"))
					transition(edgeName="t014",targetState="simready_state",cond=whenDispatch("simready"))
					transition(edgeName="t015",targetState="move_state",cond=whenDispatch("move"))
					transition(edgeName="t016",targetState="manage_akn_ready_state",cond=whenReply("akn_ready"))
				}	 
				state("carrequest_int_state") { //this:State
					action { //it:State
						println("Enter carrequest_int_state")
						
									var SLOTNUM = 0
									if (IndoorArea === "OFF")
									    // if no slot are free SLOTNUM = -1
									    // SLOTNUM = 0 is impossibile
						 				SLOTNUM =  SlotFreeList.indexOfFirst{ it == "free"}
									else
										SLOTNUM = -2
						answer("carrequest_int", "informin_int", "$SLOTNUM"   )  
					}
					 transition( edgeName="goto",targetState="wait", cond=doswitch() )
				}	 
				state("carenter_int_state") { //this:State
					action { //it:State
						println("Enter carenter_int_state")
						if( checkMsgContent( Term.createTerm("carenter_int(X)"), Term.createTerm("carenter_int(SLOTNUM)"), 
						                        currentMsg.msgContent()) ) { //set msgArgList
								
												var SLOTNUM = payloadArg(0).toInt()
												SequenceNumber++
												var TOKENID = "$SequenceNumber-$SLOTNUM"
												SlotFreeList[SLOTNUM] = "movingIn"
												ParkInQueue.add(TOKENID)			
												IndoorArea = "ON"
												// Check if PLAN is ready : for ex if trolley in HOME
													
						}
						answer("carenter_int", "receipt_int", "TOKENID"   )  
					}
					 transition( edgeName="goto",targetState="wait", cond=doswitch() )
				}	 
				state("pickup_int_state") { //this:State
					action { //it:State
						println("Enter pickup_int_state")
						if( checkMsgContent( Term.createTerm("pickup_int(TOKENID)"), Term.createTerm("pickup_int(TOKENID)"), 
						                        currentMsg.msgContent()) ) { //set msgArgList
								
												var TOKENID = payloadArg(0)
												var index =  SlotFreeList.indexOfFirst{ it == TOKENID}
												if (index > 0) 
												{
													ParkOutQueue.add(TOKENID)
												}
												else
												{
													//
												}
												// Check if PLAN is ready : for ex if trolley in HOME			
						}
						answer("carenter_int", "receipt_int", "TOKENID"   )  
					}
					 transition( edgeName="goto",targetState="wait", cond=doswitch() )
				}	 
				state("start_state") { //this:State
					action { //it:State
						println("Enter start_state")
						if( checkMsgContent( Term.createTerm("start(DEVICE)"), Term.createTerm("start(DEVICE)"), 
						                        currentMsg.msgContent()) ) { //set msgArgList
								
												val Action = "ON"
												var DEVICE = payloadArg(0)
												when(DEVICE)
												{
													"F" -> Fan = Action
													"A" -> Alarm = Action
													"T" -> Trolley = Action		
												}			
						}
						forward("start", "DEVICE" ,"servergui" ) 
					}
					 transition( edgeName="goto",targetState="wait", cond=doswitch() )
				}	 
				state("stop_state") { //this:State
					action { //it:State
						println("Enter stop_state")
						if( checkMsgContent( Term.createTerm("start(DEVICE)"), Term.createTerm("start(DEVICE)"), 
						                        currentMsg.msgContent()) ) { //set msgArgList
								
												val Action = "OFF"
												var DEVICE = payloadArg(0)
												when(DEVICE)
												{
													"F" -> Fan = Action
													"A" -> Alarm = Action
													"T" -> Trolley = Action		
												}				
						}
						forward("start", "DEVICE" ,"servergui" ) 
					}
					 transition( edgeName="goto",targetState="wait", cond=doswitch() )
				}	 
				state("simready_state") { //this:State
					action { //it:State
						println("Enter simready_state")
						if( checkMsgContent( Term.createTerm("simready(PDO,SDO,TDO)"), Term.createTerm("simready(PDO,SDO,TDO)"), 
						                        currentMsg.msgContent()) ) { //set msgArgList
								
												// reset inner variable e send ready to planner				
						}
					}
					 transition( edgeName="goto",targetState="wait", cond=doswitch() )
				}	 
				state("move_state") { //this:State
					action { //it:State
						println("Enter move_state")
					}
					 transition( edgeName="goto",targetState="wait", cond=doswitch() )
				}	 
				state("manage_akn_ready_state") { //this:State
					action { //it:State
						println("Enter manage_akn_ready_state")
					}
					 transition( edgeName="goto",targetState="wait", cond=doswitch() )
				}	 
			}
		}
}