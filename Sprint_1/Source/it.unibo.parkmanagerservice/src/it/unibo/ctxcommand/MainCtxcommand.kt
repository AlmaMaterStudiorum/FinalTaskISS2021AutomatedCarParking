/* Generated by AN DISI Unibo */ 
package it.unibo.ctxcommand
import it.unibo.kactor.QakContext
import it.unibo.kactor.sysUtil
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
	QakContext.createContexts(
	        "localhost", this, "parkingmanagerservice.pl", "sysRules.pl"
	)
}

