/* Generated by AN DISI Unibo */ 
package it.unibo.ctxclientguiparkin
import it.unibo.kactor.QakContext
import it.unibo.kactor.sysUtil
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
	QakContext.createContexts(
	        "localhost\\clientguiparkin", this, "parkingmanagerservice.pl", "sysRules.pl"
	)
}

